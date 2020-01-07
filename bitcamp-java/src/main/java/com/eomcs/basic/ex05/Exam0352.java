package com.eomcs.basic.ex05;

// 비트연산자 & 를 이용하여 % 구현하기 응용 

public class Exam0352 {
  public static void main(String[] args) {
    // %를 이용하여 짝수/홀수 알아내기
    System.out.println(57 % 2 == 0 ? "짝수": "홀수"  );
    System.out.println((57 & 0x1) == 0 ? "짝수": "홀수"  );
  }
}
