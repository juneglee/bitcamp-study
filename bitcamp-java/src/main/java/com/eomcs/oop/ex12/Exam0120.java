// 람다(lambda) 문법
package com.eomcs.oop.ex12;

public class Exam0120 {

  static interface Player {
    void play();
  }

  public static void main(String[] args) {

    // 메서드의 몸체에 한 문장만 있을 때 중괄호 생략할 수 있다
    Player p1 = () -> System.out.println("Hello");
    p1.play();

    // 중골화로 묶어도 상관없음
    Player p2 = () -> {
      System.out.println("Hello");
    };
    p2.play();
  }
}


