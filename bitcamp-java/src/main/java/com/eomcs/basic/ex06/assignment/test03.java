/*
# 과제(2018-03-13)
사용자로부터 정삼각형 밑변의 길이를 숫자를 입력 받아 '*' 문자로 그려라.

## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
```
 */

package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class test03 {
  public static void main(String[] args) {
    Scanner sc =  new Scanner (System.in);

    System.out.print("정삼각형의 밑변 숫자를 입력: ");
    int no = sc.nextInt();
    
    if(no % 2 == 0)
      no -- ;
    
    int spaceSize = no >> 1;
    int i = 1;
    while (i <= spaceSize) {
      if (no % 2 == 0) {
        continue;
      }
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
      System.out.println();
      i++;
    }
  }
}