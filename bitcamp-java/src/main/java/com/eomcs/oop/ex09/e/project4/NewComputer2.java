package com.eomcs.oop.ex09.e.project4;

import com.eomcs.oop.ex09.e.Computer;
// 기존 규칙을 상속 받아서 새 규칙을 만들면, 규칙이 늘어나면서 관리가 어려워짐
// 또한 인터페이스에 새 규칙을 추가하게 되면, 기존에 구현한 클래슨 모두 오류가 발생할 것이다 
// why? 규칙이 달라졌기 떄문에 클래스 구현 오류가 발생하는 것이다.
//      클래슨느 항상 인터페이스의 모든 메서드를 구현해야 하기 때문이다

public class NewComputer2 implements Computer {

  // 기존 규칙을 구현하고
  public void compute() {
    System.out.println("새 컴퓨터..");
  }
  // 새로 추가한 규칙도 구현한다
  public void touch() {
    System.out.println("오호라.. 터치가 되네. 이거 서피스 프로인가?");
  }

}






