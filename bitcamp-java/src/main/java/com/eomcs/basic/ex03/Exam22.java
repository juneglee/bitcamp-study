package com.eomcs.basic.ex03;

//

public class Exam22 {
  public static void main(String[] args) {
    
    // 금액 표기를 위해 _ 사용 (한국 4자리, 미국 3자리 )
    // 맨앞,뒷자리는 안된다
    System.out.println(2_3500_0000); // 10진수
    System.out.println(2_3500_0000); // 10진수

    System.out.println(0144); // 8진수 (0)
    System.out.println(0_144); // 8진수만 중간에 가능

    System.out.println(0x64); // 16진수 (0x,대문자, 앞에 '0' 가능)
    // System.out.println(0x_64); // 중간 불가능

    System.out.println(0b1100100); // 2진수 (0b,대문자(B), 앞에 '0' 가능)
    // System.out.println(0b_1100100); // 중간 불가능
    
    // 실무에서는 소문자를 사용한다
    }
}