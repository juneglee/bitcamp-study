package com.eomcs.oop.ex07.a;
// 캡슐화 문법 사용 후 - 개발자가 특정 필드를 직접 접근하지 못하게 막기 
 
public class Exam0211 {
  public static void main(String[] args) {
    Score2 s1= new Score2();
    s1.name = "홍길동";
    s1.kor =100;
    s1.eng =90;
    s1.math =80;
    s1.compute();
    
    // 캡슐화 문법으로 sum과 aver의 값을 임의적으로 조작하는 것은 막았다
    // 하지만 다른 문제가 발생할 수 있다 
    // 만약 국영수 점수를 변경한 후, compute를 호출하지 않는다면?
    s1.eng = 100;
    s1.math = 100;
    
    // 원래 score2의 개발자 의도대로 사용한다면 
    // 다음과 같이 국영수 점수를 변경한 후 compute를 호출했어야 한다
    // 하지만 compute를 하지 않았기 때문에 문제가 발생
    // 해결책
    // - Exam0310.java를 보라
    s1.compute();

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
        s1.name, s1.kor, s1.eng, s1.math, s1.getSum(), s1.getAver());
  }
}
