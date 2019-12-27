package com.eomcs.oop.ex01.assignment;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyscan = new Scanner(System.in);

    class Score {
      String name;
      int kor;
      int eng;
      int math;
    }

    Score[] arr = new Score[3];

    System.out.println("합계를 구하고 출력하라");
    for (int i = 0; i < arr.length; i++) {
      Score s = new Score(); 

      System.out.print("입력: ");
      s.name = keyscan.next();
      s.kor = keyscan.nextInt();
      s.eng = keyscan.nextInt();
      s.math = keyscan.nextInt();

      arr[i] = s; // 입력받은 값을 다시 레퍼런스 값으로 돌려 놓는다
    }

    keyscan.close();
    System.out.println("-----------------------");

    for (int i = 0 ; i < arr.length; i++ ) {
      Score s = arr[i]; //레퍼런스 값을 인스턴스로 돌려 놓는다 
      int sum = s.kor + s.eng + s.math;
      float aver = sum/3f;
      System.out.printf("%s %d %d %d %d %.1f\n",
          s.name, s.kor, s.eng, s.math, sum, aver);
    }
  }
}
