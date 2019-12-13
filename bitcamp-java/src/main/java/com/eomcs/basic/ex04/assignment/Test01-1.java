// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//

package com.eomcs.basic.ex04.assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test01 {
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner (System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int = a,b;
    char = op;

    System.out.print("값 1? ");
    a = Integer.parseInt(br.readLine());
    System.out.print("값 2? ");
    b = Integer.parseInt(br.readLine());
    System.out.print("연산자?\n(1 + ,2 - ,3 * ,4 /)");
    int i = keyboard.nextInt();
        
    System.out.print("값1 + 값2 = ");
    i = (char)system.in.read();


    if (i == '+'){
      System.out.println(value1 + value2);
    } else if (i == '-'){
      System.out.println(value1 - value2);
    } else if (i == '*'){
      System.out.println(value1 * value2);
    } else if (i == '/'){
      System.out.println(value1 / value2);
    } else {
      System.out.println("연산이 잘못되었습니다.");
    }
  }
}