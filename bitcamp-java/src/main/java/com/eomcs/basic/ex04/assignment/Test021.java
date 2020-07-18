// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위  (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//
// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.
//
package com.eomcs.basic.ex04.assignment;

import java.util.Scanner; 
import java.util.Random;

public class Test021 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);  
    int com = (int) (Math.random() * 3) + 1; 
    System.out.print("1.가위, 2.바위, 3.보 \n입력: ");
    int my = keyboard.nextInt();  
    
    
    if (my == 1) { 
      // my == 1 가위
    } else if (my == 2) {		
      // my == 2 바위
    } else {
      // 그밖에 보
    }

    System.out.print("컴퓨터: ");
    if (com == 1) {
      System.out.print("가위\n");
    } else if (com == 2) {  
      System.out.print("바위\n");         		
    } else {   	
      System.out.print("보\n");
    }
    

    if (com== my) { 
      System.out.println("비겼습니다.");
	  } else if ((com == 1 && my == 2) || (com == 2 && my == 3) || (com == 3 && my == 1)) {
      System.out.println("이겼습니다.");
    } else {
      System.out.println("졌습니다.");	
    }
    keyboard.close();

    }
  }

