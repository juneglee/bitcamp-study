package com.eomcs.oop.ex03.test;

public class Test03 {
  public static void main(String[] args) {
    
    Car c1 = new Car();
    Car c2 = new Car();
    Car c3 = null; //* 자바는 null을 받을 수 없다
    // 인스턴스를 만들때는 주소를 알아야 하기 때문에 주소를 지정해줘야 한다.
    // 각각의 인스턴스를 만들기 위해서는 c2, c3..라는 각각 인스턴스를 새로 만들어줘야 한다
    // 카 설계도에 따라서 heap에 인스턴스를 만든다
    // 이때, 연산자를 제외하고 스태틱이 안붙은 변수만 확인하여 인스턴스를 만든다
    // 이때 stack에는 c1이라는 주소를 만든다
    // 메서드는 메모리를 만드는 것과는 상관이 없다
    
    //Car.start(c1);
    //c2.start();
    //c3.start(); //* 인스턴스 주소를 지정하지 않았기 때문에 오류가 발생한다
    
    // System.out.printf("c1.on  = %b\n", c1.on);
    // System.out.printf("c2.on  = %b\n", c2.on);
    
    c1.check();// engine의 메모리만 만들고 꼽아주지는 않았다
    c1.check();
  }
}
