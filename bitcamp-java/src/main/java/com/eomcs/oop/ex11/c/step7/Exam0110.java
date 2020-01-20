// 상수 코드를 스태틱 중첩 클래스로 다루기
package com.eomcs.oop.ex11.c.step7;

public class Exam0110 {
  public static void main(String[] args) {
    // 카테고리 값을 지정할 때OGNL표기법으로 지정한다
    // OGNL(Object Graph Navigation Language)?
    // 자바에서 객체 안에 있는 필드를 가리킬 때 점(.)을 이용하여 표기하는 방버버
    // 객체 안에 객체가 계층적으로 들어 있을 때 파일 경로를 가르키듯
    // 점을 이용하여 가르킨다
    Product p = new Product();
    p.category = Category.appliance.TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p2.category = RAM;
    p2.name = "삼성 모듈램 4GB";
    p2.price = 80000;

    Product p3 = new Product();
    p3.category = NOVEL;
    p3.name = "토지";
    p3.price = 15000;

  }
}
