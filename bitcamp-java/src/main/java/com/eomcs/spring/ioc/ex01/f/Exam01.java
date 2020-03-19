// IoC 컨테이너에 객체를 보관하기
package com.eomcs.spring.ioc.ex01.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {
  public static void main(String[] args) {
    // 3) 자바 클래스 파일의 애노테이션으로부터 설정 정보를 추출한다.
    // => 자바 클래스로 설정 정보를 다루는 것을 'java config' 라 부른다.
    // => 생성자에 파라미터로 java config 클래스의 타입 정보를 넘긴다.
    ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    // AppConfig.class : 객체를 넘기는 것이 아니라 타입을 넘기는 것이다.

    // 현재 IoC 컨테이너에 들어 있는 객체를 출력해 보자.
    SpringUtils.printBeanList(iocContainer);

    // AnnotationConfigApplicationContext 로 만든 IoC 컨테이너는
    // 애노테이션을 처리할 때 사용할 기본적인 도구들이 들어있다.

    System.out.println("실행 완료!");
  }
}


