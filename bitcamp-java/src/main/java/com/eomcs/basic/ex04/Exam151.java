package com.eomcs.basic.ex04;


public class Exam151 {
  public static void main(String[] args){

    int i; 
    i = 100; 
    System.out.println(i); //println에 i변수를 전달하는 것이 아니라, i 변수에 들어 있는 값을 전달하는 것이다

    int j;
    j = i;

    //할당연산자 '=' - 변수에 값을 넣는 일을 한다
    // l-value : 변수가 와야 한다, 값이 올수 없다
    // r-value : 값이나 변수, 표현식 (expression)이 올 수 있다

    j=300; //값
    j=i; //변수
    j=i*3; //표현식
    j=Math.abs(-200); //표현식
    j=(i>100) ? 1 : -1; // 표현식
    //j=System.out.println(100); // 그냥 문장이다(리턴을 하지않는다). 표현식이 아니다

    // 문장 (statement)
    // - 자바 언어로 작성한 명령어
    //
    // 표현식 (expression)   
    // - 문장 중에 값을 리턴하는 문장



  }
}