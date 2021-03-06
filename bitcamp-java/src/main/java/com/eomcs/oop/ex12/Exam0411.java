// 람다(lambda) 문법
package com.eomcs.oop.ex12;

public class Exam0411 {

  static interface Interest {
    double compute(int money);
  }

  static Interest getInterest(final double rate) {
    // 로컬 클래스
    class MyInterest implements Interest {

      // double rate;

      // public MyInterest(double rate) {
      // this.rate = rate;
      // }

      // 로컬 (or 익명 로컬) 클래스 안에서 바깥 메서드의 로컬 변수(rate)를 사용하면
      // 컴파일러는 자동으로 그 값을 보관하기 위해 필드를 추가한다
      // 또한 그 값을 받을 수 있도록 생성자를 변경한다
      // 따라서 개발자가 직접 필드나 생성자를 정의할 필요가 없다
      @Override
      public double compute(int money) {
        return money + (money * rate / 100);
      }
    }
    return new MyInterest();
    // 생성자 리턴 값도 동일하게 필드를 설정할 필요가 없다
  }

  public static void main(String[] args) {
    Interest i1 = getInterest(1.5);
    System.out.printf("합계 : %.1f\n", i1.compute(10_0000_0000));

    Interest i2 = getInterest(2.5);
    System.out.printf("합계 : %.1f\n", i2.compute(10_0000_0000));
  }
}


