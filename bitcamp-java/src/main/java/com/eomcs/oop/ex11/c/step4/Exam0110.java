// 상수를 활용 후 : 상수로 정의
package com.eomcs.oop.ex11.c.step4;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();

    p.category = Product.APPLIANCE_TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;
    // APPLIANCE_TV은 변수로 받아 직관적으로 알수 있지만, 정의된 것은 상수이다

    Product p2 = new Product();
    p2.category = Product.COMPUTER_RAM;
    p2.name = "삼성 모듈램 4GB";
    p2.price = 80000;

    Product p3 = new Product();
    p3.category = Product.BOOK_NOVEL;
    p3.name = "토지";
    p3.price = 15000;
  }
}
