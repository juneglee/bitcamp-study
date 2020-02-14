package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.BoardDao;

// "/board/list" 명령어 처리
public class BoardListCommand implements Command {

  BoardDao boardDao;

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      // List<Board> boards = boardDao.findAll();

      // JDBC Driver(MariaDB 프록시)를 로딩한다
      Class.forName("org.mariadb.jdbc.Driver");

      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      Statement stmt = con.createStatement();

      // 데이터 가져올 도구를 준비
      ResultSet rs = stmt.executeQuery("select board_id, conts, cdt, vw_cnt from lms_board");

      // ResultSet를 사용하여 데이터를 하나씩 가져 온다

      while (rs.next()) {// 데이터를 가져왔으면 true를 리넡한다
        System.out.printf("%d, %s, %s, %d\n", //
            rs.getInt("board_id"), rs.getString("conts"), rs.getDate("cdt"), rs.getInt("vw_cnt"));
      }

      rs.close();
      stmt.close();
      con.close();

    } catch (Exception e) {
      System.out.println("목록 조회 실패!");
    }
  }


}


