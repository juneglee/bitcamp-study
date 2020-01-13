// 제네릭(Generic) - 문법 정리  - 레퍼런스와 인스턴스 생성
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;
import com.eomcs.generic.ex01.Exam0223.A;

public class Exam0223 {
  class A {}
  class B1 extends A{}
  class B2 extends A{}
  class C extends B1{}

  public static void main(String[] args) {
    // ArrayList<?> 
    // 모든 타입에 대해 arraylist의 파라미터를 받을 수있다 
    // 왜? 
    // => 타입을 지정하지 않으면 ArrayList에 A가 아닌 다른 타입의 객체가 들어갈 수 있다.
    // => 그러면 실행 중에 get()을 호출할 때 형변환 문제가 발생할 것이다.
    //
    //m1(new ArrayList<Object>()); // 컴파일 오류!
    m1(new ArrayList<A>());
    //m1(new ArrayList<B1>()); // 컴파일 오류!
    //m1(new ArrayList<B2>()); // 컴파일 오류!
    //m1(new ArrayList<C>()); // 컴파일 오류!
  }

  static void m1 (ArrayList<A> list) {

  }
}








