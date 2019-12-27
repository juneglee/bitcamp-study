package com.eomcs.oop.ex02.study;

public class Test03 {
  public static void main(String[] args) {
    Car c1 = new Car(); //식판에 주소를 담는다
    Car c2 = new Car();

    c1.name = "봉봉";
    c1.type = 1;
    c1.colar ="빨강";
    c1.speed = 0;
    c1.energy = 100;
    c1.power = 200;
    // static은 class 당 한개의 정보만을 저장할 수 있으며. 
    // 여러개의 정보를 저장할 수 없다.
    // 어러개를 저장하고 싶으면 static을 제거해야 한다. 즉, 인스턴스로 만들어야 한다
    // 인스턴스는 static을 제거하고. new라는 명렁어로 지정해야 한다
    // 이때 new는 heap 저장된다.
    c2.name = "호호";
    c2.type = 2;
    c2.colar ="검정";
    c2.speed = 0;
    c2.energy = 100;
    c2.power = 300;

    c1.speedUp(); // 메서드 = 연산자 , class에서 메서드를 정의한 후 주소값으로 넘어간다 
    c1.speedUp(); // parameter로 넘겨야 하기 때문에 불편하다.
    c2.speedUp();
    
    // Car c3 = null;
    // c3.speedUp();
    //NullPointerException : 주소도 없이 호출했네?

    System.out.printf("c1의 속도 : %d\n", c1.speed);
    System.out.printf("c2의 속도 : %d\n", c2.speed);
    
    System.out.println();
    
    System.out.printf("c1 vs c2 의 힘 : %d\n", c1.comparePower(c2));


  }
}
