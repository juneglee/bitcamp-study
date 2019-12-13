
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
public class App {


  public static void main(String[] args) {
    // 키보드에서 사용자가 입력한 값을 읽어 문자열이나 정수, 부동소주점 등으로 리턴하는 역할
    Scanner keyboard/*이름을 지정할때는 소문자를 사용 */ = new Scanner(System.in);
    
    System.out.print("번호? ");
    int no =/*할당연산자 */ keyboard.nextInt(); //문자열을 담을 메모리
    
    keyboard.nextLine(); //nextInt()후에 남아 있는 줄바꿈 기호를 제거한다.
    
    System.out.print("수업명? ");
    String title = keyboard.nextLine(); 
    
    System.out.print("설명? ");
    String description = keyboard.nextLine();
    
    System.out.print("시작일? ");
    //"yyyy-mm-dd" 행태로 입력된 문자열을 날짜 정보로 바꾼다
    Date startDate = Date.valueOf(keyboard.next());
    
    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyboard.next());
    
    System.out.print("총수업시간? ");
    int totalHours = keyboard.nextInt();
    
    System.out.print("일수업시간? ");
    int dayHours = keyboard.nextInt();
    
    System.out.println();
    //온풍기.기능명()//객체,기능()//매소드,콜()
    System.out.printf("번호: %d\n", no);
   
    System.out.printf("수업명: %s\n", title);
    
    System.out.printf("설명: %s\n", description);
    
    //System.out.println("시작일: " + no3);
    
    //System.out.println("종료일: " + no4);
    System.out.printf("기간: %s ~ %s\n", startDate, endDate);
    
    System.out.printf("총수업시간: %d 시간\n", totalHours);  

    System.out.printf("일수업시간: %d 시간\n", dayHours);  
    
    keyboard.close(); // 프로그램을 돌려준다 (자료 찾아보기)

  }
}
