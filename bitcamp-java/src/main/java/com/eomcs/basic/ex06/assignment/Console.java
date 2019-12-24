package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Console {
  
  @Deprecated
  // 기존의 사용자에 경고
  static int inputInt(){
    return inputInt("밑변길이? ");
  } 
  
  static int inputInt(String message){
    Scanner sc =  new Scanner (System.in);
    System.out.print(message);
    int width = sc.nextInt();
    sc.close();
    return width;
  } 
}

