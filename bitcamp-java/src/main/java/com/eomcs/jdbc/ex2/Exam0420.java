// insert 한 후 auto increment PK 값 사용 하기
// table과 table이 연결되어있을때 PK의 키를 이용하여 연결하여야 하는데
// 이때 PK으로 지정된 no가 auto로 설정되어 있기 때문에 no을 알아야 한다

package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam0420 {

  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;
    String[] filenames = new String[3];

    try (Scanner keyScan = new Scanner(System.in)) {

      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.print("내용? ");
      contents = keyScan.nextLine();

      System.out.print("파일1? ");
      filenames[0] = keyScan.nextLine();

      System.out.print("파일2? ");
      filenames[1] = keyScan.nextLine();

      System.out.print("파일3? ");
      filenames[2] = keyScan.nextLine();

      System.out.print("입력하시겠습니까?(Y/n) ");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소 하였습니다.");
        return;
      }
    }

    try (Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");

        PreparedStatement stmt = con.prepareStatement( //
            "insert into x_board(title,contents) values(?,?)", //
            Statement.RETURN_GENERATED_KEYS);) {

      stmt.setString(1, title);
      stmt.setString(2, contents);
      int count = stmt.executeUpdate();
      System.out.printf("%d 개 입력 성공!\n", count);

      try (ResultSet rs = stmt.getGeneratedKeys()) {
        rs.next();
        int no = rs.getInt(1);
        System.out.printf("입력된 게시글 번호: %d\n", no);

        for (int i = 0; i < filenames.length; i++) {
          if (filenames[i].length() == 0) // 문자열이 없다면 아래를 실행하지말고 위로 올라가라
            continue;
          try (PreparedStatement stmt2 =
              con.prepareStatement("insert into x_board_file(file_path,board_id) value(?,?)")) {
            stmt2.setString(1, filenames[i]);
            stmt2.setInt(2, no);
            stmt2.executeUpdate();
          }
        }
      }
    }
  }
}


