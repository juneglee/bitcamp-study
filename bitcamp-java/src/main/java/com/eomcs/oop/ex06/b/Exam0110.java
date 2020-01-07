// 메서드 오버로딩(overloading) - 문법 사용전
package com.eomcs.oop.ex06.b;

public class Exam0110 {
  // 만약 같은 이름의 메소드를 여러 개 만들수 없다면, 
  // 다음과 같이 같은 일을 수행(두 수를 더하는 일)하는 메서드라도 
  // 이름을 다르게 해야 한다
  static class Calculator {
    static int plusi(int a, int b) {
      return a + b;
    } 
    static int plusi2(int a) {
      return a + a;
    }
    static float plusf(float a, float b) {
      return a + b;
    }
  }

  public static void main(String[] args) {
    //두개의 정수를 더할 때는 Plusi() 호출해야 한다
    int r1 = Calculator.plusi(100,200);
    
    //한개의 정수를 더할 때는 Plusi2() 호출해야 한다
    int r2 = Calculator.plusi2(100);
    
    //두개의 부동소수점를 더할 때는 Plusf() 호출해야 한다
    float r3 = Calculator.plusf(35.7f,22.2f);

    System.out.printf("%d, %d, %.1f", r1, r2, r3);
    
    // 같은 더하기 일을 하더라도 더하는 값을 타입에 따라 
    // 메서드 이름이 다르다면, 메서드를 사용하기가 번거롭다.
    // 이것이 오버로딩 문법이 등장한 이유이다.
    
  }
}





