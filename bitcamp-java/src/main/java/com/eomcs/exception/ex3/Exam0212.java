// 예외 던지기 - 예외 상황을 호출자에게 알려주기
package com.eomcs.exception.ex3;

public class Exam0212 {

  // Exception 계열(애플리케이션)의 예외를 던질 때는
  // 반드시 메서드 선언부에 어떤 예외를 던지는지 지정해야 한다.
  static void m1() throws Exception {
    throw new Exception(); // OK! 보통 개발자가 사용하는 예외 클래스이다.
  }

  // Exception 예외를 던질 경우 반드시 메서드 선언부에 표시해야 한다
  static void m2() {
    throw new Exception(); // 컴파일 오류
  }

  // 메서드 선언부와, 던질 수 있는 객체는 Throwable 타입만 가능
  static void m3() throws String {
    throw new String(); // 컴파일 오류!
    // throw 로 던질 수 있는 객체는 오직 java.lang.Throwable 타입만 가능하다.
  }

  public static void main(String[] args) {}

}
