package bitcamp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class App2WebApplicationInitializer // front controller인 Dispatcher servlet을 대신해서 등록한다
    extends AbstractAnnotationConfigDispatcherServletInitializer {


  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {App2Config.class}; // Dispatcher의 IoC 의 설정정보를 가지고 있다 .
  }

  @Override
  protected String[] getServletMappings() { // Dispatcher 어떤 요청을 처리하는지
    return new String[] {"/app2/*"};
  }

  @Override
  protected String getServletName() {
    return "app2";
  }
}


