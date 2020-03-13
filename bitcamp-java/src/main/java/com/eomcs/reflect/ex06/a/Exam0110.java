package com.eomcs.reflect.ex06.a;

import java.lang.reflect.Proxy;

public class Exam0110 {
  public static void main(String[] args) throws Exception {

    // 프록시 객체를 만드는 방법
    MyInterface obj = (MyInterface) Proxy.newProxyInstance(//
        Exam0110.class.getClassLoader(), // 클래스를 메모리에 로딩하는 일을 할 객체
        // 프록시로 자동으로 생성된 class를 로딩한다
        new Class[] {MyInterface.class}, // 자동 생성할 클래스가 구현해야 하는 인터페이스 목록
        new MyInvocationHandler());

    obj.m1();
    obj.m2();
  }
}
