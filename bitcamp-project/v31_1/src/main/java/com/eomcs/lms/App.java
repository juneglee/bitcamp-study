
package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import com.eomcs.lms.context.ApplicationContextListener;
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

  Scanner keyboard = new Scanner(System.in);

  Deque<String> commandStack = new ArrayDeque<>();
  Queue<String> commandQueue = new LinkedList<>();

  List<Lesson> lessonList = new ArrayList<>();
  List<Member> memberList = new ArrayList<>();
  List<Board> boardList = new ArrayList<>();

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  public void service() {

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> CommandMap = new HashMap<>();
    // 사용자의 명령을 받을 맵을 준비 한다

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

      if (command.equals("quit")) {
        System.out.println("안녕");
        break;
      } else if (command.equals("History")) {
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

    notifyApplicationDestroyed();
  }

  private void printCommandHistory(Iterator<String> iterator) {

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

  public static void main(String[] args) {
    App app = new App();

    app.addApplicationContextListener(new DataLoaderListener());
    app.addApplicationContextListener(new GreetingListener());

    app.service();
  }
}
