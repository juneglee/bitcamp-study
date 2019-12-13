// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;
public class Test01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in); 

    System.out.print("값1?  ");
    int value1 = keyboard.nextInt();
    System.out.print("값1?  ");
    int value2 = keyboard.nextInt();
    System.out.print("연산자(+,-,*,/)?");
    String operator = keyboard.next();
  
   if (operator.equals("+")) {
     System.out.println(value1 + " + " + value2 + " = " + (value1 + value2));
     } else if (operator.equals("-")) {
        System.out.println(value1 + " - " + value2 + " = " + (value1 - value2));
     } else if (operator.equals("*")) {
        System.out.println(value1 + " * " + value2 + " = " + (value1 * value2));
     } else if (operator.equals("/")) {
       System.out.println(value1 + " / " + value2 + " = " + (value1 / value2));
     } else {
       System.out.println("잘못된 연산자 입니다");
     } 
  }
}
