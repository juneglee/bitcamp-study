// 템플릿 메서드를 구현한 클래스 사용
package com.eomcs.oop.ex10.c;

public class Exam01 {

  public static void main(String[] args) {
    Restautant r = new Restautant();
    Farm f = new Farm();

    work(r);
    System.out.println("---------------------");
    work(f);

  }

  static void work(Building obj) {
    // 레스토랑이나 농장 거축의 기본 흐름은 이미 수퍼 클래스에 정의되어 있다.
    // 착수와 완료는 서브 클래스 마다 다르다.
    // 기본 틀은 수퍼 클래스에서 기본의 틀을 정의하고 서브 클래스에 넘겨 준다 
    // 받은 서브 클래스에서 각각의 정의된 탬플릿 메서드를 이용하여 재정의를 한다
    // 그래서 main에서 각각의 객체를 받는다  
    obj.build();
  }
}
