package com.eomcs.basic.ex04;

// 형변환 : 부동소수점 변수 ==> 정수 변수
public class Exam81 {
  public static void main(String[] args/* 로컬변수(파라미터)*/){
    byte b = 100;
    short s = 200;
    int i = 18_3456_6789;
    long l = 344_9876_9998_7654_3219L;//컴파일 되어도 조심해야 한다
    // 메모리 크기에 상관없이 정수 변수의 값을 부동소수점 변수에 넣을 때
    // 컴파일 오류가 발생하지 않는다 
    // 단 실행할 때 유효자릿수가 넘어가면 값이 짤릴 수 있다.
   
    float f;
    f = b;
    System.out.println(f); // 100.0
    f = s;
    System.out.println(f); // 200.0
    f = i;
    System.out.println(f); // 1.83456678E9
    f = l;
    System.out.println(f); // 3.44987689E18
    
    double d;
    d = b;
    System.out.println(d); // 100.0
    d = s;
    System.out.println(d); // 200.0
    d = i;
    System.out.println(d); // 1.834566789E9
    d = l;
    System.out.println(d); // 3.449876999876543E18
    
  }
}