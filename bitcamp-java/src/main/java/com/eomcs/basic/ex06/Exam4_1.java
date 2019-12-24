package com.eomcs.basic.ex06;

//# 흐름 제어문 - for 반복문
//
public class Exam4_1 {
  public static void main(String[] args) {
    // for (변수선언 및 초기화; 조건; 증감문) 문장;
    // for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

    // for 문의 전형적인 예
    for (int i = 1; i <= 5; i++) 
      System.out.println(i);
    
    //for 문에서 선언한 변수는  그 for문 안에서만 사용할 수 있다.
    // i = 200;
    // System.out.println(i);//컴파일 오류
    
    // 반드시 안에서 변수선언(초기화) 및 조건, 증감문을 쓸 필요 없다
    // 비워두는 것은 되지만 세미콜론을 빼면 안된다
    System.out.println("----------------------");
    for (int i = 1; i <= 5;) {
      System.out.println(i);
      i++; 
    }

    System.out.println("----------------------");
    int i = 1;
    for (; i <= 5;) {
      System.out.println(i);
      i++; 
    }
    System.out.println(i);// 이때 가능하다, 변수를 밖에다 써야할때 

    System.out.println("----------------------");
    i = 1;
    for (;;) {
      if (i > 5)
        break;
      System.out.println(i);
      i++; 
    }

  }
}
