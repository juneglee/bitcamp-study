package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;


public class BoardHandler {

  static final int boardSIZE = 100;
  static Board[] boards = new Board[boardSIZE]; 
  //배별을 스태틱으로 만들었기 때문에 하나의 데이터를 하나의 메서드로 할수 있다
  static int boardCount = 0;

  // default :즉 public이 없거나, 아무것도 없으면 default이며 같은 패키지는 공유할 수 있다 
  // private : 같은 패키지이여도 접근 불가능 
  public static Scanner keyboard;
  // public : 다른 패키지에 있는 클래스에서도 이 변수를 사용하게 하려면 공개해야 한다.
  // protected : 자식까지는 전달


  public static void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("내용? ");
    board.title = keyboard.nextLine();

    board.date = new Date(System.currentTimeMillis());

    boards[boardCount++] = board;
    System.out.println("저장하였습니다");

  }


  public static void detailBoard() {
    System.out.print("게시물 번호? ");
    int no =keyboard.nextInt();
    keyboard.nextLine(); // 숫자 뒤에 남은 공백 제거용

    Board board = null;
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == no) {
        board = boards[i];
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

  public static void listBoard() {
    for (int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.no, b.title, b.date, b.viewCount);
    }
  }
}


