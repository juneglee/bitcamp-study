// non - static nested class = inner class
package com.eomcs.oop.ex11.a;

public class Exam0210 {

  // 스태틱 멤버
  static int sValue;
  static void sm() {}

  // 인스턴스 멤버
  int iValue;
  void im() {}

  // non - static nested class 는 인스턴스 멤버이다.
  // 따라서 인스턴스가 있어야만 사용할 수 있다.
  class A {
    void m1() {
      // 인스턴스 멤버 (인스턴스 블록, 생성자, 인스턴스 메서드, inner class) 
      sValue = 100; 
      sm(); 
      // 인스턴스 멤버는 같은 인스턴스 멤버 뿐만 아니라 
      // 스태틱 멤버도 사용이 가능하다
      // why ? (스태틱 멤버도 사용이 가능한 이유?)
      //  인스턴스 멤버가 실행되는 시점에
      //  this 라는 빌트인 변수에 인스턴스 주소가 들어 있기 때문이다
      Exam0210.this.iValue = 100; 
      Exam0210.this.im(); // 사용 안해도 된다
      // 단, nested class(inner class)에서는 바깥 클래스의 인스턴스 주소가 
      //     바깥클래스명.this 변수에 들어 있다
      // 
      iValue = 200;
      im();
      // inner에 같은 이름이 없다면 바깥 클래스명.this를 생략해도 된다 
      
      // 바깥클래스를 지정않으면 A 클래스 내부 변수로 되기 때문에 
      // 바깥클래스를 사용하고 싶으면 바깥클래스를 표현해야 한다
      // this.iValue = 100; // A클래스 내부변수, A클래스에는 iValue 필드가 없기 때문에 오류 발생
      Exam0210.this.iValue = 100; // Exam0210 내부 변수
      
      
    }
  }
  
  // 결론:
  // nested class가 바깥 클래스의 인스턴스 멤버를 사용한다면
  // non- static nested class 로 정의하라!

  public static void main(String[] args) {
  }
}
