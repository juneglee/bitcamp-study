package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 n! 을 계산하라.
// 실행)
// 입력? 5
// 5! = 1 * 2 * 3 * 4 * 5 = 120
//
public class Test04 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    // 사용자로부터 정수 값을 입력 받는다.
    int n = 0;
    System.out.print("입력 ? ");
    n = keyboard.nextInt();
 

    // n! 을 계산한다.
    System.out.print(n+"!" + " = ");
    int result = factorial(n);
    for (int i = 1; i < n; i++) {
      System.out.print(i + " * " );
    }
    System.out.printf(" %d = %d ",n,result);
    // 결과 값을 출력한다.
  }

  static int factorial(int n) {
    if (n == 1)
      return 1;

    return n * factorial(n - 1); 
  }
}


