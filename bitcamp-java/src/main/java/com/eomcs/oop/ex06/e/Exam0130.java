// final 사용법 : 오버라이딩 불가
package com.eomcs.oop.ex06.e;

public class Exam0130 {
  // 메서드 final을 붙이면 서브 클래스를 오버라이딩 할 수 없다
  public final void m1() {
    // 오버라이딩은 서브 클래스를 사용하므로
    // 서브 클래스에서 변경하면 안되는 메서드인 경우 사용할 수 없다
    // 예) 보안에 관련된 일을 하는 메섣
    // 예) 탬플릿 메서드 디자인 패턴에서처럼 전체적인 작업 흐름을
    // 정의한 메서드
    // 서브 클래스의 오버라이딩을 막는 것이 좋다
  }

  public void m2() {

  }
}