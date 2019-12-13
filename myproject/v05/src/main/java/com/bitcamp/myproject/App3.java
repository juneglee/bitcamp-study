package com.bitcamp.myproject;

import java.sql.Date;
//관리시스템 창화면  (가정, 일반음식점, 기업 등) - 스캐너 정보 출력
import java.util.Scanner;
//한명의 회원 정보를 출력
public class App3 {

  public static void main(final String[] args) {
    Scanner keyboard = new Scanner (System.in);

    System.out.print("코드? ");
    int code = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("상품? ");
    String product = keyboard.nextLine();
    System.out.print("종류? ");
    String type = keyboard.nextLine();
    System.out.print("수량? ");
    int quantity = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("제조일자? ");
    Date manufacturedate = Date.valueOf(keyboard.next());
    System.out.print("등록일자? ");
    Date registrationdate = Date.valueOf(keyboard.next());
    System.out.print("유통기한? ");
    Date deadline = Date.valueOf(keyboard.next());
    System.out.print("제품설명? ");
    String explanation = keyboard.nextLine();
    keyboard.nextLine();
    System.out.print("상품 상태(유통기간)? ");
    String state = keyboard.nextLine();



    System.out.println();

    System.out.printf("코드: %d \n", code);
    System.out.printf("상품: %s \n", product);
    System.out.printf("종류: %s \n", type); 
    System.out.printf("수량: %d \n", quantity);
    System.out.printf("제조일자: %s \n", manufacturedate);
    System.out.printf("등록일자: %s \n", registrationdate);
    System.out.printf("유통기한: %s \n", deadline);
    System.out.printf("제품설명: %s \n", explanation);
    System.out.printf("상품상태: %s \n", state);
    
    keyboard.close();

  }

}
