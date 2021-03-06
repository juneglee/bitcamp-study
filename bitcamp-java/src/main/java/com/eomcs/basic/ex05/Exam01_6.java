package com.eomcs.basic.ex05;

// 산술 연산자 : 명시적 형변환과 연산 우선순위
public class Exam01_6 {
    public static void main(String[] args) {
      float r1 = 5 / 2 + 3.1f;
      //float r1 = (float) 5 /(float) 2 + 3.1f;
      // 계산 순서:
      // r1 = int(5) / int(2) + float
      // r1 = int(2) +float(3.1)
      // r1 = float(5.1)
      // => 연산 우선 순위에 따라 계산하는 순간에 암시적 형변환이 이루어진다.
      // => 모든 값을 최종 결과 타입으로 바꾸고 바꾸고 계산하지는 않는다.
      System.out.println(r1);
      
      float r2 = 3.1f + 5 / 2;
      System.out.println(r2);
    
    }
}
