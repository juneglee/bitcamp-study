package com.eomcs.basic.ex04;

import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

public class Exam31 {
  public static void main(String[] args){
    // 부동소수점 변수 - 메모리 크기

    float f;
    f = 3.141592f;
    System.out.println(f);

    f = 3.1415979f;
    System.out.println(f); 

    f = 0.0000003141592f; // 3.141592E-7, 앞에 있는 0은 유효자리수로 취급 안한다
    System.out.println(f); 

    f = 0.00000031415929f; // 3.1415928E-7,  0을 제외하고 7자리 까지 가능하다(8자리에서는 변한다)
    System.out.println(f); 

    f = 3.14159200000f; 
    System.out.println(f);

    double d;
    d = 9.87654321234567;
    System.out.println(d);

    d = 9876543.21234567;
    System.out.println(d);

    d = 98765432123456.7;
    System.out.println(d);

    d = 9.876543212345678;
    System.out.println(d);

    d = 98765432123456.74; // 9.876543212345673E13, 값이 짤림
    System.out.println(d);
    
    // 변수와 리터럴 
    f = 99999.88f;
    System.out.println(f);

    f = 99999.88777f; //이미 리터럴이 4바이트 유효자릿수를 넘어갔다. 이미 컴파일시에 왜곡된 상태
    System.out.println(f);

    d = 99999.88f; //99999.8828125, 8바이트에서 f를 붙인경우 
    System.out.println(d); 

    d = 99999.88;
    System.out.println(d);

    //1. 유효자리숫를 지켜라
    //2. 바이트에 따라 정확히 지켜야 한다 
    
    //flaot f1 = 99988.88f;
    //flaot f2 = 11.11111f;
    double d1 = 99988.88; // float ==> double로 변경한후 뒤의 f를 지워야 한다 
    double d2 = 11.11111; // float ==> double로 변경한후 뒤의 f를 지워야 한다 
    System.out.println(d1); 
    System.out.println(d2);

    //float f3 = f1 + f2;
    //System.out.println(f3); // 4바이트의 유효자릿수가 넘어가게 된다 

    double d3 = d1 + d2; // 주의 float + float = float 이미 결과에서 값이 왜곡된다.
    System.out.println(d3);

    // 부동소수점일때는 거의 double를 사용한다.
    // 몸무게, 키일때는 float를 사용한다.
    // 계산을 하는 것이면 double, 계산이 아니라면 float

    float f1 = 3.141592f;
    d1 = f1; //ok
    System.out.println(d1); //컴파일ok, 단 값은 왜곡될 수 있다.

    // f1 = d1 // 컴파일 오류


  }
}