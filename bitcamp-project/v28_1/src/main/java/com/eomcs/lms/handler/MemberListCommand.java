package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {
  //
  List<Member> memberList;


  public MemberListCommand(List<Member> list) {

    this.memberList = list;
  }


  @Override
  public void execute() {
    Iterator<Member> iterator = memberList.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("번호: %d 이름: %s 이메일: %s 비번: %s 전화번호: %s\n", m.getNo(), m.getName(),
          m.getEmail(), m.getPassword(), m.getTel());
    }
  }


}


