package com.eomcs.oop.ex06.c;

public class C {
  // 현재 클래스에서만 접근 가능
  private void m1() {} 
  
  // 현재 클래스 + 같은 패키지 소속 클래스 
  void m2() {} // 
  
  // 현재 클래스+ 같은 패키지 클래스 + 자식(sub) 클래스 
  protected void m3() {} 
  
  // ALL
  public void m4() {}
}
