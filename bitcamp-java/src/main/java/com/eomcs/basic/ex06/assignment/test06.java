//사다리꼴 

package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class test06 {
  public static void main(String[] args) {
    Scanner keyscan =  new Scanner (System.in);

    System.out.print("입력  ");
    int no = keyscan.nextInt();

    int i = 1;
    while (i <= no) {
      int j2 = no-1;
      while (j2-- >= i) {
        System.out.print(" "); 
      }
      int j1 = 1;
      while (j1++ <= no) { //i값을 받을 떄와 입력 값으 차이를 파악 해라 
       System.out.print(" * ");
       }
      System.out.println();
      i++;
    }
    keyscan.close();
  }
}