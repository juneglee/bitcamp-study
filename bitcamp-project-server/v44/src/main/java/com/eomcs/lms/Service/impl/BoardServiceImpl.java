package com.eomcs.lms.Service.impl;

import java.util.List;
import com.eomcs.lms.Service.BoardService;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardServiceImpl implements BoardService {
  BoardDao boardDao;

  public BoardServiceImpl(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public int add(Board board) throws Exception {
    return boardDao.insert(board);
  }

  @Override
  public List<Board> list() throws Exception {
    return boardDao.findAll();
  }

  @Override
  public Board get(int no) throws Exception {
    return boardDao.findByNo(no);
  }

  @Override
  public int update(Board board) throws Exception {
    return boardDao.update(board);
  }

  @Override
  public int delete(int no) throws Exception {
    return boardDao.delete(no);
  }
}
