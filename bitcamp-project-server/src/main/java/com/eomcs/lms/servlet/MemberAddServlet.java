package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberAddServlet {

  MemberService memberService;

  public MemberAddServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/add")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    Member member = new Member();
    member.setName(params.get("name"));
    member.setName(params.get("name"));
    member.setName(params.get("name"));
    member.setName(params.get("name"));
    member.setName(params.get("name"));

    memberService.add(member);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/member/list'>");
    out.println("<title>멤버 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>멤버 입력 결과</h1>");

    out.println("<p>새 멤버을 등록했습니다.</p>");

    out.println("</body>");
    out.println("</html>");


  }
}
