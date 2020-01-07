package com.eomcs.oop.ex08.test;

public class E extends Object { 
 E() { // 파라미터가 없는 생성자를 default constructor 라고 부른다 
   super(); // 모든 생성자는 첫문장으로 수퍼 클래스의 생성자를 호출해야 한다
 }
 E(int a) {
   this(); // 수퍼 클래스의 생성자 대신 자기 자신의 다른 생성자를 호출 할 수 있다 
 }
 E(String s) {
   // 수퍼 클래스의 생성자나 자신의 생성자나 모두 첫 문자으로 와야하기 때문에 .
   // 동시에 사용하지 못한다
   // super(); 
   // this();
 }
 E(int a, int b) {
  // 생략하면 기본으로 default 값으로 생성자 호출
 }
 
}

class E2 extends E{
  E2(int a) {
    // 생성자가 한 개 이상 있으면 컴파일러는 default 생성자를 생성하지 않는다  
  }
}

class E3 extends E2 {
  E3() {
    // 슈퍼 클래스에 기본 생성자가 없을 때 개발자가 직접 
    // 어떤 슈퍼 클래스의 생성자를 호출할지 지정해야 한다
    super(100);//E2(int) 생성자를 호출한다
  }
}

class testE {
  public static void main(String[] args) {
    E3 obj;
    obj = new E3();
    // 생성자 호출 E3() 생성자 부터 상위 클래스 따라 올라가면서 호출한다
    // 실행은 호출된 상위 클래스부터 생성자까지 실행한다
  }
}

