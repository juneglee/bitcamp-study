
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
public class App {


  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    // 강의 정보를 담을 메모리의 설계도를 만든다
    // 클래스란?
    // - 애플리케이션에서 특정 데이터의 메모리 구조를 설계하는 문법이다.
    
    class Lesson{
      int no;
      String title;
      String description;
      Date startDate;
      Date endDate;
      int totalHours;
      int dayHours;
      int viewCount;
    }
    
    final int SIZE = 100;
    
    Lesson[] lessons = new Lesson[SIZE]; 
    String response;

    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      
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
      keyboard.nextLine(); // 정수 다음에 오는 문자열에 대해 입력받을 못받기 때문에 nextLine을 추가 한다.      
      
      lesson.viewCount = 0;
      
      // 수업 정보를 담고 있는 인스턴스의 주소를 나중에 사용할 수 있도록
      // 래퍼런스 배열에 보관해 둔다
      lessons[i] = lesson;
      count++;
      
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      
      if (!response.equalsIgnoreCase("y")) {//response가 y가 아니라면
        break;
      }
    }
    
    keyboard.close();

    System.out.println();

    for (int j = 0; j < count; j++) {
      Lesson lesson = lessons[j];
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간"
          + "\n일수업시간: %d 시간\n조회수: %d\n ",
          lesson.no, lesson.title, lesson.description, lesson.startDate, 
          lesson.endDate,lesson.totalHours,lesson.dayHours,lesson.viewCount);
           
    } 
  }
  
}
