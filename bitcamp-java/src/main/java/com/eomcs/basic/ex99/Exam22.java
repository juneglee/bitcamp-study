package com.eomcs.basic.ex99;

public class Exam22 {
  public static void main(String[] args){
    //키보드 정보를 가져온다
    java.io.InputStream keyboard = System.in;

    java.util.Scanner Scanner = new java.util.Scanner(keyboard); 
    //스캐너는 키보드에 들어온 데이터를 끊어주는 도우미
    
    System.out.print("입력>");
    
    int i1 = Scanner.nextInt();

    int i2 = Scanner.nextInt();

    int i3 = Scanner.nextInt();


    System.out.println("---------------------------------------------------------------------");

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);
    // 키보드로부터 들어온 바이트 배열을 분석하여 줄바꿈 기호를 만나면 
    // 그 앞에 입력한 바이트 배열을 문자열로 변환하여 리턴한다.
    // 키보드로부터 줄바꿈(엔터) 값이 들어오지 않으면 영원히 리턴하지 않는다 

    //next int(0)
    // 스페이스 , 탭, 뉴 라인을 만나면, 그 앞까지 입력한 문자열을 int 값으로 바꿔 리턴한다
    // 입력한 문자열이 숫자를 의미하는 

   
   

  }
}