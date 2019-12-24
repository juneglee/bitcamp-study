package com.eomcs.basic.ex07.assignment;

public class Test01 {
  static int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
  
  public static void main(String[] args) {
    int value = max(values);
    System.out.println(value);
  }
  
  static int max(int[] values) {
    int max = values[0];
    for(int i = 0; i < values.length; i++) {
      if(max < values[i]) {
        max = values[i];
      }
    }
    return max;
  }
}
