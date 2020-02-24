package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardAddServlet implements Servlet {
  PhotoBoardDao photoBoardDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    PhotoBoard photoBoard = new PhotoBoard();

    out.println("제목? ");
    out.println("!{}!");
    out.flush();
    photoBoard.setTitle(in.nextLine());

    out.println("수업 번호? ");
    out.println("!{}!");
    out.flush();

    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(in.nextLine()));

    photoBoard.setLesson(lesson); // 따로 저장하지말고 한번에 저장해서 넘겨라

    if (photoBoardDao.insert(photoBoard) > 0) {
      out.println("새 사진 게시글을 등록했습니다");

    } else {
      out.println("사진 게시물 등록에 실패했습니다.");
    }
  }
}
