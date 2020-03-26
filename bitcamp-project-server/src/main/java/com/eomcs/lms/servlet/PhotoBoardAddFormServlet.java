package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class PhotoBoardAddFormServlet {

  MemberService memberService;

  public PhotoBoardAddFormServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/photoboard/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>포토보드 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>포토보드 입력</h1>");
    out.println("<form action='/photoboard/add'>");

    out.println("주제:<br> ");
    out.println("<textarea titl='주제' rows='1' cols='60'></textarea><br>");
    out.println("등록일:<br> ");
    out.println("<textarea cdt='등록일' rows='1' cols='60'></textarea><br>");
    out.println("조회수:<br> ");
    out.println("<textarea vw_cnt='조회수' rows='1' cols='60'></textarea><br>");

    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
