package com.eomcs.basic.ex03;

// 문자 리터럴 - 작은 따옴표의 역할

public class Exam43 {
  public static void main(String[] args) {
    System.out.println(0xac00);
    System.out.println((char) 0xac00);
    System.out.println('가');

    System.out.println((int) '가'); //문자를 정수로 간주하고 출력하라
    // 글자를 숫자로 지정하여 다른 연산 값과 연산을 수행 할 수 있다 

    System.out.println('각'+1); //''로 지정하면 문자의 코드값 (0 ~65535을 리턴한다)
    // 문자에 숫자를 더하는 것이 아니라, 문자의 코드값에 숫자를 더하는 것이라고 생각해야 한다
    System.out.println('각'-1); 
    // 문자 코드와 정수를 연산을 하면, 더이상 문자코드가 아니라 일반적인 정수가 된다

    // 해당 연산값을 문자코드로 다시 변환하기 위해서는 (char)를 붙인다
    System.out.println((char)('각'-1)); // 주의 !! (char)(연산값) <- char뒤에도 ()를 붙여야 한다


  }
}