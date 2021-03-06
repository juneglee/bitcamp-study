// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;



public class Exam0510 {
  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }

  }

  static interface Calculator {
    int compute(int a, int b);
  }

  public static void main(String[] args) {
    // 파라미터 개수가 다르
    Calculator c1 = MyCalculator::plus;
    Calculator c2 = MyCalculator::minus;
    Calculator c3 = MyCalculator::multiple;
    Calculator c4 = MyCalculator::divide;

    System.out.println(c1.compute(300, 200));
    System.out.println(c2.compute(300, 200));
    System.out.println(c3.compute(300, 200));
    System.out.println(c4.compute(300, 200));



  }
}


