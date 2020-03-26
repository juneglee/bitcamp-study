package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberListServlet {

  MemberService memberService;

  public MemberListServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println(" <haed>");
    out.println("   <meta charset='UTF-8'>");
    out.println(" </haed>");
    out.println("  <body>");
    out.println(" <haed>");
    out.println(" <h1>멤버</h1>");
    out.println(" <table border='1'>");
    out.println(" <a href='/member/addForm'> 새 글</a><br>");
    out.println("<tr>");
    out.println(" <th>번호</th>");
    out.println(" <th>이름</th>");
    out.println(" <th>이메일</th>");
    out.println(" <th>전화</th>");
    out.println(" <th>등록일</th>");
    out.println("</tr>");


    List<Member> members = memberService.list();
    for (Member m : members) {
      out.printf(" <tr>"//
          + "<td>%d</td> "//
          + "<td><a href='/member/detail?no=%d'>%s</a></td> "//
          + "<td>%s</td> "//
          + "<td>%s</td> "//
          + "<td>%s</td>" //
          + "</tr>\n", //
          m.getNo(), m.getNo(), m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }

    out.println("</table>");

    out.println("<hr>");

    out.println("<form action='/member/search'>");
    out.println("검색어: <input name='keyword' type='text'>");
    out.println("<button>검색</button>");

    out.println("</body>");
    out.println("</html>");
  }
}
