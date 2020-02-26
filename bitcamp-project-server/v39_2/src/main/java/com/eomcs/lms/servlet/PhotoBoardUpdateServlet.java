package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.Prompt;

public class PhotoBoardUpdateServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardUpdateServlet(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;


  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "사진 게시물 번호?");

    PhotoBoard old = photoBoardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 사진 게시물이 없습니다.");
      return;
    }

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(
        Prompt.getString(in, out, String.format("제목(%s)? \n ", old.getTitle()), old.getTitle()));
    photoBoard.setNo(no);

    try {
      if (photoBoardDao.update(photoBoard) == 0) {
        throw new Exception("사진 게시글의 변경에 실패 했습니다.");
      }
      out.println();
      out.println("사진 일부만 변경할 수 없습니다");
      out.println("전체를 새로 등록해야 합니다");

      printPhotoFiles(out, no);// 첨부파일을 화면에 뿌린다

      String response = Prompt.getString(in, out, "사진을 변경하시겠습니까?(y/n)");
      if (response.equalsIgnoreCase("y")) {

        // 이 사진 게시글에 첨부 되었던 기존 파일을 모두 삭제 한다
        photoFileDao.deleteAll(no);
      }
      // 첨부파일을 입력 받는다
      List<PhotoFile> photoFiles = inputPhotoFiles(in, out);
      for (PhotoFile photoFile : photoFiles) {
        photoFile.setBoardNo(no);
        // 어느 게시물인지 번호가 들어있지 않기 때문에
        // 번호로 어떤 게시물인지 확인하고 데이터베이스에 넣는다
        photoFileDao.insert(photoFile);
      }
      out.println("사진 게시글을 변경했습니다.");

    } catch (Exception e) {

      out.println(e.getMessage());
    }
  }

  private void printPhotoFiles(PrintStream out, int boardNo) throws Exception {
    // 사진파일의 목록을 출력하는 일을 한다
    out.println("사진 파일:");
    List<PhotoFile> oldPhotoFiles = photoFileDao.findAll(boardNo);
    for (PhotoFile photoFile : oldPhotoFiles) {
      out.printf(">%s\n", photoFile.getFilepath());
    }
  }

  private List<PhotoFile> inputPhotoFiles(Scanner in, PrintStream out) {
    // 첨부파일을 입력 받는다
    out.println("최소 한개의 사진 파일을 등록해야 합니다.");
    out.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다");

    ArrayList<PhotoFile> photoFiles = new ArrayList<>();
    while (true) {

      String filepath = Prompt.getString(in, out, "사진 파일? ");
      if (filepath.length() == 0) {
        if (photoFiles.size() > 0) {
          break;
        } else {
          out.println("최소 한 개의 사진 파일을 등록해야 합니다");
          continue;
        }
      }
      photoFiles.add(new PhotoFile().setFilepath(filepath));
    }
    return photoFiles;
  }
}
