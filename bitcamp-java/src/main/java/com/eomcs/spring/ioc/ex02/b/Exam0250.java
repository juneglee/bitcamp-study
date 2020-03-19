// 객체 생성 - bean의 별명을 알아내기 : 별명만 여러 개인 경우
package com.eomcs.spring.ioc.ex02.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam0250 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex02/b/application-context.xml");

    // 빈의 id와 클래스 명을 출력하기
    SpringUtils.printBeanList(iocContainer);

    String[] aliases = iocContainer.getAliases("c8");
    System.out.println("[별명]");
    for (String alias : aliases) {
      System.out.println(alias);
    }
    // => 여러 개의 별명을 지정할 때 공백(), 콤마(,), 세미콜론(;)을 사용하여
    // 별명을 구분 할 수 있다
    // => 그 외의 문자는 구분자로 사용할 수 없다
    // 콜론(:)은 구분자가 아니여서 c8은 한개이다.
  }
}


