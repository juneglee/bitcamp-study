// 객체 생성 - 익명 객체의 이름
package com.eomcs.spring.ioc.ex02.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex02/d/application-context.xml");

    // IoC 컨테이너가 생성될 때,
    // singleton 객체는 기본으로 생성된다.

    System.out.println("[빈 이름]");
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(name);
    }
    // 클래스마다 인덱스는 0부터 시작한다.
    // 객체가 생성되어 있지 않더라도 빈의 이름은 모두 등록되어 있다
  }
}


