// anonymous class - 익명 클래스가 놓이는 장소 : 스태틱 필드
package com.eomcs.oop.ex11.a;

public class Exam0510 {

  interface A {
    void print();
  }
  static A obj = new A() {
    public void print() {
      System.out.println("hello");
    }
  };
}
