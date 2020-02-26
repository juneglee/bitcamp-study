package com.eomcs.lms.dao.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

// 서브 클래스에게 공통 필드나 메서드를 상속해주는 역학을 하기 때문에
// => abstract
// 서브 클래스에게 상속해주는 메서드중에서 indexof()처럼 구현되지 안흔 메서드가 있기때문에
// => abstract
public abstract class AbstractJsonFileDao<T> {
  // board.member.lesson 모두 사용하기 위해서 <T>타입 사용
  protected String filename;
  protected List<T> list;

  // 담을 공간을 생성자를 통해서 받겠다
  public AbstractJsonFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();// 객체가 생성될때 로딩하겠다
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  protected void loadData() {
    File file = new File(filename);

    // 문자열로 입력하기 위한 방법
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {

      // 현재 클래스의 정보를 알아낸다
      Class<?> currtype = this.getClass();
      System.out.println(currtype);

      // 제네릭 타입의 수퍼 클래스 정보를 알아낸다
      Type parentType = currtype.getGenericSuperclass();
      System.out.println(parentType);

      // 수퍼 클래스의 타입 파라미터 중에서 T값을 추출한다
      // => 수퍼 클래스가 제네릭이 적용된 경우 실제 타입은 다음과 같다
      ParameterizedType parentType2 = (ParameterizedType) parentType;

      // 제네릭 슈퍼 클래스 정보로부터 "타입 파라미터" 목록을 꺼낸다
      // 예를 들어 수퍼 클래스가 다음과 같다면
      // class My(T,S,U,V> {...}
      // 타입 파라미터 목록은 T,S,U,V의 목록이다
      // => 그런데 AbstractJsonFileDao 클래스는 타입 파라미터가 한 개이다
      // => 따라서 리턴되는 배열에는 T 타입 정보가 한개이다
      Type[] typeParams = parentType2.getActualTypeArguments();

      // 여기에서 우리가 관심있는 것은 T타입 정보이다
      // 배열 0번 방에 있다
      Type itemType = typeParams[0];
      System.out.println(itemType);

      // T가 실제 어떤 타입인지 알아냈으면, 이것을 가지고 배열을 만들자
      // - 크기가 0인 배열을 생성한다
      // - 실제 배열을 사용하려는 것이 아니라 배열의 타입을 꺼내기 위함이다
      T[] arr = (T[]) Array.newInstance((Class) itemType, 0);


      // T 타입의 배열 정보를 가지고 Json 데이터를 읽는다
      // 리턴 값은 실제 T 타입의 객체가 들어 있는 배열이다
      T[] dataArr = (T[]) new Gson().fromJson(in, arr.getClass());
      for (T b : dataArr) {
        list.add(b);
      }

      // @SuppressWarnings("serial")
      // TypeToken<ArrayList<T>> typeToken = new TypeToken<ArrayList<T>>() {};
      // TypeToken 이라는 추상 클래스를 상속 받은 서브 클래스를 정의
      // > 이 타입의 객체를 한번만 사용할 것이기 때문에 익명 클래스로 정의한다
      // > 따라 상속 받은 메서드를 오버라이딩 할 필요가 없다
      // Type type = typeToken.getType(); // import java.lang.reflect.Type;
      // 배열을 사용하기 위해서 타입을 정해야한다
      // list = new Gson().fromJson(in, type);
      // Reader를 던져주면 알아서 읽어서 넘겨준다
      System.out.printf("총 %d 개의 객체를 로딩했습니다.\n", list.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  protected void saveData() {
    File file = new File(filename);

    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(list));
      System.out.printf("총 %d 개의 객체를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }

  protected abstract <K> int indexOf(K key);
  // <K>의 선언은 두가지 이다
  // 사용할 곳에 바로 저장하는 것과, class에서 선언하는 방법 <T, K>

  // 서브 클래스들의 공통 메서드이기
  // => 수퍼 클래스에 정의한다
  // 서브 클래스에 접근할 수 있어야 하기 때문에
  // => protected
  // 서브 클래스마다 구현 방법이 다르기 때문에
  // => abstract (수퍼클래스에서 구현할 수도 없고, 구현해 봐야 소용없다.)
  // 서브 클래스에서 반드시 구현해야할 메서드이기 때문에
  // => abstract

  // getNo은 현재의 클래스들에는 있지만,
  // 만약 문자로 된 클래스가 있다면 찾을 수 없다

}
