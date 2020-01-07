package com.eomcs.oop.ex08.test;

public class B { //클래스 종류는 4가지가 있을 수 있다
  // 클래스는 로딩될때 바로 스태틱 실행
  // 인스턴스 메모리를 만들고 실행
  
  // field
  int a1;
  static int a2; // 클래스 필드 = 스태틱 필드
  String b; // 인스턴스 필드 = 논 스태틱 필드

  // method
  void m1() {}
  static void m3() {} // 클래스 메서드 = 스태틱 메서드  
  int m2() {return 0;} // 인스턴스 메서드 = 논 스태틱 메서드

  // initializer block
  {} // 인스턴스 블록 // 클래스가 로딩될때 실행
  static {} // 클래스 블록 

  // constructor :클래스 이름과 같다 / 생성자는 스태틱이 안붙는다 
  B() {}
  
  // nested class
  static class B1 {}
  class B2 {}
}
