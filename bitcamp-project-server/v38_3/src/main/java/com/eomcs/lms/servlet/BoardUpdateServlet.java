package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardUpdateServlet implements Servlet {

  // Dao 클래스를 구체적으로 저장하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다
  BoardDao boardDao;


  public BoardUpdateServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호?");

    Board old = boardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    Board board = new Board();

    board.setTitle(Prompt.getString(//
        in, //
        out, //
        String.format("제목(%s)? \n", old.getTitle()), //
        old.getTitle())); // 만약 사용자가 엔터를 치면 그대로 올드값을 사용한다
    board.setNo(no);

    if (boardDao.update(board) > 0) {
      out.println("게시글을 변경했습니다.");
    } else {
      out.println("게시글 변경에 실패했습니다.");
    }
  }
}
