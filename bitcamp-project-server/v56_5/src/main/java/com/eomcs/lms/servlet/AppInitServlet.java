package com.eomcs.lms.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.AppConfig;

// 웹 애플리케이션이 사작할 때 자동 생성되게 한다.
// loadOnStartup의 목적은 클라이어트 처리 목적이 아니라
// 다른 서블릿의 객체를 생성하여 준비하는 역할을 한다.

@WebServlet(value = "/AppInitServlet", loadOnStartup = 1)
public class AppInitServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static Logger logger = LogManager.getLogger(AppInitServlet.class);

  @Override
  public void init() throws ServletException {
    try {
      ApplicationContext iocContainer = new AnnotationConfigApplicationContext(//
          AppConfig.class);
      printBeans(iocContainer);

      ServletContext servletContext = getServletContext();
      servletContext.setAttribute("iocContainer", iocContainer);

      logger.debug("----------------------------");

      // 서블릿 객체는 더이상 'Spring IoC 컨테이너'에서 관리하지 않는다.
      // 서블릿 객체의 관리 주체가 서블릿 컨테이너로 넘어갔다.
      //
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void printBeans(ApplicationContext appCtx) {
    logger.debug("Spring IoC 컨테이너에 들어있는 객체들:");
    String[] beanNames = appCtx.getBeanDefinitionNames();
    for (String beanName : beanNames) {
      logger.debug(String.format("%s =======> %s", //
          beanName, //
          appCtx.getBean(beanName).getClass().getName()));
    }

  }

  // init (config)는 톰켓 서버에서 불러들여서 사용하고 init()는 config에서 불러드린다
}
