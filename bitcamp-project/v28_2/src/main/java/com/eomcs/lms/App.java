
package com.eomcs.lms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static LinkedList<Board> boardList = new LinkedList<>();
  static LinkedList<Member> memberList = new LinkedList<>();

  public static void main(String[] args) {
    // 파일에서 데이터 로딩
    loadLessonData();
    loadBoardData();
    loadMemberData();

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> CommandMap = new HashMap<>();
    // 사용자의 명령을 받을 맵을 준비 한다

    CommandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    // 게시물 등록을 처리하기 위한 명령어를 처리한다
    CommandMap.put("/board/list", new BoardListCommand(boardList));
    CommandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    CommandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    CommandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));

    CommandMap.put("/lesson/add", new LessonAddCommand(prompt, lessonList));
    CommandMap.put("/lesson/list", new LessonListCommand(lessonList));
    CommandMap.put("/lesson/detail", new LessonDetailCommand(prompt, lessonList));
    CommandMap.put("/lesson/update", new LessonUpdateCommand(prompt, lessonList));
    CommandMap.put("/lesson/delete", new LessonDeleteCommand(prompt, lessonList));

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

      commandStack.push(command);
      commandQueue.offer(command);
      Command commandHandler = CommandMap.get(command);
      // 명령어를 입력한 사용자의 담당자를 hashMap를 통해서 찾는다
      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생 : %s\n", e.getMessage());
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다. ");
      }
    }
    keyboard.close();

    // 데이터 파일에 저장
    saveLessonData();
    saveBoardData();
    saveMemberData();
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

  private static void loadLessonData() {
    File file = new File("./lesson.json");
    FileReader in = null;
    Scanner dateScan = null;

    try {
      in = new FileReader(file);
      dateScan = new Scanner(in);
      int count = 0;


      while (true) {
        try {
          lessonList.add(Lesson.valueOf(dateScan.nextLine()));
          count++;

        } catch (Exception e) {
          break;
        }

      }
      System.out.printf("총 %d 개의 수업 데이터를 로딩했습니다  \n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기중 오류발생! -" + e.getMessage());
    } finally {
      try {
        dateScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveLessonData() {
    File file = new File("./lesson.json");
    FileWriter out = null;
    try {
      out = new FileWriter(file);
      int count = 0;
      for (Lesson lesson : lessonList) {

        out.write(lesson.toCSVString() + "\n");
        count++;
      }
      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다 \n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기중 오류발생! -" + e.getMessage());
    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }


  private static void loadBoardData() {
    File file = new File("./board.json");

    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(file);

      dataScan = new Scanner(in);
      int count = 0;
      while (true) {
        try {
          boardList.add(Board.valueOf(dataScan.nextLine()));
          // 안쪽을 ()부터 바깥쪽으로 ()으로 읽어 들인다
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d명의 게시판 데이터를 로딩했습니다\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.json");

    FileWriter out = null;

    try {
      out = new FileWriter(file);
      int count = 0;

      for (Board board : boardList) {
        out.write(board.toCSVString() + "\n");
        count++;
      }
      System.out.printf("총 %d명의 게시판 데이터를 저장했습니다\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기중 오류발생! -" + e.getMessage());
    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

  private static void loadMemberData() {
    File file = new File("./member.json");

    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;


      while (true) {
        try {
          memberList.add(Member.valueOf(dataScan.nextLine()));
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 명의 멤버의 데이터를 로딩했습니다.\n ", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생\n" + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveMemberData() {
    File file = new File("./member.json");

    FileWriter out = null;
    try {
      out = new FileWriter(file);
      int count = 0;

      for (Member member : memberList) {
        out.write(member.toCSVString() + "\n");
        count++;
      }
      System.out.printf("총 %d 명의 멤버의 데이터를 저장했습니다.\n ", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생\n" + e.getMessage());
    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }

  }
}


