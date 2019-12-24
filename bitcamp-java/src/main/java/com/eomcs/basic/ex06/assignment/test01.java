/*
# 과제(2018-03-13)
사용자로부터 직삼각형의 밑변 숫자를 입력 받아 '*' 문자로 그려라. 

## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
 */

package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class test01 {
  public static void main(String[] args) {
    Scanner sc =  new Scanner (System.in);

    System.out.print("직삼각형의 밑변 숫자를 입력: ");
    int no = sc.nextInt();

    int i = 1;
    while (i <= no) {
      int j = 1;
      while (j <= i) {
        System.out.print("*");
        j++;
      }
      System.out.println();
      i++;
    }
  }
}