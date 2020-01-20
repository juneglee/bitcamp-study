// 상수를 활용 후 : 문자열로
package com.eomcs.oop.ex11.c.step3;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();


    p.category = Product.appliance_tv;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p2.category = Product.computer_ram;
    p2.name = "삼성 모듈램 4GB";
    p2.price = 80000;

    Product p3 = new Product();
    p3.category = Product.book_novel;
    p3.name = "토지";
    p3.price = 15000;


  }
}
