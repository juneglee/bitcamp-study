package com.eomcs.oop.ex05.test;

public class Sedan extends Car {
  public boolean sunroof;
  public boolean auto;

  public Sedan() {}

  public Sedan(String model, String maker, int capacity 
      ,boolean sunroof,boolean auto ) {
    //this.model = model;
    //this.maker = maker;
    //this.capacity = capacity;
    super(model, maker, capacity);
    // this(model, maker, capacity);는  생성자가 두개가 존재 할때 사용하는 것
    // 다른 생성자를 참조하지 않기 때문에 사용할 수 없다
    this.sunroof = sunroof;
    this.auto = auto;
  }
}


