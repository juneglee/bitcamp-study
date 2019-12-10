package com.eomcs.basic.ex03;
//논리 리터럴

public class Exam5 {
  public static void main(String[] args){
    // 자바는 대소문자를 구분하여 처리한다.

    System.out.println(true);
    System.out.println(false);
    // System.out.println(True); 
    //C언에서는 true,false가 없으며, 전처리기에서 처리하는 것이다

    // 보통 비교 연산의 결과로 논리 값이 리턴된다
    System.out.println(4>5);
    System.out.println(4<5);

    // 논리 연산의 결과도 논리
    System.out.println(true&&true);
    System.out.println(true&&false);
    System.out.println(true||true);
    System.out.println(true||false);

    // 문자코드와 연산
    System.out.println('가' == 44032); // 다른 값과 연산하면 정수로 간주
    System.out.println('가' == 44033);

    // boolean 값을 다룰 때 메모리 크기는 
    // JVM은 논리 값을 저장 할 때 4바이트 정수 메모리를 사용한다
    // ture (1), false(0) 저장한다 
    // 배열인 경우 1바이트 정수 메모리를 사용한다.

  }
}