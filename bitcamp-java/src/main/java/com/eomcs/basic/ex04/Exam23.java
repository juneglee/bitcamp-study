package com.eomcs.basic.ex04;

// 변수의 크기와 리터럴의 크기
public class Exam23 {
  public static void main(String[] args){
    // 크기가 다른 변수끼리 값 저장하기
    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;

    byte b2;
    short s2;
    int i2;
    long l2;

    // 변수의 값이 같더라도 메모리의 크기가 다르기 때문에 컴파일 오류가 발생할 수 있다. 
    //b2 = l; byte < long
    //s2 = l; short < long
    //i2 = l; int < long
    l2 = l;
    
    //b2 = i; byte < int
    //s2 = i; short < int
    i2 = i;
    l2 = i;

    //b2 = s;  byte < short 
    s2 = s;
    i2 = s;
    l2 = s;

    b2 = b;
    s2 = b;
    i2 = b;
    l2 = b;
    

  }
}