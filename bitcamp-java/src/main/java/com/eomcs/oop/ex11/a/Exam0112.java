// static nested class 
package com.eomcs.oop.ex11.a;

public class Exam0112 {
  static int sValue;
  int iValue;
  static void sm() {}
  void im() {}

  
  static class A {
    void m1() {
    }
  }
  
  static void m1() {
    // 스태틱 맴버이기 떄문에 다른 스태틱 멤버가 사용할 수 있다 
  }
  
  void m2() {
    // 인스턴스 멤버는 스태틱 맴버를 사용할 수 있
  }

  public void setValue(int value) {
  }

}
