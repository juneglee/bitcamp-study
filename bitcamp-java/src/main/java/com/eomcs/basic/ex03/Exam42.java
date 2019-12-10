package com.eomcs.basic.ex03;

// 문자 리터럴 - 문자 코드를 이용하여 문자 출력

public class Exam42 {
  public static void main(String[] args) {
    
    // 코드값을 사용
    //=> 그냥 출력하면 정수를 표현한 것으로 출력 ((char))
    
    System.out.println((char) 0x0041);
    System.out.println((char) 0xac00);
    // JVM이 폰트파일에서 찾아 그 코드에 해당하는 문자 그림을 출력
    for (int i = 0; i < 11172; i++) {
      if (i % 80 ==0)
        System.out.println();
      System.out.print((char)(0xac00+i));
    }
  
  }
}