// 상수를 활용하기 후
package com.eomcs.oop.ex11.c.step2;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();
    // 숫자 대신 문자열로 받을 때

    p.category = "appliance TV";
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p2.category = "computer RAM";
    p2.name = "삼성 모듈램 4GB";
    p2.price = 80000;

    Product p3 = new Product();
    p3.category = "book novel";
    p3.name = "토지";
    p3.price = 15000;

    // 숫자 대신 문자열을 사용하면 직관적이여서 확인은 빠르지만
    // 문자열을 잘못입력한 경우, 동작을 제대로 하지 못할 수 있다.

  }
}
