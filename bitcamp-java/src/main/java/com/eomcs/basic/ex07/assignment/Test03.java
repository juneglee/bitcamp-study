package com.eomcs.basic.ex07.assignment;

import java.util.ArrayList;

public class Test03 {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};

    // 배열의 들어 있는 값의 순서를 꺼꾸로 바꿔라.

    reverse(values);
    System.out.println();

    for (int value : values) {
      System.out.print(" " + value);
    }
    // 출력결과:
    // -22, 0, 45, 22, 12, 78, -3, 4, 34
  }

  static void reverse(int[] values) {
    for (int i = 0; i < (values.length)/2 ; i++) {
      //절반으로 나누어서 바꾸어 주기 때문에 나누기 2를 한다
      int max = (values.length- i) -1; //6-0-1 , 6-1-1, 6-2-1
      int temp = 0;
      temp = values[i];
      values[i] = values[max];
      values[max] = temp;
  }
  
  }
}

