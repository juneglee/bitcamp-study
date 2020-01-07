package com.eomcs.oop.ex06.c;

public class D2 extends D {
  @Override
  void m() {
    System.out.println("D2의 m()");
  }

  void test() {
    // this 레퍼런스로 메서드를 호출하면,
    // 현재 클래스부터 메서드를 찾아 호출한다.
    // 현재 클래스에 메서드가 없으면 슈퍼 클래스에서 메서드를 찾는다 
    // 메서드를 찾을 떄까지 최상위로 올라간다 
    this.m();
    
    // 슈퍼 레퍼런스로 메서드를 호출하면 
    // 슈퍼클래스에 없으면 그 상위 클래서로 따라 올라간다
    // 만약 오버라이딩 하기 전에 메서드를 호출하고 싶을 때 유용하다 
    super.m();
  }
}






