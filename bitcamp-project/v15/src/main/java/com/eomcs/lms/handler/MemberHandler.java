package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  
  Member[] members; 
  int memberCount = 0;
  
  public Scanner input; 
  
  static final int memberSIZE = 100;
  
  public MemberHandler(Scanner input) {
    this.input = input;
    this.members = new Member[memberSIZE];
  }
  
  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(input.nextInt());
    input.nextLine(); 

    System.out.print("이름? ");
    member.setName(input.nextLine());

    System.out.print("이메일? ");
    member.setEmail(input.nextLine());

    System.out.print("암호? ");
    member.setPassword(input.nextLine());

    System.out.print("사진? ");
    member.setPhoto(input.nextLine());

    System.out.print("전화번호? ");
    member.setTel(input.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.members[this.memberCount++]= member;
    System.out.println("저장하였습니다");

  }
  public void listMember() {
    for (int i = 0; i < this.memberCount; i++) {
      Member m = this.members[i];
      System.out.printf("번호: %d 이름: %s 이메일: %s 암호: %s 전화번호: %s\n",
          m.getNo(), m.getName(), m.getEmail(), m.getPassword(), m.getTel());
    } 
  }
}



