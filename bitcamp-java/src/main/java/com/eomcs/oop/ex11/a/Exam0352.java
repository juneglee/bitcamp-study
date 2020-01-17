// local class - 로컬 클래스와 로컬 변수
package com.eomcs.oop.ex11.a;

public class Exam0352 {
  public static void main(final String[] args) {
    final Exam0352 obj = new Exam0352();
    obj.m1();
  }

  int iValue;

  void m1() {
    int a;
    a = 100;
    a = 200;
    class A {
      void m1() {
        // 로컬 변수의 값이 두번이상 바뀌는 경우 상수 값으로 취급할 수 없기 때문에
        // 로컬 클래스에서 메서드의 로컬 변수를 사용 할 수 없다
        System.out.println(a);

        // 결론
        // 로컬 클래스는 메서드의 final 변수를 사용할 수 있다
        // 값이 변경 될 수 있는 일반 변수는 사용 할 수 없다.
        // 결국 그냥 final을 사용해서 사용해라 !!!!!!!!!!
      }
    }

    final A obj = new A();
    obj.m1();
  }
}
