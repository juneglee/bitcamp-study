// anonymous class - 슈퍼 클래스의 오버라이딩 하기
package com.eomcs.oop.ex11.a;

public class Exam0450 {
  // 클래스는 스태틱으로 선언해야만 스태틱 맴버에 접근가능
  static class A {
    String name;

    public A() {
      name = "이름 없음";
    }

    public A(final String name) {
      this.name = name;
    }

    public void print() {
      System.out.println("Hello2");
    }

  }

  public static void main(final String[] args) {
    A obj = new A() {};
    obj.print();

  public void print() {
    System.out.printf("%s 방가", name);
  }
}
