// anonymous class - 람다 문법 사용
package com.eomcs.oop.ex11.a;

public class Exam0421 {

  interface A {
    void print();
  }

  public static void main(final String[] args) {
    // 람다 문법으로 인터페이스 구현하기
    // 문법
    // 인퍼페이스명 레퍼런스 = (파라미터,....)-> {...}
    //
    final A obj = () -> System.out.println("람다 Hello");
    obj.print();
  }
}
