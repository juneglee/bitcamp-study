package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;
import com.eomcs.sql.DataSource;
import com.eomcs.sql.PlatformTransactionManager;

// 애플리케이션이 시작되거나 종료될 때 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {

  // 다른 클래스에서 커넥션 객체를 사용할 수 있도록 공개한다
  // => Servlet 클래스에서 트랜잭션을 다루기 위해 이 커넥션 객체를 사용한다.


  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {

      // DB 연결 정보
      String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
      String username = "study";
      String password = "1111";

      // connection 팩토리 준비
      DataSource dataSource = new DataSource(jdbcUrl, username, password);
      context.put("dataSource", dataSource);


      // 데이터가 저장되어 있는 List 객체를 이 메서드를 호출한 쪽(App)에서
      // 사용할 수 있도록 Map 객체에 담아둔다.
      context.put("boardDao", new BoardDaoImpl(dataSource));
      context.put("memberDao", new MemberDaoImpl(dataSource));
      context.put("lessonDao", new LessonDaoImpl(dataSource));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(dataSource));
      context.put("photoFileDao", new PhotoFileDaoImpl(dataSource));

      // 트랜젝션 관리자 준비
      PlatformTransactionManager txManager = new PlatformTransactionManager(dataSource);
      context.put("txManager", txManager);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    // 애플리케이션이 종료될 때
    // 모든 DB 커넥션을 명시적으로 끊어준다
    // 그러면 DBMS는 Timeout 될 때까지 기다릴 필요가 없이
    // 클라이언트와 연결된 스레드를 즉시 해제 시킬 수 있다
    DataSource dataSource = (DataSource) context.get("dataSource");
    dataSource.clean();
  }


}
