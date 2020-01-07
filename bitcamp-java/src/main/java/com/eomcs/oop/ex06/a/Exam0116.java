// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0116 {

  public static void main(String[] args) {
    // 상위 클래스의 레퍼런스로 하위 클래스의 인스턴스를 가리킬때 
    Car c = new Car();

    c.model="티코"; //상위
    c.capacity =1; //상위
    c.cc =890; //동일
    c.valve =2; //동일
    Sedan s = (Sedan) c; //(runtime exception)
    s.sunroof = true;
    s.auto = true;
    
    // 형변환으로 컴파일러는 속일 수 있지만. 실행 할 때 오류가 발생할 것이다
  }
}
