package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 직삼각형을 출력하라.
// 실행)
// 밑변의 길이? 5
// *
// **
// ***
// ****
// *****
//
public class Test05 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("밑변의 길이? ");
    int no = keyboard.nextInt();
    
    int base = 0;
      
    for (int i = base; i < no; i++ ) {
      System.out.println();
      for (int j = 0; j <= i; j++ ) {
        System.out.print("*");
      }
    }
  }
  
  static int printTriangle(int base) {
    if (base == 1)
      return 1;
    
    return base + printTriangle(base - 1);
  }
}





