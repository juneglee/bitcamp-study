// local class - 인스턴스 멤버에 선언된 로컬 클래스
package com.eomcs.oop.ex11.a;

public class Exam0340 {
  public static void main(final String[] args) {
    // 인스턴스 멤버는 반드시 인스턴스를 생성한 후에 사용할 수 있다
    final Exam0340 obj = new Exam0340();
    obj.im();
    // im()호출할때 Exam0340객체를 넘겨준다
  }

  int iValue;

  // 스태틱 메서드의 로컬 클래스 사용법
  void im() {
    // Exam0340의 this가 존재하며 <<<< 아래에 this를 사용
    class A {
      // 바깥 클래스의 인스턴스 주소를 알수 있기 때문에
      // 인스턴스 주소를 담을 필드, 생성자를 생성한다
      /*
       * Exam0231_X outer(바깥클래스.this와 같은 것)
       */

      void m1() {
        // 로컬 클래스가 인스턴스 멤버에 정의된 경우
        // 바깥 클래스의 인스턴스 멤버를 사용할 수 있다
        // Exam0340.this.iValue = 100; //ok!

        // 이름이 유일하면 바깥을 가르킨다
        iValue = 100;
      }
    }
    final A obj = new A();
    // 위 코드는 바깥 클래스의 인스턴스 주소를 받는 생성자 호출 코드로 바꾼다
    // final A obj = new A(this); <<<< 이곳에서 this를 받는다
    obj.m1();
  }
}
