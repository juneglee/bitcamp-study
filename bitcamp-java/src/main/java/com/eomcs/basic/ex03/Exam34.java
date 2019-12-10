package com.eomcs.basic.ex03;

// 부동소수점 리터럴  - 부동소수점을 메모리에 저장하기

public class Exam34 {
  public static void main(String[] args) {
        
        // 4바이트 유효자릿수 : 7
        System.out.println(3.141592f); //ok
        System.out.println(3141.592f); //ok
        System.out.println(31415.92f); //ok
        System.out.println(314159.2f); //ok
        System.out.println(314159.26f); // 값이 구겨진다
        System.out.println(3.1415926535F); // 값이 구겨진다
        System.out.println(3.141592653f); // 값이 구겨진다
        System.out.println(3.14159265f); // 값이 구겨진다
        System.out.println(3.1415926f); // 값이 구겨진다

        // 8바이트 유효자릿수 : 15
        System.out.println(3.141592653511111); 
        System.out.println(31415926.53511111); 
        System.out.println(314159265351111.3);
        // 16자리인 경우
        System.out.println(914159265351111.3); // 값이 구겨진다
        System.out.println(9.141592653511113);
        System.out.println(91415926.53511113);
        // 15자리인 경우
        System.out.println(91415926535111.9); // 값이 구겨진다
        System.out.println(9.14159265351119);
        System.out.println(91415926.5351119);
        // 16자리 인 경우 일부 부동소수점 값이 구겨질 가능성이 있다
        // 하지만 15자리 경우 부동소수점 값이 제대로 저장된다

        System.out.println((1.1f + 0.2f) == 1.3f); // false 
        //부동소수점의 비교는 공식이 따로 있다?

        // 부동소수점 저장할 때 완벽하게 저장되지 않는 경우
        System.out.println(8*0.1); //유효자릿수가 7자리 이하의 경우 발생 
    }
}