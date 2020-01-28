package com.eomcs.oop.ex09.g;

public interface A {
  public abstract void m1();
  // 새로 규칙을 추가하면 기존의 클래스의 영향을 미친다

  // default void m2() {}
  // 기존의 클래스의 영향을 미치지 않으면서 규칙을 새로이 만들 수 있다
  default void m2() {}

  static void m3() {
    System.out.println("오호라 ~ 인터페이스도 스태틱 메서드를 가질 수 있네 ");
  }

}
