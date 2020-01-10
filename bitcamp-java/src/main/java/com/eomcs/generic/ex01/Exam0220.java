// 제네릭(Generic) - 문법 정리  - 레퍼런스와 인스턴스 생성
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;
import com.eomcs.generic.ex01.Exam0220.A;
import com.eomcs.generic.ex01.Exam0220.B1;
import com.eomcs.generic.ex01.Exam0220.B2;
import com.eomcs.generic.ex01.Exam0220.C;
public class Exam0220 {
  class A {}
  class B1 extends A{}
  class B2 extends A{}
  class C extends B1{}

  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */


  public static void main(String[] args) {
    // m1(ArrayList)
    // => 제네릭의 타입을 지정하지 않으면 Object 타입과 같기 때문에 
    //    다음과 같이 다양한 종류의 ArrayList를 파라미터로 넘길 수 있다.
    m1(new ArrayList());
    m1(new ArrayList<A>());
    m1(new ArrayList<B1>());
    m1(new ArrayList<B2>());
    m1(new ArrayList<C>());
  }

  static void m1(ArrayList list) {
  }
}







