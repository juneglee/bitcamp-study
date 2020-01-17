// local class
package com.eomcs.oop.ex11.a;

public class Exam0310 {

  int iValue;

  void m1() {
    // 로컬 클래스
    class A {
      void m1() {}
    }

    final A obj = new A();
    obj.m1();
  }

  void m2() {
    // 다른 로컬 클래스를 사용할 수 없다 = 다른 메서드의 로컬 변수도 사용할 수 없음
    // final A obj = new A();
  }


}
