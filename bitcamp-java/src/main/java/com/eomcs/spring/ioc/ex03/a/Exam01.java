// 생성자 호출 확인
package com.eomcs.spring.ioc.ex03.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex03/a/application-context.xml");

    // IoC 컨테이너가 만드는 객체생성하는 객체의
    // SpringUtils.printBeanNames(iocContainer);
  }
}


