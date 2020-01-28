// 람다(lambda) 문법
package com.eomcs.oop.ex12;

public class Exam0330 {

  // 인터페이스
  static interface Calculator {
    int compute(int start, int end);
  }

  // 구현객체???
  static void test(Calculator c) {
    System.out.printf("합계: %d \n", c.compute(1, 10));
  }

  // main에서 정의를 한후에 test에 Calculator 넘겨주고
  // test가 실행할때 내부에서 받은 Calculator에 따라 실행한다

  // 실행 코드
  public static void main(String[] args) {
    test((a, b) -> {
      int sum = 0;
      for (int i = 0; i <= b; i++) {
        sum += i;
      }
      return sum;
    });
  }
}


