//역 직사각형 

package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class test05 {
  public static void main(String[] args) {
    Scanner keyscan =  new Scanner (System.in);

    System.out.print("입력  ");
    int no = keyscan.nextInt();

    int i = 1;
    while (i <= no) { //감소를 할때는 등호를 확인해야 한다 
      int j2 = no-1;
      while (j2-- >= i) { // 증감 연산자를 내부에 사용할 수 있다
        System.out.print(" "); 
      }
      int j1 = 1;
      while (j1++ <= i) { 
       System.out.print("*");
       }
      System.out.println();
      i++; // 증감 연산자를 내부와 외부에 사용할 수 있따
    }
    keyscan.close();
  }
}