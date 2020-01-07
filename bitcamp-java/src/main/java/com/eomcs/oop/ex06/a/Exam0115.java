// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0115 {

  public static void main(String[] args) {
    // 상위 클래스의 레퍼런스로 하위 클래스의 인스턴스를 가리킬때 
    Car c = new Sedan();

    c.model="티코"; //상위
    c.capacity =1; //상위
    c.cc =890; //동일
    c.valve =2; //동일
    // 레퍼런스가 실제 하위 인스턴스를 가리키고 있따 하더라도,
    // 레퍼런스 타입의 범위를 벗어나서 사용할 수 없다 
    
    c.sunroof = true;// 컴파일 오류
    Sedan s1 = null;
    s1.valve =2;
    // 자바 컴파일러는 레퍼런스가 어떤 인스턴스를 가리키는지 따지지 않고 
    // 레퍼런스 타입에 한정하여 인스턴스나 클래스의 멤버 사용을 허락한다
    
    // 해결책
    // 레퍼런스 변수가 실제 가리키는 것이 무엇인지 알려줘야 한다
    // ((원래 타입 레퍼런스)레퍼런스).멤버
    ((Sedan)c).sunroof = true; // 방법 1
    // 또는 인스턴스의 원래 클래스 레퍼런스에 저장한 다음에 사용
    Sedan s2 = (Sedan) c; // 방법 2
    s2.sunroof = true;
  }
}
