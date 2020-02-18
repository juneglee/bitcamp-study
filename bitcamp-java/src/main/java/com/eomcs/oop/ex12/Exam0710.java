// 메서드 레퍼런스 - 생성자 메서드 레퍼런스
package com.eomcs.oop.ex12;

import java.util.ArrayList;
import java.util.List;

public class Exam0710 {
  static interface ListFactory {
    List create();
  }



  public static void main(String[] args) {
    // 인터페이스에 정의된 메서드가
    // 파라미터가 없고, 리턴 타입이 객체 일때
    // 세서드 레퍼런스로 생성자를 지정할 수 있다
    //

    ListFactory f1 = ArrayList::new;
    // 인터페이스의 메서드를 호출하면
    // 지정된 클래스의 인스턴스를 만든 후생성자가 호출된다
    List list = f1.create(); // new ArrayList();

    System.out.println(list instanceof ArrayList);
    System.out.println(list.getClass().getName());
  }
}

