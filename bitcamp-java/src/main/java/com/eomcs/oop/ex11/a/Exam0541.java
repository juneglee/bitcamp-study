// anonymous class - 익명 클래스가 놓이는 장소 : 파라미터 + 람다 문법
package com.eomcs.oop.ex11.a;

public class Exam0541 {

  interface A {
    void print();
  }

  public static void main(final String[] args) {
    final Exam0541 r = new Exam0541();
    r.m1(() -> System.out.println("hello"));
  }

  void m1(final A obj) {
    obj.print();
  }
}
