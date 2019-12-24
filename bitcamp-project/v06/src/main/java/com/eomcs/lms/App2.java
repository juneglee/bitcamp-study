package com.eomcs.lms;

import java.util.Scanner;
import java.sql.Date;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    final int SIZE = 100;// 값을 변경하지 못하는걸 알리기 위해서 SIZE를 대문자로 적는다
    
    int[] no = new int[SIZE];//배열의 개수가 정해져 있기 때문에 무한으로 사용하기 위해서 Linklist로 발정하게 되었다
    String[] name = new String[SIZE];
    String[] email = new String[SIZE];
    String[] password = new String[SIZE];
    String[] photo = new String[SIZE];
    String[] tel = new String[SIZE];
    Date[] registeredDate = new Date[SIZE];
    String response;
   
    int count = 0;
    for (int i = 0; i < SIZE; i++ ) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine(); 
      
      System.out.print("이름? ");
      name[i] = keyboard.nextLine();
      
      System.out.print("이메일? ");
      email[i] = keyboard.nextLine();
      
      System.out.print("암호? ");
      password[i] = keyboard.nextLine();
      
      System.out.print("사진? ");
      photo[i] = keyboard.nextLine();
      
      System.out.print("전화번호? ");
      tel[i] = keyboard.nextLine();
      
      registeredDate[i] =new Date(System.currentTimeMillis());
      
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

    for (int j = 0; j < count; j++) {
      System.out.printf("번호: %d 이름: %s 이메일: %s 암호: %s 전화번호: %s \n  ",
          no[j], name[j], email[j], password[j], tel[j]);
    }   
  } 
}
