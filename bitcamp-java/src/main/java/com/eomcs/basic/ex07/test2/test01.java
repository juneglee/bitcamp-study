package com.eomcs.basic.ex07.test2;

// 메서드 4가지 형식 
public class test01 {
  public static void main(String[] args) {

    //입력 값 : x , 리턴 값 : x
    m1();

    //입력 값 : ㅇ , 리턴 값 : x
    m2("홍길동");

    //입력 값 : x , 리턴 값 : o
    String s;
    s = m3();
    System.out.println(s);

    //입력 값 : o , 리턴 값 : o
    String s2 = m4("sk");
    System.out.println(s2);

  }
  static void m1() {
    System.out.println("Hello!");
  }
  static void m2(String name) {
    // 함수 안에 선언된 변수를 "로컬 (local)변수"라 부른다
    // 로컬 변수 중에서 함수(메서드)가 호출될 때 넘어 온 값을 받는 변수를 파라미터라 부른다.
    // 함수를 호출 할 때 넘겨주는 값을 아규먼트(argument)라 부른다
    // 
    System.out.println("Hello," + name);
  }
  static String m3() {
    String message = "hello!";
    return message; //return 값을 구분해야 한다
    // 값은 only 하나만 리턴하며, 여러개를 리턴받고 싶으면 클래스로 지정해야 한다
  }
  static String m4(String name) {
    String message = name + " 님 안녕하세요"; 
    return message; 
  }
  
}
