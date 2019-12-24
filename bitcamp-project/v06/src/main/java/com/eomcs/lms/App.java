
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
public class App {


  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    final int SIZE = 100;
    
    int[] no = new int[SIZE];
    String[] title = new String[SIZE];
    String[] description = new String[SIZE];
    Date[] startDate = new Date[SIZE];
    Date[] endDate = new Date[SIZE];
    int[] totalHours = new int[SIZE];
    int[] dayHours = new int[SIZE];
    int[] viewCount = new int[100];
    String response;
    
    int count = 0;
    for (int i = 0; i < 100; i++) {
      
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine(); 
      
      System.out.print("수업명? ");
      title[i] = keyboard.nextLine(); 
      
      System.out.print("설명? ");
      description[i] = keyboard.nextLine();
      
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboard.next());
      
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboard.next());
      
      System.out.print("총수업시간? ");
      totalHours[i] = keyboard.nextInt();
      
      System.out.print("일수업시간? ");
      dayHours[i] = keyboard.nextInt();
      keyboard.nextLine(); // 정수 다음에 오는 문자열에 대해 입력받을 못받기 때문에 nextLine을 추가 한다.      
      
      viewCount[i] = 0;
      
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
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간"
          + "\n일수업시간: %d 시간\n조회수: %d\n ",
          no[j], title[j], description[j], startDate[j], endDate[j], 
          totalHours[j],dayHours[j],viewCount[j]);
           
    } 
  }
}
