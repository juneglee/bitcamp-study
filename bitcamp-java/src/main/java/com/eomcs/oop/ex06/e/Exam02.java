// 다형적 변수와 오버라이딩
package com.eomcs.oop.ex06.e;

public class Exam02 {
  public static void main(String[] args) {
    A a = new A3();
    a.m(); // A2의 m() 호출
    // a가 실제 가르키는 A3 클래스부터 상위 클래스로 따라 올라가면서
    // 첫 번쨰로 만난 m()을 호출한다.
    //
    // 상속관계에서 따라 올라가면서 호출하게 되고,  
    // 실행하면서 내려오기 때문에 맨 나중에 실행한 A2의 m()을 호출한다
    System.out.println("------------------");

  }
}






