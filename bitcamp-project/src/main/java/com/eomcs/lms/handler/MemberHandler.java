package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;

public class MemberHandler {
  static class Member{
    int no;
    String name;
    String email;
    String password;
    String photo;
    String tel;
    Date registeredDate;
  }

  static final int memberSIZE = 100;
  static Member[] members = new Member[memberSIZE]; 
  static int memberCount = 0;

  public static Scanner keyboard;

  public static void addMember() {
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

    members[memberCount++]= member;
    System.out.println("저장하였습니다");

  }
  public static void listMember() {
    for (int i = 0; i < memberCount; i++) {
      Member m = members[i];
      System.out.printf("번호: %d 이름: %s 이메일: %s 암호: %s 전화번호: %s\n",
          m.no, m.name, m.email, m.password, m.tel);
    } 
  }
}



