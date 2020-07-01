package com.eomcs.lms.Service;

import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardService {

  int delete(int no) throws Exception;

  List<Board> list() throws Exception;

  int update(Board board) throws Exception;

  int add(Board board) throws Exception;

  Board get(int no) throws Exception;

}

