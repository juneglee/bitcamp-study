package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  void contextInitialized(Map<String, Object> context);
  // 애플리케이션이 시작될 때 호출한다

  void contextDestroyed(Map<String, Object> context);
  // 애플리케이션이 종료될 때 호출된다
}
