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
    member.no = input.nextInt();
    input.nextLine(); 

    System.out.print("이름? ");
    member.name = input.nextLine();

    System.out.print("이메일? ");
    member.email = input.nextLine();

    System.out.print("암호? ");
    member.password = input.nextLine();

    System.out.print("사진? ");
    member.photo = input.nextLine();

    System.out.print("전화번호? ");
    member.tel = input.nextLine();

    member.registeredDate =new Date(System.currentTimeMillis());

    this.members[this.memberCount++]= member;
    System.out.println("저장하였습니다");

  }
  public void listMember() {
    for (int i = 0; i < this.memberCount; i++) {
      Member m = this.members[i];
      System.out.printf("번호: %d 이름: %s 이메일: %s 암호: %s 전화번호: %s\n",
          m.no, m.name, m.email, m.password, m.tel);
    } 
  }
}



