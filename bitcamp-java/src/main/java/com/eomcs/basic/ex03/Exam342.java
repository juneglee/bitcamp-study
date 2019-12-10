package com.eomcs.basic.ex03;

// 부동소수점 리터럴  - 부동소수점의 리터럴은 기본이 왜 8바이트 인가?

public class Exam342 {
  public static void main(String[] args) {
        System.out.println(54345.66f);
        System.out.println(11.23456f);

        System.out.println(54345.66f + 11.23456f);
        // 계산 결과값이 유효자릿수를 넘는다

        // 실행 결과를 보면 기대 했던 수가 출력되지 않는다.
        // why?
        // 각각의 수는 유효 자릿수이지만, 계산 결과는 유효자릿수를 넘어가기 때문에 값이 구겨진다.
        // 그렇게 때문에 부동소수점은 기본으로 8바이트를 사용한다

        // 해결책
        // => 자바로 프로그래밍할때 부동소수점은 8바이트로 해라 
    }
}