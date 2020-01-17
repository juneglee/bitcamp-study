// non - static nested class = inner class

package com.eomcs.oop.ex11.a;

// 같은 이름의 변수가 있을 때 주의사항
public class Exam0211 {

  int iValue;
  void im() {}

  class A {
    
    int iValue;
    
    void m1() {
      
      // 메서드 내부에서 바깥과 nest인 내부에 동일한 이름의 변수를 지정했을 때
      // 가까운 것 우선으로 (안쪽이 우선으로) 지정한다
      iValue = 100; // A클래스 iValue
      this. iValue = 100; // A클래스 iValue
      
      // 그래서 바깥 클래스의 변수를 사용하고 싶다면 바깥 클래스.this을 사용하여 
      // 바깥클래스의 인스턴스 멤버를 사용한다
      Exam0211.this.iValue = 100; 
      Exam0211.this.im(); 
      
      // inner 가 바깥 인스턴스 멤버를 사용할 수 있는 이유
      // => inner는 바깥의 인스턴스가 존재해야, inner가 실행될 수 있다.
      // => 그래서 inner는 바깥의 인스턴스를 알고 있기 때문에 inner에서 바깥을 사용할 수 있다
    }
  }
  public static void main(String[] args) {
  }

}
