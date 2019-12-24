package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in);
    int array[] = new int[5];

    System.out.print("입력?  ");
    for(int i=0; i < array.length; i++) {
      array[i] = keyboard.nextInt();
    }

    int max = array[0]; 
    int min = array[0]; 

    for(int i = 0; i < array.length; i++) {
      // 초기값을 0으로 했기 때문에 1부터 비교하여 찾는다
      if(max < array[i]) {//max의 값보다 array[i]이 크면 
        max = array[i];
      }

      if(min > array[i]) {//min의 값보다 array[i]이 작으면 min = array[i]
        min = array[i];
      }
    }
    System.out.printf("최소값 : %d\n최대값 : %d", min, max);
    keyboard.close();
  }
}