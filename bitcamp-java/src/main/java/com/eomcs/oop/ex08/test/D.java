package com.eomcs.oop.ex08.test;

public class D extends Object { 
  int a;

}

class D2 extends D{
  int b;
}

class D3 extends D2{
  int c;
}

class testD {
  public static void main(String[] args) {
    D3 obj = new D3(); // D3가 상속받는 슈퍼 클래스(D3 ~ Object)의 인스턴스 변수까지 생성한다 
    obj.c = 100;
    obj.b = 100;
    obj.a = 100;        
  }
}

