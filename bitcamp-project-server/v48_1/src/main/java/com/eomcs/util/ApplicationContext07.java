package com.eomcs.util;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.ibatis.io.Resources;

// 역할 :
// - 클래스를 찾아 객체를 생성한다
// - 객체가 일을 하는데 필요로하는 의존 객체를 주입한다.
// - 객체 생성과 소멸을 관리한다
//
public class ApplicationContext07 {

  // 클래스 이름 담을 저장소
  ArrayList<String> classNames = new ArrayList<>();

  // @Component 애노테이션 붙은 클래스를 담을 저장소
  ArrayList<Class<?>> componentClasses = new ArrayList<>();

  // 객체 저장소
  HashMap<String, Object> objPool = new HashMap<>();

  public ApplicationContext07(String packageName, Map<String, Object> beans) throws Exception {

    // Map 객체에 들어 있는 객체를 먼저 객체풀에 보관한다.
    Set<String> keySet = beans.keySet();
    for (String key : keySet) {
      objPool.put(key, beans.get(key));
    }

    // 그런 후 패키지의 클래스를 찾아 인스턴스를 만들고 보관한다.

    // 패키리지의 실제 파일 시스템 경로를 알아낸다.
    File path = Resources.getResourceAsFile(//
        packageName.replace('.', '/')); // 패키지명을 파일 시스템 경로로 전달한다


    // 해당 경로를 뒤져서 모든 클래스의 이름을 알아낸다.
    findClasses(path, packageName);

    // 클래스 이름으로 클래스를 로딩한다
    // @componentClass
    prepareComponentClasses();

    // concrete class의 객체를 생성한다
    // concrete class의 생성자를 호출할 때 의존 객체를 함꼐 주입한다.
    // 의존 객체 또한 객체풀에서 찾아 주입한다.
    // 객체풀에 의존 객체가 없으면 생성하여 주입한다.

    for (Class<?> clazz : componentClasses) {
      try {
        createInstance(clazz);
      } catch (Exception e) {
        System.out.printf("%s 클래스의 객체를 생성할 수 없습니다.\n", clazz.getName());
      }
    }
  }

  public void printBeans() {
    System.out.println("-----------------------------------------------");
    Set<String> beanNames = objPool.keySet();
    for (String beanName : beanNames) {
      System.out.printf("%s =====> %s\n", //
          beanName, // 객체 이름
          objPool.get(beanName).getClass().getName());// 클래스명
    }
  }

  // 객체를 한 개 등록한다
  public void addBean(String name, Object bean) {
    objPool.put(name, bean);
  }

  // 지정한 패키지의 객체를 모두 등록한다.
  public void addBean(String packageName) {

  }

  // 객체 이름으로 객체를 찾아 꺼내준다
  public Object getBean(String name) {
    return objPool.get(name);
  }



  private void prepareComponentClasses() throws Exception {
    // 객체를 생성할 수 있는 콘크리드 클래스 생성
    // 클래스 이름으로 객체를 생성한다
    for (String className : classNames) {

      // 클래스 이름으로 클래스 정보를 가져온다.
      Class<?> clazz = Class.forName(className);
      if (!isComponentClass(clazz)) {
        continue;// @component 애노테이션이 붙지 않는 경우 건너 뛴다
      }
      componentClasses.add(clazz);
    }
  }


  private Object createInstance(Class<?> clazz) throws Exception {


    // 클래스의 생성자 정보를 알아낸다
    Constructor<?> constructor = clazz.getConstructors()[0]; // 생성자를 하나 있다고 가정

    // 생성자의 파라미터 정보를 알아낸다
    Parameter[] params = constructor.getParameters();

    // 생정자에 넘겨 줄 파라미터 객체를 생성한다
    ArrayList<Object> values = new ArrayList<>();
    for (Parameter param : params) {
      values.add(getParameterInstance(param)); // 파라미터의 해당하는 인스턴스를 담는다.
    }

    // 생성자를 호출하여 객체를 준비한다.
    Object obj = constructor.newInstance(values.toArray());
    // System.out.printf("%s 객체를 생성하였음!\n ", clazz.getSimpleName());

    // 생성된 객체는 객체풀에 보관한다
    objPool.put(getBeanName(clazz), obj);
    return obj; // 나중에 쓸일을 대비해서 리턴
  }

