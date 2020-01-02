package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;


public class BoardHandler {
  
  BoardList boardList;
  Scanner input; 
  // 주소만 있기 때문에 생성자를 생성하여 연결한다

  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new BoardList();
  }

  public BoardHandler (Scanner input, int capacity) {
    this.input = input;
    this.boardList = new BoardList(capacity);
  }

  
  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine(); 

    System.out.print("내용? ");
    board.setTitle(input.nextLine());

    board.setDate(new Date(System.currentTimeMillis()));

    this.boardList.add(board);
    // board에  값들을 자동으로 저장해줘
    System.out.println("저장하였습니다");

  }


  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int no =input.nextInt();
    input.nextLine(); 

    Board board = this.boardList.get(no);
   

    if (board== null) {
      System.out.println("게시물 번호가 유효하지 않습니다");
      return; 
    }

    System.out.printf("번호 : %d\n" , board.getNo());
    System.out.printf("제목 : %s\n", board.getTitle());
    System.out.printf("등록일 : %s\n", board.getDate());
    System.out.printf("조회수 : %d\n", board.getViewCount());
  }
  public void listBoard() {
    Board[] boards = this.boardList.toArray();
    // 전체의 배열중에 특정 인스턴스를 값을 리턴하기 위해서 조인한다
    for (int i = 0; i < boardList.size; i++) {
      Board b = boardList.list[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }

}