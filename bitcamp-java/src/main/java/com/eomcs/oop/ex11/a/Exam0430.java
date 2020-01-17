// anonymous class - 추상 클래스 상속
package com.eomcs.oop.ex11.a;

public class Exam0430 {
  // 클래스는 스태틱으로 선언해야만 스태틱 맴버에 접근가능
  static abstract class A {

    public abstract void print();
  }

  public static void main(final String[] args) {
    // 클래스를 상속 받는 익명 클래스 만들기
    // 문법
    // 클래스명 레퍼런스 = new 클래스명 () {}'
    final A obj = new A() {
      @Override
      public void print() {
        System.out.println("Hello2");
      }
    };
    obj.print();

    // 익명 클래스로 인터페이스 구현하기

  }
}
