// 활용 - 지정한 폴더를 삭제하라
// 디렉토리 안쪽부터 시작하여 반복하여 삭제
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0721 {


  public static void main(String[] args) throws Exception {

    File dir = new File("temp");

    deleteFile(dir);
    System.out.println("삭제하였습니다!");
  }

  static void deleteFile(File dir) {
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File file : files) {
        deleteFile(file);
      }
    }
    dir.delete();
  }
}


