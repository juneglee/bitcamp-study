package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateServlet implements Servlet {

  MemberDao memberDao;

  public MemberUpdateServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    out.println("번호?");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());


    Member old = memberDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    Member member = new Member();

    out.printf("이름(%s)?", old.getName());
    out.println("!{}!");
    out.flush();
    member.setName(in.nextLine());

    out.printf("이메일(%s)?", old.getEmail());
    out.println("!{}!");
    out.flush();
    member.setEmail(in.nextLine());

    out.println("암호(%s)?");
    out.println("!{}!");
    out.flush();
    member.setPassword(in.nextLine());

    out.printf("사진(%s)?", old.getPhoto());
    out.println("!{}!");
    out.flush();
    member.setPhoto(in.nextLine());

    out.printf("전화(%s)?", old.getTel());
    out.println("!{}!");
    out.flush();
    member.setTel(in.nextLine());


    if (memberDao.update(member) > 0) {
      out.println("멤버를 변경했습니다.");
    } else {
      out.println("해당 번호의 멤버가 없습니다.");
    }
  }
}
