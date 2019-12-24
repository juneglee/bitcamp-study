/*
# 과제(2018-03-13)
사용자로부터 마름모의 가로 길이를 숫자를 입력 받아 '*' 문자로 그려라. 단 마름모의 절반만 그린다.


## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
 */

package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class test02 {
  public static void main(String[] args) {
    Scanner sc =  new Scanner (System.in);

    System.out.print("마름모의 밑변 숫자를 입력: ");
    int no = sc.nextInt();

    int i1 = 1;
    while (i1 <= no-1) {
      int j = 1;
      while (j <= i1) {
        System.out.print("*");
        j++;
      }
      System.out.println();
      i1++;
    }

    int i2 = no-1;
    while (i2 >= 0) {
      int j = 0;
      while (j <= i2) {
        System.out.print("*");
        j++;
      }
      System.out.println();
      i2--;
    }
  }
}