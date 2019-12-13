package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;
// 개인 프로젝의 내용을 출력
public class App {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in);
    
    System.out.print("번호? ");
    int no = keyboard.nextInt();
    
    keyboard.nextLine();
    
    System.out.print("주제? ");
    String title = keyboard.nextLine();
    System.out.print("설명? ");
    String desription = keyboard.nextLine();
    System.out.print("시작일? ");
    Date startDate = Date.valueOf(keyboard.next());
    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyboard.next());
    
    System.out.println();
    
    System.out.printf("번호: %d \n", no);
    System.out.printf("주제: %s \n", title); //Period of Circulation
    System.out.printf("설명: %s \n", desription); //일반 음식점이나 가정에서 사용하는 유통기간을 관리하여 효율적 재료를 관리한다
    System.out.printf("기간: %s ~ %s \n", startDate, endDate);
    
    keyboard.close();
    
  }
}
