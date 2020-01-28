
package com.eomcs.lms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
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

    CommandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
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
    // 데이터가 보관된 파일의 정보를 준비한다
    // comma separate value
    File file = new File("./lesson.csv");
    // . 일때 현재 폴더
    // 존재 하던 말던 레퍼런스를 만든다

    // 파일을 읽을 때 사용할 도구를 준비한다.
    // 빨대를 꼽아서 읽는다
    FileReader in = null; // FileReader : 읽어 드리는데 한줄단위로 읽는게 없다
    Scanner dateScan = null;

    try {
      in = new FileReader(file);
      // FileReader에서 제공하는 데이터 읽기 도구가 쓰기에 적합하지 않다
      // .csv파일에 한 줄 단위로 문자열을 읽는 기능이 필요한데
      // FileReader에는 그런 기능이 없다.
      // 그래서 FileReader를 그대로 사용할 수 없고, 이 객체에 다른 도구를 연결하여 사용할 것이다.

      dateScan = new Scanner(in);
      // 빨대에 한줄단위로 읽게 만들게 한다
      int count = 0;


      while (true) {
        try {
          // 파일에서 한 줄을 읽는다
          // 언제 멈출지 NoSearchElement를 리턴하 때 리턴이 발생(Scanner의 특징)
          String Line = dateScan.nextLine();
          // 한 줄을 콤마(,)로 나눈다
          String[] data = Line.split(",");

          // 한줄에 들어 있던 데이터를 추찰하여 Lesson 객체에 담는다
          // = 데이터를 저장한 형식대로 읽을때도 마찬기로 형식으로 출력한다
          Lesson lesson = new Lesson();
          lesson.setNo(Integer.parseInt(data[0]));
          lesson.setTitle(data[1]);
          lesson.setDescription(data[2]);
          lesson.setStartDate(Date.valueOf(data[3]));
          lesson.setEndDate(Date.valueOf(data[4]));
          lesson.setTotalHours(Integer.parseInt(data[5]));
          lesson.setDayHours(Integer.parseInt(data[6]));

          // lesson 객체를 command가 사용하는 목록에 저장한다
          lessonList.add(lesson);
          count++;

        } catch (Exception e) {
          break;
        }

      }
      System.out.printf("총 %d 개의 수업 데이터를 로딩했습니다  \n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기중 오류발생! -" + e.getMessage());
      // 파일에서 데이터를 읽다가 오류가 발생하더라도 시스템을 멈추지 않고 계속 실행
      // 이것이 예외처리를 하는 이유이다.
    } finally {
      // 자원이 서로 연결된 경우에는 다른 자원을 이용하는 객체부터 닫는다
      try {
        dateScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행하다가 오류가 발생한 경우 무시한다
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
      }
    }
  }

  private static void saveLessonData() {
    // 데이터가 보관된 파일의 정보를 준비한다
    // comma separate value
    File file = new File("./lesson.csv");

    // 파일로 데이터를 저장할 때 사용할 도구를 준비한다.
    FileWriter out = null;
    try {
      out = new FileWriter(file);
      int count = 0;

      // 수업 목록에서 수업 데이터를 꺼내 CSV 문자열로 만든다
      for (Lesson lesson : lessonList) {
        String line = String.format("%d,%s,%s,%s,%s,%d,%d\n", lesson.getNo(), lesson.getTitle(),
            lesson.getDescription(), lesson.getStartDate(), lesson.getEndDate(),
            lesson.getTotalHours(), lesson.getDayHours());
        out.write(line);
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
    File file = new File("./board.csv");

    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(file);

      dataScan = new Scanner(in);
      int count = 0;
      while (true) {
        try {
          String line = dataScan.nextLine();

          String[] data = line.split(",");

          Board board = new Board();
          board.setNo(Integer.parseInt(data[0]));
          board.setTitle(data[1]);
          board.setDate(Date.valueOf(data[2]));
          board.setViewCount(Integer.parseInt(data[3]));
          board.setWriter(data[4]);

          boardList.add(board);
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
    File file = new File("./board.csv");

    FileWriter out = null;

    try {
      out = new FileWriter(file);
      int count = 0;

      for (Board board : boardList) {
        String line = String.format("%d,%s,%s,%d,%s\n", board.getNo(), board.getTitle(),
            board.getDate(), board.getViewCount(), board.getWriter());
        out.write(line);
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
    File file = new File("./member.csv");

    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;


      while (true) {
        try {
          String line = dataScan.nextLine();
          String[] data = line.split(",");

          Member member = new Member();
          member.setNo(Integer.parseInt(data[0]));
          member.setName(data[1]);
          member.setEmail(data[2]);
          member.setPassword(data[3]);
          member.setPhoto(data[4]);
          member.setTel(data[5]);
          member.setRegisteredDate(Date.valueOf(data[6]));

          memberList.add(member);
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
    File file = new File("./member.csv");

    FileWriter out = null;
    try {
      out = new FileWriter(file);
      int count = 0;

      for (Member member : memberList) {
        String line = String.format("%d,%s,%s,%s,%s,%s,%s\n", member.getNo(), member.getName(),
            member.getEmail(), member.getPassword(), member.getPhoto(), member.getTel(),
            member.getRegisteredDate());
        out.write(line);
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


