package com.eomcs.oop.ex05.test;

public class Car {
    public String model;
    public String maker;
    public int capacity; //변수 이름을 변경하여도 상속된 메서드는 영향을 받지 않는다

    public Car() {}
    
    public Car(String model, String maker, int capacity) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
    }
}


