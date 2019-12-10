package com.eomcs.basic.ex03;

// 부동소수점 리터럴  - 최소값과 최대값

public class Exam33 {
  public static void main(String[] args) {
    

        //## 4바이트 부동소수점의 최대값과 최소값 (자바에서 정해놓은 값을 출력한다)
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        
        //## 8바이트 부동소수점의 최대값과 최소값
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        //개발자가 부동소수점의 범위를 계산하기가 쉽지 않다
        // 그래서 2진수 변환 규칙을 참고하여 "유효자릿수" 사용하여 값의 범위를 따진다

        System.out.println(3.1415926535F); // 값이 구겨진다
        System.out.println(3.141592653f); // 값이 구겨진다
        System.out.println(3.14159265f); // 값이 구겨진다
        System.out.println(3.1415926f); // 값이 구겨진다
        System.out.println(3.141592f); //ok
        
        System.out.println(3141.592f); //ok
        System.out.println(31415.92f); //ok
        System.out.println(314159.2f); //ok
        System.out.println(314159.26f); // 값이 구겨진다
        // 4바이트는 소수점에 위치와 상관없이 7자리의 갯수가 중요함 
        // 이때 7자리의 갯수를 "유효자릿수"라고 한다
        
        // 주의 : 7자리라도 구겨질수 있음 (내부의 규칙에 따라 JVM 에 보정해줌) 
            //-- 100% 정확하게 꺼내지 못하는 이유는?
            //-- 부동소수점이 2진수로 변환할때 IEEE 754 규칙에 의해 변경되지 못하는 경우가 았음

        System.out.println((1.1f + 0.2f) == 1.3f); // false 부동소수점의 비교는 공식이 따로 있다?
      
    }
}