package com.eomcs.basic.ex99;

public class Exam11 {
  public static void main(String[] args){
    // 값 출력 하기 
    // pritnln() 사용법
    // -> 출력 + 줄바꿈
    System.out.println(100); 
    System.out.println(3.14);
    System.out.println(true);
    System.out.println('가');
    System.out.println("안녕!");

    System.out.println();
    // print() 사용법
    // -> 출력
    System.out.print(100); 
    System.out.print(3.14);
    System.out.print(true);
    System.out.print('가');
    System.out.print("안녕!");

    System.out.print('\n');

    System.out.print("OK!\n");
    System.out.print("NO!");

    //printf() 사용법
    //-> print("형식", 값1, 값2, ...)
    System.out.printf("\n이름: %s", "홍길동");//문자는 s
    System.out.printf("\n나이: %d", 20); //숫자는 d

    System.out.printf("\n이름(나이): %s(%d)", "홍길동", 20); 
    
    //정수 삽입 
    // %d : decimal
    // %x ; Hexadecimal
    // %c : character
    System.out.printf("\n %d, %x, %c", 65, 65, 65); //

    // 삽입될 값 지정하기 
    //-> %값 위치 %d
    System.out.printf("\n %1$d, %1$x, %1$c", 65); 

    System.out.printf("\n 재직자: %s, %b", true, true); 
    System.out.printf("\n 나이: %s, %d", 20, 20); // %s는 다 된다

    // 출력할 공간 확보
    System.out.printf("\n 이름: [%s]", "홍길동");
    System.out.printf("\n 이름: [%10s]", "홍길동");
    System.out.printf("\n 이름: [%20s]", "홍길동"); // 오른쪽 정렬
    System.out.printf("\n 이름: [%-20s]", "홍길동"); //왼쪽 정렬
    
    System.out.printf("\n 이름: [%d]", 12345);
    System.out.printf("\n 이름: [%10d]", 12345);
    System.out.printf("\n 이름: [%20d]", 12345);
    System.out.printf("\n 이름: [%-20d]", 12345);
    System.out.printf("\n 이름: [%020d]", 12345);//빈자리 0으로 채워짐
    System.out.printf("\n 이름: [%+010d],[%+010d]", 12345, -12345);

    // 일시 다루기 
    java.util.Date today = new java.util.Date();
    today.setDate(9);
    
    System.out.printf("\n%s", today);

    // 날짜 객체에서 년, 월, 일 , 시, 분, 초 , 요일 추출하기

    System.out.printf("\n %tY", today);//대문자 4자리, 소문자 2자리
    System.out.printf("\n %ty", today);
    System.out.printf("\n %tB, %tb", today, today);//월
    System.out.printf("\n %tm", today);//월
    System.out.printf("\n %td, %te", today, today);//일
    System.out.printf("\n %tA, %ta", today, today);//요일
    System.out.printf("\n %tH %tI", today, today);//시각
    System.out.printf("\n %tM", today);//분 
    System.out.printf("\n %tS, %tL, %tN ", today,today,today);//초 밀리초, 나노초
    System.out.printf("\n %tp, %Tp", today,today);

    // 2019-12-12 12:37:45
    System.out.printf("\n %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", today); //all %1이다

    String str;
    str = String.format("\n %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", today); //리런한다
    System.out.println(str);

  }
}