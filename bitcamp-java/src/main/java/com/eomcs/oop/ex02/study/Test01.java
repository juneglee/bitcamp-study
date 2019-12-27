package com.eomcs.oop.ex02.study;

public class Test01 {
  public static void main(String[] args) {

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math =80;

    s.calculate(); // 오퍼레이터 = 메서드 = 연산자 
       
    System.out.println(s.sum);
    System.out.println(s.aver);
    //int i = 100;
    //i++;//오퍼랜드 오퍼레이터
  }
}
