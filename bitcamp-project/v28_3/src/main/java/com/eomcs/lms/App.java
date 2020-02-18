
package com.eomcs.lms;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
import com.google.gson.Gson;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  static List<Lesson> lessonList = new ArrayList<>();
  static List<Board> boardList = new ArrayList<>();
  static List<Member> memberList = new ArrayList<>();

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

    try (FileReader in = new FileReader(file)) {
      lessonList.addAll(Arrays.asList(new Gson().fromJson(in, Lesson[].class)));
      // null값이여도 위세 만들어 놓은 빈공간의 배열에 집어 넣어서 오류를 잡는다
      // asList ; list로 만들어진 모든 객체를 넘겨 받는다/ 반복문 대신
      // 하지만 읽기기능만 있고 쓰기 기능이 없기 때문에 오류 발생함
      // ArrayList와 LinkedList는 리스트를 받아서 초기화 시키는게 가능하다
      System.out.printf("총 %d 개의 수업 데이터를 로딩했습니다  \n", lessonList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기중 오류발생! -" + e.getMessage());
    }
  }

  private static void saveLessonData() {
    File file = new File("./lesson.json");
    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(lessonList));
      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다 \n", lessonList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기중 오류발생! -" + e.getMessage());
    }
  }


  private static void loadBoardData() {
    File file = new File("./board.json");

    try (FileReader in = new FileReader(file)) {
      boardList.addAll(Arrays.asList(new Gson().fromJson(in, Board[].class)));
      System.out.printf("총 %d 명의 게시판 데이터를 로딩했습니다\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.json");

    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(boardList));
      System.out.printf("총 %d 명의 게시판 데이터를 저장했습니다\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기중 오류발생! -" + e.getMessage());
    }
  }

  private static void loadMemberData() {
    File file = new File("./member.json");

    try (FileReader in = new FileReader(file)) {
      memberList.addAll(Arrays.asList(new Gson().fromJson(in, Member[].class)));

      System.out.printf("총 %d 명의 멤버의 데이터를 로딩했습니다.\n ", memberList.size());
    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생\n" + e.getMessage());
    }
  }

  private static void saveMemberData() {
    File file = new File("./member.json");
    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(memberList));
      System.out.printf("총 %d 명의 멤버의 데이터를 저장했습니다.\n ", memberList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생\n" + e.getMessage());
    }
  }
}

