// Mybatis - SQL에 파라미터 지정하기 : 값 한 개를 넘길 때
package com.eomcs.mybatis.ex02;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex02/mybatis-config04.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // SQL을 실행할 때 파라미터 값을 전달하려면
    // 두 번째 파라미터로 전달해야 한다.
    // 여러 개의 값을 전달해야 한다면,
    // Map 객체에 담아 전달하라!

    // 예) 게시글에 xxx를 포함한
    List<Board> list = sqlSession.selectList("BoardMapper.selectBoard1", 3);
    // Object 이지만 오토 박싱(Integer.valueOf(3))으로 인하여 3으로 사용이 가능하다

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s\n", board.getNo(), board.getTitle(), board.getContent(),
          board.getRegisteredDate());
    }

    sqlSession.close();
  }

}


