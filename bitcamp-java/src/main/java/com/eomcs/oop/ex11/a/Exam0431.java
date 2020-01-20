// anonymous class - 람다 문법 사용
package com.eomcs.oop.ex11.a;


public class Exam0431 {
  // 클래스는 스태틱으로 선언해야만 스태틱 맴버에 접근가능
  static abstract class A {

    public abstract void print();
  }

  public static void main(final String[] args) {
    // 클래스에 대해서는 람다 문법을 사용할 수 없다
    final A obj = () -> System.out.println("Hello2");// 컴파일오류
    obj.print();
  }
}

