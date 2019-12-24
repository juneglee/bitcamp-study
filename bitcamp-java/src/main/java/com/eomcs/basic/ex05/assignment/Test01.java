package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;
public class Test01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in); 
           
    System.out.print("입력?  ");
    int no1 = keyboard.nextInt();//next 자르는 의미
    int no2 = keyboard.nextInt();
    
    int sum = 0;
    for (int i = no1 ; i <= no2 ; i++ ) {
      sum += i; 
    }
    /*
    int sum = 0;
    int no = start;
    while (no <= end) {
      sum = sum + no;
      no = no + 1;
    }
     */
    System.out.printf("%d에서 %d까지 합은 %d입니다", no1, no2, sum);
    
    keyboard.close();
  }
}
