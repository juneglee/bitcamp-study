package com.eomcs.basic.ex99;

public class Exam231 {
  public static void main(String[] args){
    java.util.Scanner Scanner = new java.util.Scanner(System.in); 
    

    System.out.print("입력>");
    
    int i1 = Scanner.nextInt();
    int i2 = Scanner.nextInt();
    // 공백만 그냥 읽는다
    
    // next
    //=> 한 개의 token(단어)을 읽는다
    //=> 공백을 만날 때 까지 읽는다
    //=> 앞 공백은 제거 한다
    //=> 물론 nextint와 달리 값을 읽은 후 공백은 제거한다 
    
    String s1 = Scanner.next();

    String s2 = Scanner.next();

    int i3 = Scanner.nextInt();

    String s4 = Scanner.next();


    System.out.println("---------------------------------------------------------------------");

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s4);


   
   

  }
}