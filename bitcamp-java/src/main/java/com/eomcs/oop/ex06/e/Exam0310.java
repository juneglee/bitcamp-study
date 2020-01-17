// final 사용법 : 상수 필드 만들기
package com.eomcs.oop.ex06.e;

// 클래스에 final을 붙이면 이 클래스의 서브 클래스를 만들 수 없다
public final class Exam0310 {

  public void m1() {
    // 로컬 변수에 final을 붙이면 값을 변경할 수 없는 상수로 사용
    final int a =100 ;
    
    // 변수를 선언할 때 값을 초기화 시키지 않고.
    final int b;
    // 다음에 초기화 시킬 수 있다 
    b = 100;
    
    // 일단 한번 변수의 값이 초기화되면 변경할 수 ㅇ벗다
    // b = 200; // 컴파일 오류
  }

}
