package com.eomcs.basic.ex03;

public class Exam1 {
  public static void main(String[] args){
    // 정수, 소수, 논리, 문자
    System.out.println(78);
    System.out.println(+78);
    System.out.println(-78);

    System.out.println(0116);
    System.out.println(-0116); // 8진수 앞에 0을 반드시 붙임

    System.out.println(0x4e);  // 16진수 앞에 0x 반드시 붙임
    System.out.println(-0x4e);

    System.out.println(0b01001110); //2진수 앞에 0b 반드시 붙임 
    System.out.println(-0b01001110);

    System.out.println(3.14); // 고정소수점
    System.out.println(31.4e-1); //부동소수점 * 10 = e1(=e+1), e=익스포넨셜(exponential)=지수의, 기하급수의

    System.out.println(true); // 반드시 소문자 (대소문자를 구분한다)
    System.out.println(false);

    System.out.println('A');
    System.out.println("가나");
    System.out.println("안녕하세요.!");

  }
}