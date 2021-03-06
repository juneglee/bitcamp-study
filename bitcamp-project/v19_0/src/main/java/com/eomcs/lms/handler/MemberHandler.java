package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

public class MemberHandler {

  ArrayList<Member> memberList;
  Scanner input; 

  public MemberHandler(Scanner input) {
    this.input = input;
    memberList = new ArrayList<>();
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

    this.memberList.add(member);;
    System.out.println("저장하였습니다");

  }

  public void listMember() {
    // member 객체의 목록을 저장할 배열을 넘기는데 크기가 0인 배열을 넘긴다 
    // toArray()는 내부에서 새 배열을 만들고, 값을 복사한 후 리턴한다 
    Member[] arr = this.memberList.toArray(new Member[] {});
    // 빈 배열을 만들고 게시판에 리턴하고 배열을 저장한다 
    for (Member m : arr) {
      System.out.printf("번호: %d 이름: %s 이메일: %s 비번: %s 전화번호: %s\n",
          m.getNo(), m.getName(), m.getEmail(), m.getPassword(), m.getTel());
    } 
  }
  
  public void detailMember() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 
    
    Member member = (Member) this.memberList.get(index);
    
    if (member == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다");
      return;
    }
    System.out.printf("번호 : %d\n" , member.getNo());
    System.out.printf("이름 : %s\n", member.getName());
    System.out.printf("이메일 : %s\n", member.getEmail());
    System.out.printf("비번 : %s\n", member.getPassword());
    System.out.printf("전화번호 : %s\n", member.getTel());
  }

  public void upateMember() {
    System.out.println("게시글 인덱스?");
    int index = input.nextInt();
    input.nextLine();

    Member oldMember = (Member) this.memberList.get(index);

    if (oldMember == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다");
      return;
    }

    System.out.printf("내용(%s) ?", oldMember.getName());
    String name = input.nextLine();

    if (name.length() == 0) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }

    Member newMember = new Member();
    newMember.setNo(oldMember.getNo());
    newMember.setName(name);
    newMember.setEmail(oldMember.getEmail());
    newMember.setPassword(oldMember.getPassword());
    newMember.setTel(oldMember.getTel());
    
    this.memberList.set(index,newMember);
    System.out.println("게시글을 변경했습니다.");

  }

  
  public void deleteMember() {
    System.out.print("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 

    Member member = (Member) this.memberList.get(index);

    if (member== null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다");
      return; 
    }
    
    this.memberList.remove(index);
    System.out.println("게시글을 삭제하였습니다.");
  }
}



