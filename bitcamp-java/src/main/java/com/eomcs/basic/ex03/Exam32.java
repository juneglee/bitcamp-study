package com.eomcs.basic.ex03;

// 부동소수점 리터럴  - 메모리 크기

public class Exam32 {
  public static void main(String[] args) {

    // 부동소수점 : 4바이트, 8바이트 (기본)
  
    System.out.println(3.141592653589793); //8바이트 부동소수점 , 뒤에 D(d,double)를 붙여도 되고 안붙여도 된다
    System.out.println(3.141592653589793D);
    System.out.println(3.141592653589793d);

    // 4바이트 부동소수점
    System.out.println(3.141592653589793f);// 주로 소문자를 붙인다
    System.out.println(3.141592653589793F); 

    // 정수값은 큰값을 적은 메모리로 저장할때 에러가 뜨지만.
    // 부동소수점은 큰값을 적은 메모리로 저장할때 에러가 뜨지않고 실행되며, 반올림 한다
    // 개발자가 잘못된 값을 넣었다는 것을 인지하지 못한다.

    }
}