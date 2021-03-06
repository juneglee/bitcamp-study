// dynamic sql 다루기 - <where> 사용 후
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0150 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 실행 예:
    // => 여러 개의 조건을 합쳐서 검색하기
    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);
    System.out.print("번호? ");
    String value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("no", value);
    }

    System.out.print("제목? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }

    System.out.print("내용? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("content", value);
    }

    keyScan.close();

    List<Board> list = sqlSession.selectList("BoardMapper.select6", params);

    // select5 의 문제점
    // no값이 없을 경우 잘못된 SQL 문을 생성한다
    // where 첫번째 or 두번쨰에서 첫번째 값을 입력하지 않으면 첫번째값이 공백이고,
    // 두번째 값은 or 구문과 연결하여 사용하기 때문에 오류가 발생한다.

    // 해결책
    // where
    // 1=0 <== or 앞에 실행에 영향을 끼지지 않는 조건문 삽입

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", //
          board.getNo(), //
          board.getTitle(), //
          board.getContent(), //
          board.getRegisteredDate(), //
          board.getViewCount());
    }

    sqlSession.close();
  }
}


