package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDetailCommand implements Command {
  //
  List<Member> memberList;

  Prompt prompt;

  public MemberDetailCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }


  @Override
  public void execute() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    Member member = this.memberList.get(index);

    if (index == -1) {
      System.out.println("멤버 인덱스가 유효하지 않습니다");
      return;
    }
    System.out.printf("번호 : %d\n", member.getNo());
    System.out.printf("이름 : %s\n", member.getName());
    System.out.printf("이메일 : %s\n", member.getEmail());
    System.out.printf("비번 : %s\n", member.getPassword());
    System.out.printf("전화번호 : %s\n", member.getTel());
  }


  public int indexOfMember(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      if (this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


