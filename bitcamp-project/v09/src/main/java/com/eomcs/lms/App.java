
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
public class App {


  static Scanner keyboard = new Scanner(System.in);
  static class Lesson{
    int no;
    String title;
    String description;
    Date startDate;
    Date endDate;
    int totalHours;
    int dayHours;
    int viewCount;
  }
  static class Member{
    int no;
    String name;
    String email;
    String password;
    String photo;
    String tel;
    Date registeredDate;
  }
  static class Board{
    int no;
    String title;
    Date date;
    int viewCount;
  }

  static final int lessonSIZE = 100;
  static Lesson[] lessons = new Lesson[lessonSIZE];
  static int lessonCount = 0;

  static final int memberSIZE = 100;
  static Member[] members = new Member[memberSIZE]; 
  static int memberCount = 0;

  static final int boardSIZE = 100;
  static Board[] boards = new Board[boardSIZE]; 
  static int boardCount = 0;

  public static void main(String[] args) {


    String command; 
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command){
        case "/lesson/add":
          //분리된 코드(메서드)를 실행(호촐)시킨다
          // > 보통 "메서드를 호출한다"라고 표현한다
          addLesson();
          break;

        case "/lesson/list":
          listLesson();
          break;

        case "/member/add":
          addMember();
          break;

        case "/member/list":
          listMember(); 
          break;

        case "/board/add":
          addBoard();          

          break;

        case "/board/list":
          listBoard();
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("명령을 실행할 수 없니다.");
          } 
      }
    } while (!command.equalsIgnoreCase("quit"));
    System.out.println("안녕! ");
  }
  static void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine(); 

    System.out.print("설명? ");
    lesson.description = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.next());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.next());

    System.out.print("총수업시간? ");
    lesson.totalHours = keyboard.nextInt();

    System.out.print("일수업시간? ");
    lesson.dayHours = keyboard.nextInt();
    keyboard.nextLine(); 

    lessons[lessonCount++] = lesson;
    System.out.println("저장하였습니다");
  }
  static void listLesson() {
    for (int i = 0; i < lessonCount; i++) {
      Lesson l = lessons[i];
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간"
          + "\n일수업시간: %d 시간\n조회수: %d\n ",
          l.no, l.title, l.description, l.startDate, 
          l.endDate,l.totalHours,l.dayHours,l.viewCount);
    }
  }
  static void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("이름? ");
    member.name = keyboard.nextLine();

    System.out.print("이메일? ");
    member.email = keyboard.nextLine();

    System.out.print("암호? ");
    member.password = keyboard.nextLine();

    System.out.print("사진? ");
    member.photo = keyboard.nextLine();

    System.out.print("전화번호? ");
    member.tel = keyboard.nextLine();

    member.registeredDate =new Date(System.currentTimeMillis());

    members[memberCount++]= member;
    System.out.println("저장하였습니다");

  }
  static void listMember() {
    for (int i = 0; i < memberCount; i++) {
      Member m = members[i];
      System.out.printf("번호: %d 이름: %s 이메일: %s 암호: %s 전화번호: %s\n",
          m.no, m.name, m.email, m.password, m.tel);
    } 

  }
  static void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = keyboard.nextInt();
    keyboard.nextLine(); 

    System.out.print("내용? ");
    board.title = keyboard.nextLine();

    board.date = new Date(System.currentTimeMillis());

    boards[boardCount++] = board;
    System.out.println("저장하였습니다");

  }
  static void listBoard() {
    for (int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.no, b.title, b.date, b.viewCount);
    }

  }

}

