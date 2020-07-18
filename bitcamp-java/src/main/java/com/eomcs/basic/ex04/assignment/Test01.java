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
    String operator = keyboard.next();//token 은 하나의 단어(word)이다.

    //System.out.printf("=> %d %s %d = %d \n", value1, operator, value2); 

  
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
   // else {if} 에서 한문장으로 생각하기 때문에 {}를 생각한것 이다
   // 자바는 elseif는 존재하지 않는다 
  }
}
