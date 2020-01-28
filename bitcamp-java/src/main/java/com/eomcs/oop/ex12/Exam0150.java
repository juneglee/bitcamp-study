// 람다(lambda) 문법 - 리턴 값이 있는 메서드
package com.eomcs.oop.ex12;

public class Exam0150 {

  static interface Calculator {
    int compute(int a, int b);
  }

  public static void main(String[] args) {
    Calculator c1 = (int a, int b) -> {
      return a + b;
    };
    System.out.println(c1.compute(200, 100));

    Calculator c2 = (a, b) -> {
      return a + b;
    };
    System.out.println(c2.compute(300, 200));

    c3 = (a, b) -> a + b;
    System.out.println(c3.compute(300, 200));

    // c3 = (a, b) -> System.out.println("hello")
    // System.out.println(c3.compute(300, 200));
  }
}


