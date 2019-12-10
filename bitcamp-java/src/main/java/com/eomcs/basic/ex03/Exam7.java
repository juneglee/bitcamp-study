package com.eomcs.basic.ex03;
//이스케이프 문자 (escape character)
//- 문자를 제어하는 기능을 가진 문자
public class Exam7 {
  public static void main(String[] args){
    //- 문법
    // \[ n | r | f | t | b | ' | " | \ ]  
    // 대소문자를 구분
    System.out.println("hello, world!");
    System.out.println("hello, \nworld!"); // 줄바꿈 문자
    System.out.println("hello, \rwabc"); // 커서(cursor: 문자를 출력할 위치를 가르키는 것)를 처음으로 돌리는 문자
    System.out.println("hello, \b\b\bworld!"); // 커서를 뒤로 한 칸 이동시키는 문자
    System.out.println("hello, \tworld!"); // 탭 공간을 추가시키는 문자
    System.out.println("hello, \fworld!"); // formfeed 추가시키는 문자
    System.out.println("hello, \"w\"orld!"); // " 문자를 추가
    System.out.println("hello, 'w'orld!"); //'안에서는 문자를 그냥 쓴다
    System.out.println("hello, \"w\"orld!"); // ''안에는 그냥 적는다
    System.out.println('\''); // ''안에는 그냥 적는다
    System.out.println('"'); // ''안에는 그냥 적는다
    System.out.println("C:\\users\\user\\git"); // \ 문자를 출력시키는 문자

  }
}

//줄바꿈 코드
// carrage return (CR) : 0d
// Line Feed(LF) : 0a
//
// - windows OS 에서는 줄바꿈을 표시하기 위해 
//   CRLF 2바이트 코드를 삽입한다
// - Unix OS에서는 줄바꿈을 표시하기 위해 
//   LF  1바이트 코드를 삽입한다.