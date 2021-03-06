package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;


public class BoardHandler {

  // 인스턴스 필드 (= non-static 필드)
  // => new 명령을 실행해야만 생성되는 변수
  // => 개별적으로 관리되어야 하는 값일 경우 인스턴스 필드로 선언한다.
  // 
  Board[] boards = new Board[boardSIZE]; 
  int boardCount = 0;
  
  //클래스 필드 (= static 필드)
  // => method Area 에 클래스 코드가 로딩될때 자동 생성
  // => 공통으로 사용할 값일 경우 클래스 필드로 선언한다
  
  static final int boardSIZE = 100;
  public static Scanner keyboard;
  
  //클래스 메서드
  // => 인스턴스 없이 호출하는 메서드
  // => 인스턴스를 사용하려면 파라미터를 통해 호출할 때 외부에서 받아야 한다
  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("내용? ");
    board.title = keyboard.nextLine();

    board.date = new Date(System.currentTimeMillis());

    this.boards[this.boardCount++] = board;
    System.out.println("저장하였습니다");

  }


  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int no =keyboard.nextInt();
    keyboard.nextLine(); // 숫자 뒤에 남은 공백 제거용

    Board board = null;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break;
      }
    }

    if (board== null) {
      System.out.println("게시물 번호가 유효하지 않습니다");
      return; // 메소드를 중간에서 중단하고 싶을떄는 return한다
    }

    System.out.printf("번호 : %d\n" , board.no);
    System.out.printf("제목 : %s\n", board.title);
    System.out.printf("등록일 : %s\n", board.date);
    System.out.printf("조회수 : %d\n", board.viewCount);
  }
  // 인스턴스 메서드
  // 인스턴스.메서드명();
  // 이렇게 인스턴싀 변수 값을 다루는 메서드는 "연산자(operator)"라 부를 수 있다.

  public void listBoard() {
    for (int i = 0; i < this.boardCount; i++) {
      Board b = this.boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.no, b.title, b.date, b.viewCount);
    }
  }
}


