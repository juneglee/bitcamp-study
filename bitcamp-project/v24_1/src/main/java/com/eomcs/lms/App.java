
package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Iterator;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Prompt;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);
    
    // 단지 유지보수를 좋게 하기 위해 ArrayList와 LinkedList의 공통 분모를 뽑아서 
    // 만든 클래스가 List이다 
    // List는 실제 작업을 하는 클래스가 아니다
    // 그럼에도 불구하고 개발자가 다음과 같이 List 객체를 사용하려 한다면 막을 수 없다
    // => 하지만 실행할때 동작 자체를 안한다
    // why? 클래스에 정의된 메서드는 아무것도 하지 않는다???
    // 해결책 ? 
    // 일반화를 통해 만든 클래스의 경우 서브 클래스에게 공통 분모를 물려주기 위한 용도로 사용하며,
    // 이런 클래스는 직접 인스턴스을 생성하지 못하도록 막아서 막아야 한다
    // 이때 사용하는 것이 추상 클래스(Abstract)이다
    
    // list 클래스를 추상 클래스 만들면 다음과 같이 인스턴스를 생성할 수 없다
    // 아예 인스턴스 생성을 원천적으로 차단하는 효과가 있다 
    //AbstractList<Board> boardList = new AbstractList<>();
    // 반드시 AbstractList의 일반 하위 객체를 정의 해야 한다 
    
    LinkedList<Board> boardList = new LinkedList<>();
    BoardHandler boardHandler = new BoardHandler(prompt,boardList);
    
    ArrayList<Lesson> LessonList = new ArrayList<>();
    LessonHandler lessonHandler = new LessonHandler(prompt,LessonList);
    
    LinkedList<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(prompt,memberList);

    String command; 
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0) {
        continue;
      } else {
        commandStack.push(command);
        commandQueue.offer(command);
      }

      switch (command){
        case "/lesson/add":
          lessonHandler.addLesson();
          break;
        case "/lesson/list":
          lessonHandler.listLesson();
          break;
        case "/lesson/detail":
          lessonHandler.detailLesson();
          break;
        case "/lesson/update":
          lessonHandler.updateLesson();
          break;
        case "/lesson/delete":
          lessonHandler.deleteLesson();
          break;



        case "/member/add":
          memberHandler.addMember();
          break;
        case "/member/list":
          memberHandler.listMember(); 
          break;
        case "/member/detail":
          memberHandler.detailMember(); 
          break;
        case "/member/update":
          memberHandler.upateMember(); 
          break;
        case "/member/delete":
          memberHandler.deleteMember(); 
          break;


        case "/board/add":
          boardHandler.addBoard();          
          break;
        case "/board/list":
          boardHandler.listBoard();          
          break;
        case "/board/detail":
          boardHandler.detailBoard();
          break;
        case "/board/update":
          boardHandler.updateBoard();
          break;
        case "/board/delete":
          boardHandler.deleteBoard();
          break;

        case "history":
          printCommandHistory(commandStack.iterator());
          break;
        case "history2":
          printCommandHistory(commandQueue.iterator());
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("명령을 실행할 수 없니다.");
          } 
      }
    } while (!command.equalsIgnoreCase("quit"));
    System.out.println("안녕! ");
    keyboard.close();
  }
  
  // 이전에는 Stack에서 값을 꺼내는 방법과 Queue 에서 값을 꺼내는 방법이 다르기 때문에 
  // printCommandHistory()와 printCommandHistory2() 메서드를 따로 정리하였다 
  // 이제 Stack 과 queue 는 일관된 방식으로 값을 꺼내주는 iterator가 있기 때문에
  // 두 메서드를 하나로 합칠 수 있다 
  
  private static void printCommandHistory(Iterator<String>  iterator) {
    

    int count = 0; // 5개씩 끊어서 
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count ++ ;

      if ((count % 5) == 0) { //5배수이며, 5개마다 질문을 던져서 묻는다
        System.out.print(":");
        String str =keyboard.nextLine();  
        // 입력 값을 받아 출력을 하면 그 출력하기 전까지 push를 했던 값들이 입력값 전까지 pop이 되어 출력하게 된다
        // 그래서 초기 입력값까지 pop되면 history를 제외한 값들이 null이 된다
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      } // pop을 해서 꺼내면 남는게 없어진다

    }
  }

 
  
}

