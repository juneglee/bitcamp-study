package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;


public class BoardHandler {

  ArrayList<Board> boardList;
  Scanner input; 

  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>(); // 생략하면 내부에서 사용하는 Board가 된다 
  }

  public BoardHandler (Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine(); 

    System.out.print("내용? ");
    board.setTitle(input.nextLine());

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);
    System.out.println("저장하였습니다");

  }

  public void detailBoard() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 

    Board board = (Board) this.boardList.get(index);

    if (board== null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다");
      return; 
    }

    System.out.printf("번호 : %d\n" , board.getNo());
    System.out.printf("제목 : %s\n", board.getTitle());
    System.out.printf("등록일 : %s\n", board.getDate());
    System.out.printf("조회수 : %d\n", board.getViewCount());
  }

  public void listBoard() {
    // BoardList의 배열에 보관된 값을 받을 배열을 준비한다 
    Board[] arr = new Board[this.boardList.size()];
    // list 갯수 만큼 배열을 넘긴다 
    
    // toArray()에게 빈 배열을 넘겨서 복사 받는다
    // Board[] arr2 = this.boardList.toArray(arr); 
    this.boardList.toArray(arr);
    // 넘겨받은 갯수와 리턴받은 갯수가 같기 때문에 리턴값을 받을 변수를 지정하지 않아도 된다
        
    for (Board b : arr) { // 배열전체를 반복한다 
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }
  
  public void updateBoard() {
    System.out.print("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 

    Board oldBoard = this.boardList.get(index);

    if (oldBoard== null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다");
      return; 
    }

    System.out.printf("내용(%s) ? ",oldBoard.getTitle());
    String title = input.nextLine();
    
    if (title.length() == 0) {
      System.out.println("게시물 변경을 취소했습니다.");
      return;
    }
    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setTitle(title);
    newBoard.setDate(new Date(System.currentTimeMillis()));
    
    this.boardList.set(index,newBoard);
    System.out.println("게시글을 변경했습니다.");
    
    
  }

  public void deleteBoard() {
    System.out.print("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 

    Board board = this.boardList.get(index);

    if (board== null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다");
      return; 
    }
    
    this.boardList.remove(index);
    System.out.println("게시글을 삭제하였습니다.");

  }

}