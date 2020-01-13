
package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;
public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    BoardHandler boardHandler = new BoardHandler(prompt);
    LessonHandler lessonHandler = new LessonHandler(prompt);
    MemberHandler memberHandler = new MemberHandler(prompt);

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

