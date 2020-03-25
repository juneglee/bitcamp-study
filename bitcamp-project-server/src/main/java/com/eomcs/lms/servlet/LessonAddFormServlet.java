package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonAddFormServlet {

  LessonService lessonService;

  public LessonAddFormServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시글 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 입력</h1>");
    out.println("<form action='/lesson/add'>");
    out.println("내용:<br> ");
    out.println("<textarea name='title' rows='2' cols='60'></textarea><br>");
    out.println("설명:<br> ");
    out.println("<textarea name='description' rows='2' cols='60'></textarea><br>");
    out.println("시작일:<br> ");
    out.println("<textarea name='startDate' rows='2' cols='60'></textarea><br>");
    out.println("종료일:<br> ");
    out.println("<textarea name='endDate' rows='2' cols='60'></textarea><br>");
    out.println("총 수업시간:<br> ");
    out.println("<textarea name='totalHours' rows='2' cols='60'></textarea><br>");
    out.println("일 수업시간:<br> ");
    out.println("<textarea name='dayHours' rows='2' cols='60'></textarea><br>");
    out.println("<button>제출</button><br>");

    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
