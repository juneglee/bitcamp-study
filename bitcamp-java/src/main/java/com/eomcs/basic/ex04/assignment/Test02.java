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

import java.util.Random;
import java.util.Scanner;
public class Test02 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in);
    

    System.out.print("가위, 바위, 보?  ");
    String my = keyboard.next();

    int com = (int) (Math.random() * 3) + 1;  


    if (my.equals("가위")){     
    } else if (my.equals("바위")){
    } else if (my.equals("보")){
    } else {
      System.out.println("잘못된 정보값입니다");
    }
    
    System.out.print("컴퓨터: ");
    if (com == 1){
      System.out.println("가위");         
    } else if (com == 2){
      System.out.println("바위");
    } else if (com == 3){
      System.out.println("보");
    }

    if (com == 1 && my.equals("가위") || com == 2 && my.equals("바위") || com == 3 && my.equals("보")){
      System.out.println("=> 비겼습니다.");
    } else if (com == 1 && my.equals("바위") || com == 2 && my.equals("보") || com == 3 && my.equals("가위")) {
      System.out.println("=> 이겼습니다.");
    } else {
      System.out.println("=> 졌습니다.");
    }
    keyboard.close();
  }
}
