package com.eomcs.oop.ex05.test;

public class A {
  
  int v1;
  
  A(){
   //this.v1 = 100; t생성자를 변수 
    this(100);// 다른 생성자를 가르 생성 됌
    // 같은 생성자끼리만 가능하다
    // 반드시 첫번째로 와야 한다
    System.out.println("A()");
  }
  
  A(int v1) {
    this.v1 = v1;
    System.out.println("A(int)");
  }
}
