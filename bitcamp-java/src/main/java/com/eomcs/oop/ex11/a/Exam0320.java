// local class
package com.eomcs.oop.ex11.a;

public class Exam0320 {

  int iValue;

  void m0() {}

  void m1() {
    // [바깥][$번호][로컬].class
    // 컴파일시 [$번호] $ 다음에 오는 번호는
    // 로컬 클래스가 갖고 있는 메서드 순서대로 붙인 번호이다
    // 모든 클래스는 $1 부터 시작하며, 클래스의 이름이 동일하다면 순번이 $2로 넘어가게 된다
    // 클래스는 저장한 순서대로 나열한다
    class A {
    }
    class B {
    }
    new A();
    new B();
  }

  void m2() {
    class A {
    }
    class X {
    }
    new A();
    new X();

  }
}
