package com.eomcs.basic.ex04;

// 상수
public class Exam62 {
  public static void main(String[] args){
    int a;
    
    a = 100;
    a = 200;
    
    //변경하지 못하게 하는 문법
    // => final 데이터타입 변수
    final int b;
    b=100;
    
    final int c = 100;
    //c = 200;
    
  }
}