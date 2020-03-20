// 의존 객체 주입 자동화하기 - 필수 의존 객체와 선택 의존 객체
package com.eomcs.spring.ioc.ex08.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {

  public static void main(String[] args) {

    // 생성자를 통해 의존 객체를 주입할 수 있다
    // => AutowiredAnnotationBeanPostProcessor가 이것 또한 처리해준다
    // => 해당 클래스에 기본 생성자가 없을 때,
    // 파라미터를 받는 다른 생성자를 찾아 호출한다
    // => 물론 그 파라미터를 받는 객체가 존재해야 한다.
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex08/g/application-context.xml");

    SpringUtils.printBeanList(iocContainer);

    System.out.println(iocContainer.getBean("c1"));
  }

}


