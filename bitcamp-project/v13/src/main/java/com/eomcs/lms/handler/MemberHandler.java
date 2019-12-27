package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  
  //인스턴스 필드 (non-static 필드)
  // new 명령을 생성할 때 생성
  Member[] members = new Member[memberSIZE]; 
  int memberCount = 0;
  
  //v클래스 필드 = static
  // 공유하는 변수 
  // 클래스가 메모리에 로딩될 때 자동으로 생성
  static final int memberSIZE = 100;
  public static Scanner keyboard;

  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("이름? ");
    member.name = keyboard.nextLine();

    System.out.print("이메일? ");
    member.email = keyboard.nextLine();

    System.out.print("암호? ");
    member.password = keyboard.nextLine();

    System.out.print("사진? ");
    member.photo = keyboard.nextLine();

    System.out.print("전화번호? ");
    member.tel = keyboard.nextLine();

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



