package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.AbstractList;
import com.eomcs.util.Prompt;

public class MemberHandler {

  AbstractList<Member> memberList;
  
  Prompt prompt; 

  public MemberHandler(Prompt prompt,AbstractList<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }

  public void addMember() {
    Member member = new Member();

    member.setNo(prompt.inputInt("번호? "));
    member.setName(prompt.inputString("이름? "));
    member.setEmail(prompt.inputString("이메일?"));
    member.setPassword(prompt.inputString("암호? "));
    member.setPhoto(prompt.inputString("사진? "));
    member.setTel(prompt.inputString("전화번호? "));
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
    int index = indexOfMember(prompt.inputInt("번호? "));
    
    Member member = this.memberList.get(index);
    
    if (index == -1) {
      System.out.println("멤버 인덱스가 유효하지 않습니다");
      return;
    }
    System.out.printf("번호 : %d\n" , member.getNo());
    System.out.printf("이름 : %s\n", member.getName());
    System.out.printf("이메일 : %s\n", member.getEmail());
    System.out.printf("비번 : %s\n", member.getPassword());
    System.out.printf("전화번호 : %s\n", member.getTel());
  }

  public void upateMember() {
    int index = indexOfMember(prompt.inputInt("번호? "));
      
      Member oldMember = this.memberList.get(index);
      Member newMember = new Member();
      
      newMember.setNo(oldMember.getNo());
      
      newMember.setName(prompt.inputString(String.format("이름(%s)? ", oldMember.getName()),
                        oldMember.getName()));
      
      newMember.setEmail(prompt.inputString(String.format("이메일(%s)? ", oldMember.getEmail()),
          oldMember.getEmail()));
      
      newMember.setPassword(prompt.inputString(String.format("암호(%s)? ", oldMember.getPassword()),
          oldMember.getPassword()));
      
      newMember.setPhoto(prompt.inputString(String.format("사진(%s)? ", oldMember.getPhoto()),
          oldMember.getPhoto()));
      
      newMember.setTel(prompt.inputString(String.format("전화번호(%s)? ", oldMember.getTel()),
          oldMember.getTel()));


      if (oldMember.equals(newMember)) {
        System.out.println("멤버 변경을 취소했습니다.");
      } else {
        this.memberList.set(index, newMember);
        System.out.println("멤버을 변경했습니다.");
      }
    } 

    public void deleteMember() {
      int index = indexOfMember(prompt.inputInt("번호? "));

      if (index == -1) {
        System.out.println("멤버 인덱스가 유효하지 않습니다");
        return; 
      }

      this.memberList.remove(index);
      System.out.println("멤버을 삭제하였습니다.");
    }
    
    public int indexOfMember(int no) {
      for (int i = 0 ; i < this.memberList.size(); i++) {
        if (this.memberList.get(i).getNo() == no) {
          return i;
        }
      }
      return -1;
    }
  }



