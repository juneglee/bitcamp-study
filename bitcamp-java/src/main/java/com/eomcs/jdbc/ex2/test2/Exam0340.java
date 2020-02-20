// 게시판 관리 - 변경 + PreparedStatement 적용
package com.eomcs.jdbc.ex2.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam0340 {

  public static void main(String[] args) throws Exception {

    String no = null;
    String title = null;
    String contents = null;
    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("번호? ");
      no = keyScan.nextLine();

      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.print("내용? ");
      contents = keyScan.nextLine();
    }

    try (Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement("")) {

    }
  }
}


