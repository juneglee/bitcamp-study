package com.eomcs.oop.ex03.test;

// field를 묶어서 attribute이며 속성
// 클래스를 불러들일때는 클래스 이름을 사용해야 하고
// 인스턴스를 불러들일때는 인스턴스의 주소값으로 넣어야 한다
// 클래스 두가지 연산자. 메모리
public class Car {
  boolean on;
  int speed;
  String name;
  String maker;
  Engine engine; //필수값이 존재해야 하는 것은 생성자를 이용하여 만들어야 한다
  int distance;

  Car() { // 생성자를 이용하여 엔진이 유효한값으로 연산할 수 있도록 만든다
    this.engine = new Engine(4, 16, 1980);
  }
  /* 
  static void start(Car c) {
    c.on = true;
  }
   */
  void start() {
    this.on = true;
    // c.on =true;
    // non-static 으로써 앞부분을 넘겨야 한다
    // 모든 인스턴스 메서드는 this를 받는다
    // this는 위의 변수의 on을 사용하는게 아니라 메서드를 인출할때 넘겨준 주소이다
    // this는 만들어진 인스턴스의 주소가 있다고 가정하여 생각해야 한다
  }

  void Stop(Car c) {
    c.on = false;
  }

  void check() {
    if (this.engine.oilState == 0) {
      // 엔진의 상태를 조회화여 엔진의 메서드의 연산을 실행하도록 만든다
      this.engine.cleanOil();
      System.out.println("자동차의 엔진 오일을 교환했습니다.");
    }
   System.out.println("자동차를 정비했습니다.");
  }
  // 데이터를 조회를 할 수 있지만. 데이터를 연산할 수는 없다
  /*
  void cleanOil() {
    // 생성자가 없으면 engine 객체에 대한 인스턴스 주소가 있을 것이다 
    this.engine.oilState = 10;
  }
  */
}
