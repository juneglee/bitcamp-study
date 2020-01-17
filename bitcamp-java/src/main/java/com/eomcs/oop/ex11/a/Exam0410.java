// anonymous class - 사용전 : 로컬 클래스와 비교
package com.eomcs.oop.ex11.a;

public class Exam0410 {
  // 인터페이스 의 경우 스태틱으로 선언하지 않아도 스태틱 멤버를 사용할 수 있다

  interface A {
    void print();
  }

  public static void main(final String[] args) {
    class My implements A {
      @Override
      public void print() {
        System.out.println("Hello");
      }

    }
    final A obj = new My();
    obj.print();

    // 익명 클래스로 인터페이스 구현하기

  }
}
