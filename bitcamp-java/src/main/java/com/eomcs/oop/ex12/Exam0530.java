// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;



public class Exam0530 {
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

  // 리턴 타입 int ==> XXXX
  static interface Calculator1 {
    double compute(int a, int b);
  }


  static interface Calculator2 {
    float compute(int a, int b);
  }


  static interface Calculator3 {
    short compute(int a, int b);
  }


  static interface Calculator4 {
    void compute(int a, int b);
  }

  static interface Calculator5 {
    Object compute(int a, int b);
  }

  static interface Calculator6 {
    String compute(int a, int b);
  }

  public static void main(String[] args) {
    Calculator1 c1 = MyCalculator::plus; // int > double
    System.out.println(c1.compute(100, 200));

    Calculator2 c2 = MyCalculator::plus; // int > float
    System.out.println(c2.compute(100, 200));

    // Calculator3 c3 = MyCalculator::plus; // int > short

    Calculator4 c4 = MyCalculator::plus; // int > void
    c4.compute(100, 200); // plus() 메서드의 리턴 값은 무시한다

    Calculator5 c5 = MyCalculator::plus; // int > Object , auto - boxting (integer로 가능)
    System.out.println(c5.compute(100, 200));

    // Calculator6 c6 = MyCalculator::plus; // int > String

    // => 메서드 레퍼런스 저장할 때 리턴 타입의 규칙
    // 1) 같은 리턴 타입이여야 한다
    // 2) void
    // 3) 암시적 형변환 가능한 타입
    // 4) auto - boxting 가능한 타입



  }
}


