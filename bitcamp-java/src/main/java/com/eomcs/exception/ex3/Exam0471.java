// 던지는 예외 받기 - Throwable.
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0471 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException, Error {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else if (i == 3)
      throw new IOException();
    else if (i < 0)
      throw new Error(); // 시스템 오류
  }

  public static void main(String[] args) {
    try {
      m(-1);

    } catch (Throwable e) {
      System.out.println("애플리케이션 예외 발생");
    }
    // 무심코 Throwable으로 선언하면 Error까지 받으며,
    // JVM에서 발생된 오류에 대해서도 예외 처리를 하는 문제가 발생한다.
    // Error의 시스템 오류는 애플리케이션에 대해서 처리 할 수 없기 때문이다
  }
}
