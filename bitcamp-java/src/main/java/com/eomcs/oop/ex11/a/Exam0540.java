// anonymous class - 익명 클래스가 놓이는 장소 : 파라미터
package com.eomcs.oop.ex11.a;

public class Exam0540 {

  interface A {
    void print();
  }
  void m1(A obj) {
    obj.print();
  }
    
  public static void main(String[] args) {
    Exam0540 r = new Exam0540();
    r.m1(new A(){
      public void print() {
        System.out.println("hello");
      }
    });
  }
}