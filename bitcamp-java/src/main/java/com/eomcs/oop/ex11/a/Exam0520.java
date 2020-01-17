// anonymous class - 익명 클래스가 놓이는 장소 : 인스턴스 필드
package com.eomcs.oop.ex11.a;

public class Exam0520 {

  interface A {
    void print();
  }
   A obj = new A() {
    public void print() {
      System.out.println("hello");
    }
  };
}
