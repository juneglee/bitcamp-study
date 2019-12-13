package com.bitcamp.myproject;



import java.util.Scanner;
// 한명의 회원 정보를 출력
public class App2 {

  public static void main(final String[] args) {
    Scanner keyboard = new Scanner (System.in);
    
       
    System.out.print("카카오톡 회원 등록? ");
    String registration = keyboard.nextLine();
    System.out.print("이름? ");
    String name = keyboard.nextLine();
    System.out.print("이메일? ");
    String email = keyboard.nextLine();
    System.out.print("인증방법? ");
    String certification = keyboard.nextLine();
    System.out.print("비번? ");
    String password = keyboard.nextLine();
    System.out.print("비번확인? ");
    String check = keyboard.nextLine();
    System.out.print("전화번호? ");
    String tel = keyboard.nextLine();

   
    
    System.out.println();
    System.out.printf("등록: %s \n", registration);
    System.out.printf("이름: %s \n", name); //Period of Circulation
    System.out.printf("이메일: %s \n", email); //일반 음식점이나 가정에서 사용하는 유통기간을 관리하여 효율적 재료를 관리한다
    System.out.printf("인증방법: %s \n", certification);
    System.out.printf("비번: %s \n", password);
    System.out.printf("비번확인: %s \n", check);
    System.out.printf("전화번호: %s \n", tel);
  
    keyboard.close();
  }

}
