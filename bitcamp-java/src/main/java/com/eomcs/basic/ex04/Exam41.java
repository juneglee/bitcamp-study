package com.eomcs.basic.ex04;

public class Exam41 {
  public static void main(String[] args){
  //문자 변수
  short s;
  char c;

  s = -32768;
  s = 32767;

  c = 0;
  c = 65535;

  char c1 = 65;
  char c2 = 0x41;
  char c3 = 0b0100_0001;
  char c4 = 'A'; //char는 문자가 저장되는 것이 아니라 문자에 부여된 숫자값(문자코드(유니코드,ucc-2))를 저장하는 것이다.

  System.out.println(c1);
  System.out.println(c2);
  System.out.println(c3);
  System.out.println(c4);

  int i1 = 'A';
  System.out.println(i1);
  i1 = i1 +10; // i1 값에서 10을 더하는 값을 i1
  System.out.println((char) i1);//형변환 = 타입 캐스팅

  for (int i = 65 /*A값은 65이다 */ ; i < 'A' + 26 /*알파벳 26개 */; i++){
    System.out.print((char) i);
  }
  

  }
}