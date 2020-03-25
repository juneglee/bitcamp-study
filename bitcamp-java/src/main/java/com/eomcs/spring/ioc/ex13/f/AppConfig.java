// 스프링 IoC 컨테이너를 설정하는 클래스
package com.eomcs.spring.ioc.ex13.f;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @Configuration // 이 클래스가 설정 클래스임을 선언한다.
// 아래처럼 클래스로 지정할 때는 configuration을 사용할 필요없다.
@ComponentScan("com.eomcs.spring.ioc.ex13.f")
@EnableAspectJAutoProxy
public class AppConfig {
}
