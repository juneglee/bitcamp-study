// local class - 로컬 클래스와 로컬 변수
package com.eomcs.oop.ex11.a;

public class Exam0353 {
  public static void main(final String[] args) {
    final Exam0353 obj = new Exam0353();
    obj.m1();
  }

  int iValue;

  void m1() {
    class A {

      void m1() {
        // 로컬 클래스에서 바깥 메서드의 로컬 변수를 사용할 때는
        // final 변수로 간주하기 때문에 값을 변경 할 수 없다
        // a = 200; // 컴파일 오류

        // 단지 값을 조회하는 용도로 사용하는 것이다
        // why? 메서드 호출이 끝날때 제거 되기 때문이다

      }
    }

    final A obj = new A();
    obj.m1();
  }
}
