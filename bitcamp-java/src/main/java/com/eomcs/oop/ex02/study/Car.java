package com.eomcs.oop.ex02.study;

public class Car {
  
  public static final int OIL = 1;
  public static final int GAS = 2;
  // 명사는 데이터 타입을 정의한 것이다
  String name;
  int type;
  String colar;
  int speed;
  int energy;
  int power;
  int cleanLevel;

  void speedUp() { //연산자의 메서드인 경우는 인스턴스로 많이 사용한다 
    //car this = 메서드를 호출할 때 넘겨준 인스턴스 주소;
    if (this.speed >= 100) 
      return;
    this.speed += 10;
  }
  // 인스턴스를 만드는 과정은 static을 지우고
  // this라는 히든 변수를 사용하여 내부에서 처리 할 수 있도록 만든다


  int comparePower(Car c) {
    // 하나는 파라미터로 하는 히든 변수(this)로 받아서 비교한다
    // this는 생략이 가능하다
    System.out.println("this.power > c.power");
    System.out.printf("this의 값은 : %d\n ", this.power);
    System.out.printf("c의 값은 : %d\n ", c.power);
    if (this.power > c.power)
      return - 1;
    else if (this.power == c.power)
      return 0;
    else
      return 1;
  }

}

