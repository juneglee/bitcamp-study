//역 직삼각형 

package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class test04 {
  public static void main(String[] args) {
    Scanner sc =  new Scanner (System.in);

    System.out.print("정삼각형의 밑변 숫자를 입력: ");
    int no = sc.nextInt();

    int i = 1;
    while (i <= no) {
      int j1 = i;
      while (j1 < no) {
        System.out.print(" ");
        j1++;
      }
      int j2 = 0;
      while (j2 < i*2-1) {
        System.out.print("*");
        j2++;
      }
      /*
      int j2 = 0;
      while (j2 < i) {
        System.out.print("*");
        j2++;
      }
      int j3 = 0;
      while (j3 < i - 1) {
        System.out.print("*");
        j3++;
      }
      */
      System.out.println();
      i++;
    }
  }
}