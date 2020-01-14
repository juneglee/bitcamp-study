
package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.ArrayList;
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
          printCommandHistory();
          break;
        case "history2":
          printCommandHistory2();
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
  
  private static void printCommandHistory() {
    Stack<String> historyStack = (Stack<String>) commandStack.clone();


    int count = 0; // 5개씩 끊어서 
    while (! historyStack.empty()) {
      System.out.println(historyStack.pop());
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

  private static void printCommandHistory2() {
    Queue<String> historyStack = (Queue<String>) commandQueue.clone();
    int count = 0;
    while (historyStack.size() > 0) {
      System.out.println(historyStack.poll());

      if ((++count % 5) == 0) {// 카운트의 값을 조사하기 전에 미리 증가 시키자
        System.out.print(":");
        String str =keyboard.nextLine();  
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
  
}

