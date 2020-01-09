
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
    System.out.print("번호 ? ");
    int no = input.nextInt();
    input.nextLine(); 

    int index = indexOfBoard(no);
    if (index== -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return; 
    }
    Board board = this.boardList.get(index);
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
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); 
    
    int index = indexOfBoard(no);
    
    if (index == -1) {
      System.out.println("해당번호의 게시글이 없습니다.");
      return; 
    }
    
    Board oldBoard = this.boardList.get(index);
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
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); 
    
    int index = indexOfBoard(no);
   

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다");
      return; 
    }
    this.boardList.remove(index);
    System.out.println("게시글을 삭제하였습니다.");

  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < this.boardList.size(); i++) {
      // size 만큼 반복문을 사용
      if ( this.boardList.get(i).getNo() == no) {
        // get에서는 인덱스의 번호와 size(count)의 번호를 이용하여 list에 배열을 다시 담는다 
        // 인덱스의 값을 받아서 리턴하는 get을 이용하여 size만큰 i번째 까지 반복을 한다  
        // 이때 size만큼 반복을 하며 인덱스의 번호와 입력한 값이 동일 하다면 i번째의 값을 리턴한다 
        // 결국 입력값의 no를 0에서 size만큼 사용하도록 만들었다 
        return i;
        // 
      }
    }
    return -1;
    // 음수를 사용하는 이유는 값을 정의 할때 0부터 size까지 범위를 정했기 때문에 
    // 범위안에서 벗어난 음수값을 적용하고, 그때 리턴한 값을 사용하여 print를 사용하여 출력한다
    // 이때 null값을 사용할 수 없다 
  }
}