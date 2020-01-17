// anonymous class - 호출할 수퍼 클래스의 생성자 지정하기
package com.eomcs.oop.ex11.a;

public class Exam0440 {
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
    // 익명 클래스를 정의할 때 호출할 수퍼 클래스의 생성자를 지정할 수 있다
    // 문법
    // new 수퍼 클래스명 (파라미터,...) {}
    // 즉 생성자에 넘겨주는 파라미터로 호출될 생성자를 지정
    A obj = new A() {};
    obj.print();

    obj = new A("홍길동") {};
    obj.print();

    // obj = new A(100) {};
    // 익명 클래스로 인터페이스 구현하기

  }
}
