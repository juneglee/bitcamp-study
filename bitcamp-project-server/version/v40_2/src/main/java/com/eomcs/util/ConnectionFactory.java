package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import com.eomcs.sql.ConnectionProxy;

public class ConnectionFactory {
  String jdbcUrl;
  String username;
  String password;

  // 스레드에 값을 보관하는 일을 할 도구 준비
  ThreadLocal<Connection> connectionLocal = new ThreadLocal<>();


  public ConnectionFactory(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws Exception {

    // 먼저 스레드에 connection객체가 보관되어 있는지 알아 본다
    Connection con = connectionLocal.get();

    // 보관된게 있다면, 보관된 Connection 객체를 리턴한다
    if (con != null) {
      System.out.println("스레드에 보관된 connection 객체 리턴");
      return con;
    }

    // 보관된게 없다면, 새로 connection 객체를 만들어 리턴한다
    con = new ConnectionProxy(DriverManager.getConnection(//
        jdbcUrl, //
        username, //
        password));
    System.out.println("새 connection 객체 생성하여 리턴");

    // 물론 리턴하기 전에 스레드에 생성된 Connection 객체의 주소를 기록한다
    connectionLocal.set(con);
    // 이때 객체는 Heap에 저장되어 있기 때문에 결국에는 주소를 기록하고 연결하는 것이다

    return con;
  }

  public Connection removeConnection() {
    // 스레드에 보관된 Connection 객체를 제거한다.
    // => 다음 문장을 실행하는 스레드에서 제거한다.
    // => 어느 스레드인지 구분하고 있으니깐 걱정하지 말라!
    Connection con = connectionLocal.get(); // 현재 실행하고 있는 스레드에서 제거하는 것이다
    if (con != null) {
      connectionLocal.remove();
      System.out.println("스레드에 보관된 Connection 객체 제거 헀음");
    }
    return con;
    // 제거는 헀지만 받아서 쓰던지 말던지 리턴값을 사용하여 쓸사람은 쓰도록 만든다
  }
}
