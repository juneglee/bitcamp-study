// stateful 방식의 이점 활용 - 계산기 서버 만들기 II
package com.eomcs.net.ex04.stataful2;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      Socket socket = ss.accept();
      // stateful 을 사용할 때 이점:
      // 연결되어 있는 동안 클라이언트의 작업 결과를 계속 유지 할 수 있다
      try {
        processRequest(socket);
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
        System.out.println("다음 클라이언트의 요청을 처리합니다.");
      }
    }
    // ss.close();
  }

  static void processRequest(Socket socket) throws Exception {
    try (Socket socket2 = socket; // 오토 클로즈를 하기 위해서 따로 저장한다
        DataInputStream in = new DataInputStream(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());) {

      // 게산 결과값을 저장하고 유지할 수 있는 변수
      int result = 0;

      loop: while (true) { // while을 나가기 위해서 loop를 사용
        String op = in.readUTF();
        int a = in.readInt();

        switch (op) {
          case "+":
            result += a;
            break;
          case "-":
            result -= a;
            break;
          case "*":
            result *= a;
            break;
          case "/":
            result /= a;
            break;
          case "quit":
            break loop;
        }

        out.printf("계산결과 : %d\n", result);
      }
      out.println("quit");
    }
  }
}


