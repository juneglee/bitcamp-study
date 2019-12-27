package com.eomcs.oop.ex02.study;

public class GasStation {
  String name;
  int type;
  
  int refuel(Car c) {
    if (c.type != this.type)
      return 0;
    
    int amount = 100 -c.energy;
    c.energy = 100;
    return amount;
  }
  static void clean(Car c) {
    // non static을 사용하는 것이라면,
    // 특정 인스턴스에 대해서만 사용하는 것이기 때문에스태틱으로 만든다
    c.cleanLevel = 0;
  }
  // 인스턴스를 사용하지 않는다면 스태틱을 지울 필요는 없다
}
