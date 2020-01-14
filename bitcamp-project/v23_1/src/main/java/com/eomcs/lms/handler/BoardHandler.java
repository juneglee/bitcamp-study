
package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;


public class BoardHandler {
  // ArrayList나 LinkedList를 마음대로 사용할 수 있도록 
  // 게시물 목록을 관리하는 필드에 선언할 때 
  // 이들 클래스의 수퍼 클래스를 선언한다.
  // => 대신 이 필드에 들어갈 객체는 생성자에서 파라미터로 받는다
  // => 이렇게 하면 ArrayList나 LinkedList 모두 사용할 수 있어 유지보수에 유리하다 
  List<Board> boardList;
  Prompt prompt; 

  public BoardHandler(Prompt prompt,List<Board> list/* dependency*/) {
    //ArrayList나 LinkedList 둘다 사용할 수 있어야 한다
    this.prompt = prompt;
    this.boardList = list; 
    // Handler가 사용할 list 객체(의존객체)를 생성자에서 직접 만들지 않고
    // 이렇게 생성자가 호출될 때 파라미터로 받으면,
    // 필요에 따라 List 객체를 다른 객체로 대체하기가 쉽다
    // 예를 들어 ArrayList를 사용하다가 LinkedList로 바꾸기 쉽다. 
    // LinkedList를 사용하다가 다른 객체로 바꾸기가 쉽다.
    // 즉, 다형적 변수에 법칙에 따라 List의 하위 객체라면 어떤 객체든지 가능하다 
    // 이런식으로 의존 객체를 외부에서 주입받는 것을 
    // "dependency injection"(의존성 주입)이라 부른다
    // - 즉 의존객체를 부품화하여 교체하기 쉽도록 만드는 방식이다 
    // - 참조 변수를 슈퍼 클래스로 사용하여 의존성 주입을 한다
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