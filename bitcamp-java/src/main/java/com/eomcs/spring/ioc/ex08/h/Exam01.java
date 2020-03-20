// 의존 객체 주입 자동화하기 - 같은 타입의 의존 객체가 여러개 있을 때; @Qualifier 애노테이션
package com.eomcs.spring.ioc.ex08.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {

  public static void main(String[] args) {

    // 같은 타입의 의존 객체가 여러 개 있을 때
    // 그 중 어떤 객체를 주입해야 할 지 알 수 없기 때문에
    // Spring IoC 컨테이너는 예외를 발생시킨다.
    //
    // 해결책?
    // => @Qualifier 애노테이션을 사용하여 주입할 객체를 지정한다.
    // 주의!
    // => annotation.AutowiredAnnotationBeanPostProcessor는 @Qualifier 애노테이션을 처리하지 못한다
    // => 따라서 @Qualifier 애노테이션을 처리할 BeanPostProcessor를 따로 등록하면 된다.
    //
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex08/h/application-context.xml");

    SpringUtils.printBeanList(iocContainer);

    System.out.println(iocContainer.getBean("c1"));
  }

}


