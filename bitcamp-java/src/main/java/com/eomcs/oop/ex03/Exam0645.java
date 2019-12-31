// 초기화 블록 - 클래스 블록 = 스태틱 블록
package com.eomcs.oop.ex03;

public class Exam0645 {

  public static class A {
    static int a;
    static void m() {}

    // 스태틱 블록은 클래스가 로딩된 후에 자동으로 순서대로 실행된다.
    static {
      System.out.println("Static{} 11111");
    }

    static {
      System.out.println("Static{} 22222");
    }
  }

  public static void main(String[] args) throws Exception {
    // 클래스가 로딩되는 경우
    // 3) 자바에서 제공하는 도구를 사용하여 
    //    => 이미 클래스가 로딩되어 있다면 다시 로딩하지 않는다.
    //    => 자바는 중복해서 클래스를 메모리에 로딩하지 않는다. 메모리 절약! 
    //Class.forName("step08.Exam06_4$A");
    Class.forName("com.eomcs.oop.ex03.Exam0645$A");
    //class 정보를 다룬다/forname은 클래스를 로딩하는 것
    System.out.println("종료!");
  }
}





