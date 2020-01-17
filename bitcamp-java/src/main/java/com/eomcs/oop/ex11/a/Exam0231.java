// non - static nested class = inner class
package com.eomcs.oop.ex11.a;

public class Exam0231 {
  public static void main(final String[] args) {
    // 다른 클래스의 인스턴스 멤버는 반드시 인스턴스가 있어야만 사용할 수 있다.
    //
    // Exam0230_X.iValue = 100; // 컴파일 오류!
    // Exam0230_X.im(); // 컴파일 오류!

    final Exam0231_X obj = new Exam0231_X();
    obj.new A("홍길동", 20);
    // 위 코드는 컴파일러 다음과 같이 바꾼다
    // 바깥 클래스의 객체 주소를 받기 위해 컴파일러가 변경한 생성자 호출
    // new A(obj, "홍길동", 20)
    // 실제 주소를 파라미터로 변경하는 코드로 변경된다

  }
}


class Exam0231_X {
  class A {
    String name;
    int age;

    public A(final String name, final int age) {
      this.name = name;
      this.age = age;
    }
    /*
     * 컴파일러가 추가하는 필드 및 생성자
     *
     * 우리가 추가한 생성자는 다음과 같이 
     * 바깥 클래스의 객체 주소를 받을 수 있도록 파라미터 추가 된다
     *
     * Exam0231_X outer
     *
     * public A(final String name, final int age) { 
     * this.name = name;
     * this.age = age; 
     * }
     *
     *
     */


    void m1() {}
  }

  int iValue;

  void im() {}
}

