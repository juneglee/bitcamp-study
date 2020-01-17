// anonymous class - 익명 클래스가 놓이는 장소 : 로컬 변수
package com.eomcs.oop.ex11.a;

public class Exam0530 {

  interface A {
    void print();
  }
  void m1() {

    A obj = new A() {
      public void print() {
        System.out.println("hello");
      }
    };
    obj.print();
    
    
  }
  public static void main(String[] args) {
    Exam0530 r = new Exam0530();
    r.m1();
  }
}