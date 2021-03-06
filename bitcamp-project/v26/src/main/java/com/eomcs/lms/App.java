
package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.ComputePlusCommand;
import com.eomcs.lms.handler.HelloCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Deque<String> commandStack = new ArrayDeque<>();

  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> CommandMap = new HashMap<>();
    // 제네릭을 사용하여 유효한 값을 입력하도록 하였다


    LinkedList<Board> boardList = new LinkedList<>();
    CommandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    CommandMap.put("/board/list", new BoardListCommand(boardList));
    CommandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    CommandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    CommandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));


    ArrayList<Lesson> LessonList = new ArrayList<>();
    CommandMap.put("/lesson/add", new LessonAddCommand(prompt, LessonList));
    CommandMap.put("/lesson/list", new LessonListCommand(LessonList));
    CommandMap.put("/lesson/detail", new LessonDetailCommand(prompt, LessonList));
    CommandMap.put("/lesson/update", new LessonUpdateCommand(prompt, LessonList));
    CommandMap.put("/lesson/delete", new LessonDeleteCommand(prompt, LessonList));



    LinkedList<Member> memberList = new LinkedList<>();
    CommandMap.put("/member/add", new MemberAddCommand(prompt, memberList));
    CommandMap.put("/member/list", new MemberListCommand(memberList));
    CommandMap.put("/member/detail", new MemberDetailCommand(prompt, memberList));
    CommandMap.put("/member/update", new MemberUpdateCommand(prompt, memberList));
    CommandMap.put("/member/delete", new MemberDeleteCommand(prompt, memberList));

    CommandMap.put("/hello", new HelloCommand(prompt));
    CommandMap.put("/compute/plus", new ComputePlusCommand(prompt));

    String command;

    while (true) {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0) 
        continue;
      
        commandStack.push(command);
        commandQueue.offer(command);

      if (command.equals("quit")) {
        System.out.println("안녕");
        break;
      }
      if (command.equals("History")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("History2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }

      Command commandHandler = CommandMap.get(command);
      // hashmap의 레퍼런스에 저장된 command값을 리턴하여
      // commandhandler에 레퍼런스로 저장한다
      // commandhandler을 레퍼런스 값으로 정하여 잘못된 명령을 입력헀을 때
      // 이때 값이 null이 아니면 계속 실행하고, 그밖의는 문구를 출력한다

      if (commandHandler != null) {
        commandHandler.execute();
      } else {
        System.out.println("실행할 수 없는 명령입니다. ");
      }
      // 왜 not을 이용한 if문인지 궁금함....????
    }
    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) {


    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }

    }
  }
}

