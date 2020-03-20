// 의존 객체 주입 자동화하기 - @Autowired + @Qualifier = @Resource
package com.eomcs.spring.ioc.ex08.i;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {

  public static void main(String[] args) {

    // @Autowired와 @Qualifier 묶어서 사용하는 대신에
    // 자바 언어 확장 명세서 JSR-250에 정의된 @Resource를 사용할 수 있따
    // 단 이 애노테이션을 사용하려면
    // 이 애노테이션이 정의된 라이브러리를 별도로 다운로드 받아야 한다
    // 이 애노테이션은 자바 확장 라이브러리이다. 호함되어 있다.
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex08/i/application-context.xml");

    SpringUtils.printBeanList(iocContainer);

    System.out.println(iocContainer.getBean("c1"));
  }

}


