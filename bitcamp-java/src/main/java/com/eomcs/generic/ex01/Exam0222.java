// 제네릭(Generic) - 문법 정리  - 레퍼런스와 인스턴스 생성
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;
import com.eomcs.generic.ex01.Exam0222.A;
import com.eomcs.generic.ex01.Exam0222.B1;
import com.eomcs.generic.ex01.Exam0222.B2;
import com.eomcs.generic.ex01.Exam0222.C;

public class Exam0222 {
static class A {}
static class B1 extends A {}
static class B2 extends A {}
static class C extends B1 {}

  public static void main(String[] args) {
    // ArrayList<?> 
    // 모든 타입에 대해 arraylist의 파라미터를 받을 수있다 
    
    m1(new ArrayList());
    m1(new ArrayList<Object>());
    m1(new ArrayList<A>());
    m1(new ArrayList<B1>());
    m1(new ArrayList<B2>());
    m1(new ArrayList<C>());

  }
  static void m1 (ArrayList<?> list) { 
    // A타입에데해서만 가능 하다
    // 정확히 A타입만 와야 한다 
    // 즉 상위나, 하위 모두 불가능하고 정확히 A만 와야 한다
      
  }
}








