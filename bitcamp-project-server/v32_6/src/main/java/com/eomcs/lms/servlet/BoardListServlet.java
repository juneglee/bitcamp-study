package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListServlet implements Servlet {

  List<Board> boards;

  // 의존객체는 생성자에서 받아서 사용한다
  public BoardListServlet(List<Board> boards) {
    this.boards = boards;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(boards);
  }
}
