package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;
import com.eomcs.util.RequestMapping;

@Component
public class PhotoBoardDetailServlet {

  PhotoBoardService photoBoardService;

  public PhotoBoardDetailServlet( //
      PhotoBoardService photoBoardService) {
    this.photoBoardService = photoBoardService;
  }

  @RequestMapping("/photoboard/detail")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int no = Integer.parseInt(params.get("no"));

    PhotoBoard photoBoard = photoBoardService.get(no);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/photoboard/list'>");
    out.println("<title>포토보드 상세 정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>포토보드 상세 정보</h1>");

    if (photoBoard != null) {
      out.printf("번호: %d<br>\n", photoBoard.getNo());
      out.printf("제목: %s<br>\n", photoBoard.getTitle());
      out.printf("등록일: %s<br>\n", photoBoard.getCreatedDate());
      out.printf("조회수: %d<br>\n", photoBoard.getViewCount());
      out.printf("수업: %s<br>\n", photoBoard.getLesson().getTitle());
      out.println("사진 파일: <br>");

      for (PhotoFile photoFile : photoBoard.getFiles()) {
        out.printf("> %s<br>\n", photoFile.getFilepath());
      }

      out.printf("<p><a href='/photoboard/delete?no=%d'>삭제</a>\n", photoBoard.getNo());
      out.printf("<a href='/photoboard/updateForm?no=%d'>변경</a></p>\n", photoBoard.getNo());

    } else {
      out.println("<p> 해당 번호의 강의가 없습니다.</p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
