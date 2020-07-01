package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;

public class PhotoBoardDeleteServlet implements Servlet {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardDeleteServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    out.println("사진 게시물 번호 ?"); // 사용자에게 출력하라
    out.println("!{}!"); // 사용자에게 한 줄의 문자열을 입력 받아서 보내라!
    out.flush();

    int no = Integer.parseInt(in.nextLine());

    if (photoBoardDao.delete(no) > 0) {
      out.println("사진 게시글을 삭제했습니다");

    } else {
      out.println("해당 번호의 사진 게시물이 없습니다.");
    }
  }
}
