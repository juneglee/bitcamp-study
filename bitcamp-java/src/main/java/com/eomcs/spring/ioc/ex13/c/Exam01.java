// AOP(Aspect-Oriented Programming) - AOP 필터 적용 위치
package com.eomcs.spring.ioc.ex13.c;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex13/c/application-context.xml");


    SpringUtils.printBeanList(iocContainer);


    try {
      Caller caller = iocContainer.getBean(Caller.class);
      caller.test();
      // test()에서 호출하는 m1()은 실제로는 프록시에서 정의된 m1()을 호출하는 것이다


    } catch (Exception e) {
      System.err.println("오류 발생!");
    }
  }

}


