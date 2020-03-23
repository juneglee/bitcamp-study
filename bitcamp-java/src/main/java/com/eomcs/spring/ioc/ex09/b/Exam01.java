// 객체 자동 생성 - @Component 애노테이션
package com.eomcs.spring.ioc.ex09.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {

  public static void main(String[] args) {
    // component-scan 태그를 추가하면 내부적으로 annotation-config 태그가
    // 자동으로 추가된다. 따라서 <context:annotation-config> 태그 생략하기
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex09/b/application-context.xml");

    SpringUtils.printBeanList(iocContainer);
  }
}


