package com.eomcs.basic.ex04;

// 형변환 : 형변환 규칙
public class Exam93 {
  public static void main(String[] args){
    byte b = 100;
    short s = 32767;
    int i = 21_0000_0000;
    long l = 922_0000_0000_0000_0000L;
    float f = 3.14f;
    double d =3.14;
    
    // 1) 정수 메모리끼리 형변환 가능
    //==> 작은 메모리의 값을 큰 메모리에 넣을 때는 따로 형변활 필요가 없다.
    l = i;
    i = s;
    s = b;
    // => 큰 메모리의 값을 작은 메모리에 넣을 때는 :명시적 형변환:을 수행해야 한다
    i = (int) l;
    s = (short) i;
    b = (byte) s;//값이 짤
    // 2) 부동소수점을 정수 메모리에 저장 가능
    // => 명시적 형병환 필요, 앞에 예제 참조
    // 3) 정수를 부동소수점 메모리에 저장 가능, 명시적 형변환 필요 없다.
    // => 앞에 예제 참조
    // 4) 숫자를 문자 변수에 저장 가능
     i = 65;
     char c = (char) i;
     System.out.println(c);
     // 그 외 형변환 불가
     boolean bool;
     //bool = b;// 컴파일 오류
     
     //bool = "true";
     //bool = (boolean) 1; // 컴파일 오류!
     
     // 예) 문자열 ==/==> 정수, 부동소수점, 문자, boolean
     //boolean v1 = (boolean) "true"; // 컴파일 오류!
     //char v2 = (char) "가"; // 컴파일 오류!
     //int v3 = (int) "123"; // 컴파일 오류!
     //float v4 = (int) "3.14f"; // 컴파일 오류!
     
     
  }
}