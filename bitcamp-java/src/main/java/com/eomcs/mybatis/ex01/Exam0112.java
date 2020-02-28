// Data Persistence Framework 도입 - Mybatis 설정 파일의 InputStream 얻는 방법
package com.eomcs.mybatis.ex01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0112 {

  public static void main(String[] args) throws Exception {

    SqlSessionFactory factory = new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("com/eomcs/mybatis/ex01/Mybatis-config.xml"));

    SqlSession sqlSession = factory.openSession();

    System.out.println("mybatis 준비 완료!");

    sqlSession.close();
  }

}

