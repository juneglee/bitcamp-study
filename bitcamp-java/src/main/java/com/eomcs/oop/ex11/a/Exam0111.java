// static nested class 
package com.eomcs.oop.ex11.a;

public class Exam0111 {
  // 스태틱
  static int sValue;
  int iValue;
  // 인스턴스 
  static void sm() {}
  void im() {}

  static class A {
    void m1() {
      sValue = 100;
      // iValue = 100;//error

      sm();
      // im();//error
    }
  }
  
  // 인스턴스를 사용하지 않는다면 
  // 중첩으로 적용
  public void setValue(int value) {
  }

}
