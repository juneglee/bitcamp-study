package com.eomcs.oop.ex03.test;

public class Engine {
  int valve;
  int sylinder;
  int cc;
  int oilState;
  
  Engine(int sylinder, int valve, int cc) {
    // 특정 인스턴스 값에 대해 사용하는 것이다
    // 생성자는 인스턴스가 존재한다는 것이고 내장변수this를 사용할 수 있다. 
    // 내장변수가 있다는 것은 인스턴스가 있다는 것이다.
    this.sylinder = sylinder;
    this.valve = valve;
    this.cc = cc;
    this.oilState = 0;
  }
  
  void cleanOil() {
    // 생성자가 없으면 engine 객체에 대한 인스턴스 주소가 있을 것이다 
    this.oilState = 10;
  }
}
 