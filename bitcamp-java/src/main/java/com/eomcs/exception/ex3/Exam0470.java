// 던지는 예외 받기 - Throwable.
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0470 {

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

    } catch (Exception e) {
      System.out.println("애플리케이션 예외 발생");

    } catch (Error e) {
      System.out.println("시스템 예외 발생");
    }
    // 시스템 예외는 당장 프로그램을 정상적으로 실행할 수 없는 상태일때 발생한다
    // 정상적인 복구가 안되는 예외이기 때문에 가능한 Error를 사용하지 마라
    // 따라서 이 예외를 처리하면 시스템을 멈출 수 밖에 없다

  }
}
