package com.eomcs.basic.ex07.assignment;

import java.util.ArrayList;

public class Test03T {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    // 절반을 나누어서 바꾸어준다

    // 배열의 들어 있는 값의 순서를 꺼꾸로 바꿔라.

    reverse(values);
    printValues(values);
    // 출력결과:
    // -22, 0, 45, 22, 12, 78, -3, 4, 34
  }

  static void reverse(int[] values) {
    int count = values.length >> 1;//나누기 2 (절반만 반복한다)
    int temp = 0;
    for (int i = 0, j = values.length-1;  i < count; i++, j--){
      temp = values[i];
      values[i] = values[j];
      values[j] = temp;
      System.out.printf("%3d ", values[i]);
      /*
      int temp = 0;
      int endPos = values.length - 1; //필기시험 : 빈칸
      for (int i = 0;  i < count; i++){
       temp = values[i];
       values[i] = values[endPos-1];//필기시험 : 빈칸
       values[endPos-1] = temp;//필기시험 : 빈칸

       */
    }
    System.out.println();

  }
  static void printValues(int[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.printf("%3d ", values[i]);
    }
  }
}

