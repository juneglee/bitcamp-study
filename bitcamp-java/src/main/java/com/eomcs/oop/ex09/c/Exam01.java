// 서브 인터페이스 구현 - 수퍼 인터페이스의 메서드까지 모두 구현해야 한다.
package com.eomcs.oop.ex09.c;

public class Exam01 implements B {

  // 인터페이스에 선언된 메서드 구현
  public void m2() {} // B 인터페이스 뿐만아니라,
  public void m1() {} // B의 수퍼인터페이스의 메서드까지 구현해야 한다.

  //클래스에서 추가한 메서드 
  public void x1() {}
  public void x2() {}

  public static void main(String[] args) {//main과 배열이 존재해야 실행 가능하다
    Exam01 obj = new Exam01();
    
    // 클래스 타입 레퍼런스는 해당 클래스에 정의된 메서드를 호출 할 수 있다
    obj.m1();
    obj.m2();
    obj.x1();
    obj.x2();
    
    // 인터페이스 레퍼런스는 해당 인터페이스에 선언된 메서드만 호출할 수 있다
    B obj2 = obj; // Exam01의 객체에서 저장된 것만 받을 수 있다
   
    obj2.m1(); //A의 m1() < B가 상속 받는 인터페이스의 메서드
    obj2.m2(); //B의 m2() 
    //obj2.x1(); // 컴파일 오류!
    //obj2.x2(); // 컴파일 오류!
    
    A obj3 = obj;
    // 담은 레퍼런스에 따라 받을 수 있는 메서드도 다르다 
    obj3.m1(); // A.m1 
    //obj3.m2(); // 컴파일 오류!
    //obj3.x1(); // 컴파일 오류!
    //obj3.x2(); // 컴파일 오류!
    
  }
}
