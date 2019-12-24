package com.eomcs.basic.ex07.assignment;

import java.util.Arrays;

public class Test02T {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    
    // 배열에 들어 있는 값을 오름차순으로 정렬하라.
    sort(values); 
    System.out.println();
    
    for (int value : values) {
      System.out.print(value + " ");
    }
    // 출력결과:
    // -22, -3, 0, 4, 12, 22, 34, 45, 78
  }
  static void sort(int[] values) {
    for (int x = (values.length - 1); x > 0 ; x --) {//마지막 앞까지 반복
      int temp = 0;
      for (int i = 0; i < x; i++) {
        if (values[i] > values [i + 1]) {
          temp = values[i];
          values[i]=values[i + 1];
          values[i + 1]=temp; //두자리를 비교하여 큰값이 있을때 오른쪽으로 보낸다
        }
      }
    }
  }
}
