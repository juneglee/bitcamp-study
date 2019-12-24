package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    // 게시글 데이터를 저장할 메모리를 설계한다
    class Board{// 설계도일 뿐이며, 변수가 아니다 
      int no;
      String title;
      Date date;
      int viewCount;
    }

    final int SIZE = 100;
    // board 인스턴스의 주소를 담을 레퍼런스 배열을 준비한다
    Board[] boards = new Board[SIZE]; 

    String response;

    int count = 0;
    for (int i = 0; i < SIZE; i++) {

      // 사용자 입력한 게시물 데이터를 저장할 메모리르 board 설계도에 따라 만든다.
      Board board = new Board();


      System.out.print("번호? ");
      board.no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("내용? ");
      board.title = keyboard.nextLine();

      board.date = new Date(System.currentTimeMillis());
      board.viewCount = 0;
      
      // 게시물 데이터가 보관된 Board 인스턴스의 주소를 레퍼런스 배열에 저장한다
      boards[i] = board;
      // 사용하지 않는 공간을 생성하지 않음으로써 공간 낭비를 줄일 수 있다.
      // 인스턴스는 필요할때마다 만들어서 주소에 저장할 수 있다.
     
      count++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      Board board = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          board.no, board.title, board.date, board.viewCount);
    }
  }
}