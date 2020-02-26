package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardDao {
  // 데이터를 저장하고 꺼내는 방식(파일, 웹하드 ,클라우드저장소, DB 등)에 사용할 떄
  // DAO 사용법을 통일하기 위해서 메서드 호출 규칙을 정의한다

  public int insert(Board board) throws Exception;

  public List<Board> findAll() throws Exception;

  public Board findByNo(int no) throws Exception;

  public int update(Board board) throws Exception;

  public int delete(int no) throws Exception;

}
