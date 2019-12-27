package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;


public class BoardHandler {

  Board[] boards; 
  int boardCount = 0;

  // 사용자로부터 게시물 데이터를 입력 받을 때 키보드로부터 입력 받을 수 있지만.
  // 향우 네트워크나  파일에서도 입력 받을 수 있다.
  // 이런 경우를 대비하여 입력 데이터를 읽는 것을 keyboard로 한정하지 말자.
  // 각 게시판 마다 입력 받는 방식이 다르게 할 수 있도록 인스턴스 변수로 선언한다

  Scanner input; //dependence object : 의존객체

  static final int boardSIZE = 100;

  // 생성자 (constructor)
  // 인스턴스를 생성할 때 반드시 호출되는 메서드
  // new 명령을 실행할 때 호출될 생성자를 지정할 수 있다.
  // 의존 객체를 초기화 시키는 코드를 넣는다.
  // 생성자는 리턴 값이 없고, 클래스 이름과 같은 이름으로 메서드를 정의 한다.
  // 생성자를 실행할 때 사용할 값은 파라미터로 받는다
  public BoardHandler(Scanner input) {
    // Boardhandler를 실행하려면 데이터를 입력 받는 도구가 반드시 있어야 한다.
    // 이런 도구를 "의존 객체 (dependency object)"라 부른다 
    // 보통 "dependency"라 줄여서 부른다
    // 생정자에서 해야할 일은 인스턴스를 생성할 때 
    // 이런 의존 객체를 반드시 초기화시키도록 하는 것이다
    this.input = input;
    this.boards = new Board[boardSIZE];
  }

  public BoardHandler (Scanner input, int capacity) {
    this.input = input;
    if (capacity < boardSIZE || capacity > 10000)
      this.boards = new Board[boardSIZE];
    else
      this.boards = new Board[capacity];
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = input.nextInt();
    input.nextLine(); 

    System.out.print("내용? ");
    board.title = input.nextLine();

    board.date = new Date(System.currentTimeMillis());

    this.boards[this.boardCount++] = board;
    System.out.println("저장하였습니다");

  }


  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int no =input.nextInt();
    input.nextLine(); // 숫자 뒤에 남은 공백 제거용

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


