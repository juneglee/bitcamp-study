package com.eomcs.basic.ex04;

// 정수 변수 - 메모리 크기
public class Exam21 {
  public static void main(String[] args){
    byte b; //1바이트(8비트)
    b = -128;
    b = 127;

    // b = -129;//오류
    // b =  128;

    short s; //2바이트(16비트)
    s = -32768;
    s = 32767;

    //s = -32769;
    //s = 32768;
    
    int i; //4바이트(32비트)
    i = -21_0000_0000;
    i = 21_0000_0000;

    // i = -22_0000_0000;
    // i = 22_0000_0000;

    long l; //8바이트(64비트)
    l = - 922_0000_0000_0000_0000L;
    l = 922_0000_0000_0000_0000L;

    // l = - 923_0000_0000_0000_0000L; 8바이트 이상의 크기는 별도의 도구를 이용하여 처리한다
    // l = 923_0000_0000_0000_0000L;
    // 참고 자바스크립트는 메모리의 크기가 없이 사용이 가능하다. 하지만 자바는 메모리의 크기를 할당하여 사용
  }
}