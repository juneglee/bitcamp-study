package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonDetailServlet {

  LessonService lessonService;

  public LessonDetailServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/detail")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int no = Integer.parseInt(params.get("no"));

    Lesson lesson = lessonService.get(no);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/lesson/list'>");
    out.println("<title>수업 상세 정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 상세 정보</h1>");

    if (lesson != null) {
      out.printf("번호: %d<br>\n", lesson.getNo());
      out.printf("수업명: %s<br>\n", lesson.getTitle());
      out.printf("설명: %s<br>\n", lesson.getDescription());
      out.printf("시작일: %s<br>\n", lesson.getStartDate());
      out.printf("종료일: %s<br>\n", lesson.getEndDate());
      out.printf("총수업시간: %d<br>\n", lesson.getTotalHours());
      out.printf("일수업시간: %d<br>\n", lesson.getDayHours());

      // out.printf("<p><a href='/lesson/delete?no=%d'>삭제</a>\n", lesson.getNo());
      // out.printf("<a href='/lesson/updateForm?no=%d'>변경</a></p>\n", lesson.getNo());
    } else {
      out.println("<p> 해당 번호의 강의가 없습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
