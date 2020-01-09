package com.eomcs.oop.ex08.test;

// public 이 아니라면 여러개를 만들 수 있지만, 
// 하나의 클래스에 하나의 파일을 만든는 것을 추천한다
class A1 {

}

class A2 {

}

// package member class
public class A { 
  // nested class 이며 inner class라 한다
  class X {} //클래스 안에 클래스가 있으면 네스티드 클래스

  static class X2 {} 
  //종류는 두개의 종류가 존재하면 스태틱과 논스태틱 
  //public 이 없으면 내부에서만 사용된다
  //public 소스와 이름이 동일하지 않아도 된다  (A -> X)
  // 공개하하는 파일은 소스이름이 동일해야 한다 
  
  void m() {
    // local class
    class Y {} // 메서드 안에 선언된 클래스를 로컬 클래스라고 한다
    // 이름이 없는 클래스도 만들 수 있다
    // 정의를 할 수 있지만 인스턴스를 따로 만들 수 없다 

    // class {} // obj2 
    // class {} // obj3
    // 이름이 없는 클래스는 최소한 슈퍼 클래스라도 만들어야 한다
    Object obj = new Object() { //anonymous
      @Override
      public String toString() {
        return "익명클래스";
      }
    }; // 세미콜론?

    Y obj2 = new Y();
    //obj2 = new ();
    //obj3 = new ();
    // 이름이 없는 클래스는 최소한 슈퍼 클래스라도 만들어야 한다
  }
}
