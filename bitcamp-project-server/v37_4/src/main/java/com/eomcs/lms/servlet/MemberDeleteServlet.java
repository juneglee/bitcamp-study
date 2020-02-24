package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;

public class MemberDeleteServlet implements Servlet {

  MemberDao memberDao;

  public MemberDeleteServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호 ?"); // 사용자에게 출력하라
    out.println("!{}!"); // 사용자에게 한 줄의 문자열을 입력 받아서 보내라!
    out.flush();

    int no = Integer.parseInt(in.nextLine());
    if (memberDao.delete(no) > 0) { // 삭제했다면
      out.println("멤버를 삭제했습니다.");

    } else {
      out.println("해당 번호의 회원이 없습니다.");
    }
  }
}
