package com.eomcs.basic.ex04;

// 형변환 : 부동소수점 변수 ==> 정수 변수
public class Exam92 {
  public static void main(String[] args/* 로컬변수(파라미터)*/){
    float f = 3.14f;
    double d = 3.14;
    
    //int i = f;
    //long l;
    // i = f; //컴파일 오류;
    // i = l; //컴파일 오류;
    // l = f; //컴파일 오류;
    // l = l; //컴파일 오류;
    
    // 부동소수점 값을 정수 변수에 강제로 저장시키려면
    // 형변환(type conversion; type casting) 문법을 사용해야 한다
    int i = (int) f; // 소수점 이하의 수는 제거되고 정수만 저장된다. 
    System.out.println(i);
    long l = (int) d;
    System.out.println(l);
    
    //i = (long) f; 
    
    // 이렇게 개발자가 명확하게 다른 ㅎㅇ의 값을 저장하라고 지시하는 문법을 
    // 명시적 형변환 이라 한다
    
  }
}