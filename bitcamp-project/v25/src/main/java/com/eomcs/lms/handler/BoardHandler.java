// List() 메서드 변경
// => toArray()를 사용하는 대신 iterator()의 리턴 값을 사용하여 목록 출력.
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {
  List<Board> boardList;
  Prompt prompt; 

  public BoardHandler(Prompt prompt,List<Board> list/* dependency*/) {
    this.prompt = prompt;
    this.boardList = list; 
  }

  public void addBoard() {
    Board board = new Board();
    
    board.setNo(prompt.inputInt("번호? "));
    board.setTitle(prompt.inputString("제목? "));

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    boardList.add(board);
    System.out.println("저장하였습니다");

  }

  public void detailBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
    
    if (index == -1) {
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
    // boardlist에게 값을 꺼내는 일을 해줄 iterator 객체를 달라고 한다 
    Iterator<Board> iterator = boardList.iterator();
    
    // Iterator 객체에게 목록에게 꺼낼 값을 있는지 물어 본다
    while (iterator.hasNext()) {
      // 값이 있다고 한다면, 그 값을 꺼내 달라고 한다
      Board b = iterator.next();
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }

  public void updateBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
    
    if (index == -1) {
      System.out.println("해당번호의 게시글이 없습니다.");
      return; 
    }
    
    
    
    Board oldBoard = this.boardList.get(index);
    Board newBoard = new Board();
    
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    
    newBoard.setTitle(prompt.inputString(String.format("내용(%s) ? ", oldBoard.getTitle()),
        oldBoard.getTitle()));
    
    newBoard.setDate(new Date(System.currentTimeMillis()));

    if (oldBoard.equals(newBoard)) {
      System.out.println("게시물의 변경을 취소했습니다.");
      return;
    } else {
    this.boardList.set(index,newBoard);
    System.out.println("게시글을 변경했습니다.");
    }

  }

  public void deleteBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
   

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