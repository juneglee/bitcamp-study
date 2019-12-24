package com.eomcs.lms;

import java.util.Scanner;
import java.sql.Date;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    class Member{
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date registeredDate;
    }

    final int SIZE = 100;

    Member[] members = new Member[SIZE]; 
    
    String response;

    int count = 0;
    for (int i = 0; i < SIZE; i++ ) {

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

      count++;
      // 회원 정보를 담겨있는 인스턴스의 주소를 레퍼런스 배열에 보관한다.
      members[i]= member;

      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) "); 
      response = keyboard.nextLine();

      if (!response.equalsIgnoreCase("y")) {
        break;
      } 
    }
    keyboard.close();

    System.out.println();

    for (int j = 0; j < count; j++) {
      Member member = members[j];
      System.out.printf("번호: %d 이름: %s 이메일: %s 암호: %s 전화번호: %s\n",
          member.no, member.name, member.email, member.password, member.tel);
    }   
  }   
} 

