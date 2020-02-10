// 서버와 입출력 테스트 - byte Stream : Data 주고 받기
package com.eomcs.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0130 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");
      System.out.print("> ");
      keyScan.nextLine();

      // 서버에 보낼 바이트 배열을 준비한다
      // 0 ~ 99의 값을 가진 배열이다

      byte[] bytes = new byte[100];
      for (int i = 0; i < 100; i++) {
        bytes[i] = (byte) i;
      }

      // 서버에 바이트 배열을 전송한다
      out.writeInt(1567891234);
      // out.flush();
      // byte Stream을 사용할 때 바로 출력한다.
      // 따라서 flush()를 호출하지 않아도 된다
      System.out.println("서버에 데이터를 보냈음!");

      // 서버에서 보낸 int 값을 읽는다
      int value = in.readInt();
      System.out.println(value);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