  private String getBeanName(Class<?> clazz) {
    Component comAnno = clazz.getAnnotation(Component.class);
    if (comAnno == null || comAnno.value().length() == 0) {
      // @Component 애노테이션이 없거나 이름을 지정하지 않았으면
      // 클래스 이름의 빈의 이름으로 사용한다
      return clazz.getName();
    }
    return comAnno.value();
  }


  private Object getParameterInstance(Parameter param) throws Exception {
    Collection<?> objs = objPool.values();

    // 먼저 객체 보관소에 파라미터 객체가 있는지 검사한다
    for (Object obj : objs) {
      // 있으면, 같은 객체를 또 만들지 않고 기존의 생성된 객체를 리턴한다
      if (param.getType().isInstance(obj)) {
        return obj;
      }
    }
    // 없으면, 파라미터 객체를 생성한다.
    // 단, 현재 클래스 이름으로 등록된 객체에 대해서만 파라미터 객체를 생성할 수 있다
    Class<?> clazz = findParameterClassInfo(param.getType());
    if (clazz == null) {
      // 해당파라미터에 해당하는 적절한 클래스를 찾지 못했으면
      // 파라미터 객체를 생성할 수 없다
      return null;
    }

    return createInstance(clazz);
  }

  // 생성자의 파라미터가 없으면 객체를 만들어 리턴하지만, 만들 수 있는 객체여야 한다.
  // 인터페이스와 클래스 둘중에 하나
  private Class<?> findParameterClassInfo(Class<?> paramType) {

    // concrete class 목록에서 파라미터에 해당하는 클래스가 있는지 조사한다.
    for (Class<?> clazz : componentClasses) {
      if (paramType.isInterface()) {
        // 파라미터가 인터페이스라면
        // 각각의 클래스에 대해 인터페이스를 구현헀는지 검사한다
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> interfaceInfo : interfaces) {
          if (interfaceInfo == paramType) {
            return clazz;
          }
        }
      } else if (isType(clazz, paramType)) {
        // 파라미터가 인터페이스라면
        // 각각의 클래스에 대해 같은 타입이거나 슈퍼클래스인지 검사한다.
        return clazz;

      }
    }
    // 파라미터에 해당하는 타입이 concrete class 목록에 없다면
    // 그냥 null을 리턴한다.
    return null;
  }

  private boolean isType(Class<?> clazz, Class<?> target) {
    // 슈퍼클래스로 따라 올라가면서 같은 타입인지 검사한다.
    if (clazz == target) {
      return true;
    }

    if (clazz == Object.class) {
      // 더 이상 상위 클래스가 없다면,
      return false;
    }

    return isType(clazz.getSuperclass(), target);
  }

  public boolean isComponentClass(Class<?> clazz) {
    if (clazz.isInterface() // 인터페이스인 경우
        || clazz.isEnum() // Enum 타입인 경우
        || Modifier.isAbstract(clazz.getModifiers()) // 추상 클래스인 경우
    ) {
      return false; // 이런 클래스 객체를 생성할 수 없기 때문에 건너 뛴다
    }

    // 클래스에서 @component 애노테이션 정보를 추출한다
    Component comAnno = clazz.getAnnotation(Component.class);
    if (comAnno == null) {
      return false;
    }
    // 오직 애노테이션 이 붙은 일반 클래스만이 객체 생성 대상이다.
    return true;
  }



  private void findClasses(File path, String packageName) {
    File[] files = path.listFiles(new FileFilter() {

      @Override
      public boolean accept(File file) {
        if (file.isDirectory() || //
        (file.getName().endsWith(".class") && //
        !file.getName().contains("$")))
          return true;
        return false;
      }
    });
    for (File f : files) {
      String classOrPackageName = //
          packageName + "." + f.getName().replace(".class", "");
      if (f.isFile()) {
        // System.out.println("ApplicationContext: " + f.getName());
        classNames.add(classOrPackageName);
      } else {
        findClasses(f, classOrPackageName);
      }
    }
  }
}
