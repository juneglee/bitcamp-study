package com.eomcs.basic.ex03;

//메모리 크기와 유효 값이 범위

public class Exam23 {
  //리터럴 : 4바이트(기본,32비트), 8바이트 (L or l, 64비트)
  public static void main(String[] args) {

    System.out.println(100); //jvm에서 4바이트 메모리에 저장
    System.out.println(100L); //jvm에서 8바이트 메모리에 저장 (같은 100이지만 8바이트 메모리에 저장되는 것을 기억)

    System.out.println(-2147483648); // -2^31 :4바이트 최소 음수값
    System.out.println(2147483647); // 2^31-1 :4바이트 표현 최대 양수값

    //System.out.println(-2147483649); // 메모리 초과
    //System.out.println(2147483648);

    System.out.println(2147483648d);
    System.out.println(-9223372036854775808L); //L,l을 붙인다
    System.out.println(9223372036854775807L); 
    
    // 64비트를 초과하면 별도의 도구를 사용해야 한다
    System.out.println(Integer.MAX_VALUE); //4바이트 최대 정수값 출력
    System.out.println(Integer.MIN_VALUE); //4바이트 최소 정수값 
    System.out.println(Long.MAX_VALUE); // 8바이트 최대 정수값
    System.out.println(Long.MIN_VALUE); // 8바이트 최소 정수값
    }
}