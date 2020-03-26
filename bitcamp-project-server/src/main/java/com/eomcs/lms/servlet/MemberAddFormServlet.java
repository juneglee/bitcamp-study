package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberAddFormServlet {

  MemberService memberService;

  public MemberAddFormServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>멤버 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>멤버 입력</h1>");
    out.println("<form action='/member/add'>");

    out.println("이름:<br> ");
    out.println("<textarea name='name' rows='1' cols='60'></textarea><br>");
    out.println("이메일:<br> ");
    out.println("<textarea name='email' rows='1' cols='60'></textarea><br>");
    out.println("암호:<br> ");
    out.println("<textarea name='password' rows='1' cols='60'></textarea><br>");
    out.println("사진:<br> ");
    out.println("<textarea name='photo' rows='1' cols='60'></textarea><br>");
    out.println("전화<br> ");
    out.println("<textarea name='tel' rows='1' cols='60'></textarea><br>");
    out.println("<button>제출</button><br>");

    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
