package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;
import com.eomcs.util.RequestMapping;

@Component
public class PhotoBoardListServlet {

  PhotoBoardService photoBoardService;
  LessonService lessonService;

  public PhotoBoardListServlet(//
      PhotoBoardService photoBoardService, //
      LessonService lessonService) {
    this.photoBoardService = photoBoardService;
    this.lessonService = lessonService;
  }

  @RequestMapping("/photoboard/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int lessonNo = Integer.parseInt(params.get("no"));

    Lesson lesson = lessonService.get(lessonNo);
    if (lesson == null) {
      out.println("수업 번호가 유효하지 않습니다.");
      return;
    }

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println(" <haed>");
    out.println("   <meta charset='UTF-8'>");
    out.println(" </haed>");
    out.println("  <body>");
    out.println(" <haed>");
    out.println(" <h1>포토보드</h1>");
    out.println(" <table border='1'>");
    out.println(" <a href='/photoboard/addForm'> 새 글</a><br>");
    if (lessonNo > 0) {
      out.println("<tr>");
      out.println(" <th>번호</th>");
      out.println(" <th>수업명</th>");
      out.println(" <th>등록일</th>");
      out.println(" <th>조회수</th>");
      out.println("</tr>");

      List<PhotoBoard> photoBoards = photoBoardService.listLessonPhoto(lessonNo);

      for (PhotoBoard photoBoard : photoBoards) {
        out.printf(" <tr>"//
            + "<td>%d</td> "//
            + "<td><a href='/photoboard/detail?no=%d'>%s</a></td> "//
            + "<td>%s</td> "//
            + "<td>%d</td>" //
            + "</tr>\n", ///
            photoBoard.getNo(), //
            photoBoard.getNo(), //
            photoBoard.getTitle(), //
            photoBoard.getCreatedDate(), //
            photoBoard.getViewCount() //
        );
      }
    }
    out.println("</body>");
    out.println("</html>");
  }
}
