package com.eomcs.lms;

import java.io.InputStream;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.Service.impl.BoardServiceImpl;
import com.eomcs.lms.Service.impl.LessonServiceImpl;
import com.eomcs.lms.Service.impl.MemberServiceImpl;
import com.eomcs.lms.Service.impl.PhotoBoardServiceImpl;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.SqlSessionFactoryProxy;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      // Mybatis 객체 준비
      InputStream inputStream = Resources.getResourceAsStream(//
          "com/eomcs/lms/conf/mybatis-config.xml");

      // 트랜잭션 제어를 위해 오리지널 객체를 프록시 객체에 담아 사용한다.
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryProxy(//
          new SqlSessionFactoryBuilder().build(inputStream));
      context.put("sqlSessionFactory", sqlSessionFactory);



      // 이 메서드를 호출한 쪽(App)에서 DAO 객체를 사용할 수 있도록 Map 객체에 담아둔다.
      BoardDao boardDao = new BoardDaoImpl(sqlSessionFactory);
      LessonDao lessonDao = new LessonDaoImpl(sqlSessionFactory);
      MemberDao memberDao = new MemberDaoImpl(sqlSessionFactory);
      PhotoBoardDao photoBoardDao = new PhotoBoardDaoImpl(sqlSessionFactory);
      PhotoFileDao photoFileDao = new PhotoFileDaoImpl(sqlSessionFactory);

      // 트랜잭션 관리자 준비
      PlatformTransactionManager txManager = new PlatformTransactionManager(//
          sqlSessionFactory);
      context.put("transactionManager", txManager);

      // ServerApp에서 SqlSession 객체를 꺼낼 수 있도록,
      // SqlSessionFactory 를 저장한다.
      context.put("sqlSessionFactory", sqlSessionFactory);

      context.put("lessonService", new LessonServiceImpl(lessonDao));
      context.put("boardService", new BoardServiceImpl(boardDao));
      context.put("memberService", new MemberServiceImpl(memberDao));
      context.put("photoBoardService",
          new PhotoBoardServiceImpl(txManager, photoBoardDao, photoFileDao));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}

}
