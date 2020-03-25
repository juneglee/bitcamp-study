package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonListServlet {

  LessonService lessonService;

  public LessonListServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println(" <haed>");
    out.println("   <meta charset='UTF-8'>");
    out.println(" </haed>");
    out.println("  <body>");
    out.println(" <haed>");
    out.println(" <h1>수업</h1>");
    out.println(" <table border='1'>");
    out.println(" <a href='/lesson/addForm'> 새 글</a><br>");
    out.println("<tr>");
    out.println(" <th>번호</th>");
    out.println(" <th>주제</th>");
    out.println(" <th>시작일</th>");
    out.println(" <th>종료일</th>");
    out.println(" <th>총 수업 시간</th>");
    out.println("</tr>");


    List<Lesson> lessons = lessonService.list();
    for (Lesson l : lessons) {
      out.printf(" <tr>"//
          + "<td>%d</td> "//
          + "<td><a href='/lesson/detail?no=%d'>%s</a></td> "//
          + "<td>%s</td> "//
          + "<td>%s</td> "//
          + "<td>%d</td>" //
          + "</tr>\n", //
          l.getNo(), //
          l.getNo(), //
          l.getTitle(), //
          l.getStartDate(), //
          l.getEndDate(), //
          l.getTotalHours()//
      );
    }
    out.println("</body>");
    out.println("</html>");
  }
}
