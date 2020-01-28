// 예외 처리 후 마무리 작업 - finally 블록
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0520 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else if (i == 3)
      throw new IOException();
  }

  public static void main(String[] args) throws Exception {
    try {
      m(1);
    } finally {
      // try 블록을 나가기 전에 무조건 실행해야 할 작업이 있다면
      // catch 블록이 없어도 finally 블록만 사용할 수 있다.
      System.out.println("정상적인 실행일 때!");
      // 예외가 발생하더라도 final은 실행하고
      // 발생된 예외는 main() 호출자에게 위임한다
      // => 이때 main()에서 위임받은 호줄자는 예외 처리를 어떻게 할지 메서드에 표시해야 한다
    }
  }
}
