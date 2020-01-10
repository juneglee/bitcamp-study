// 제네릭(Generic) - 문법 정리  - 레퍼런스와 인스턴스 생성
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;
import com.eomcs.generic.ex01.Exam0224.B1;
import com.eomcs.generic.ex01.Exam0224.C;

public class Exam0224 {
static class A {}
static class B1 extends A{}
static class B2 extends A{}
static class C extends B1{}

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
    // ArrayList<?> 
    // 모든 타입에 대해 arraylist의 파라미터를 받을 수있다

    m1(new ArrayList());  
    // m1(ArrayList<? extends B1>)
    // => A 타입 및 그 하위 타입에 대해서 ArrayList 객체를 파라미터로 넘길 수 있다.
    //
    //m1(new ArrayList<Object>()); // 컴파일 오류!
    //m1(new ArrayList<A>()); // 컴파일 오류!
    m1(new ArrayList<B1>()); 
    //m1(new ArrayList<B2>()); // 컴파일 오류!
    m1(new ArrayList<C>()); 
  }
  
  // 상속 받은 값에 대해서 하위를 넘길수 있다 
  static void m1(ArrayList<? extends B1> list) {
  }
}







