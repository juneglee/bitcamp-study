package com.eomcs.basic.ex06.assignment;

public class Graphic {

  static void drawLine(int length){ 
    int j = 1;
    while (j++ <= length) {
      System.out.print("*");
    }

  }
  static void drawLine(int length, char ch){  
    int x = 0;
    while (x++ < length) {
      System.out.print("*");
    }
  }
}
// 오버로딩 : 이름은 같지만 다른 기능을 수행 