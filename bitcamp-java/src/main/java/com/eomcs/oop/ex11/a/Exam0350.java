// local class - 로컬 클래스와 로컬 변수
package com.eomcs.oop.ex11.a;

public class Exam0350 {
  public static void main(final String[] args) {
    final Exam0350 obj = new Exam0350();
    obj.m1();
  }

  int iValue;

  void m1() {
    final int a = 100;
    class A {
      void m1() {
        // 로컬 클래스는 내부사용 및 fianl 사용 가능
        //
        System.out.println(a);
      }
    }

    final A obj = new A();
    obj.m1();
  }
}
