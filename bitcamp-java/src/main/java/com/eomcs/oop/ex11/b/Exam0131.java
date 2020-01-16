package com.eomcs.oop.ex11.b;

import java.io.File;
import java.io.FilenameFilter;

public class Exam0131 {

  class JavaFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
      if (name.endsWith(".java")) 
        return true; 
      return false; 
    }
  }

  public static void main(String[] args) throws Exception { //스태틱
    File dir = new File(".");
    JavaFilter javaFilter; 

    // javaFilter = new JavaFilter(); // 인스턴스 멤버

    // 스태틱은 인스턴스 멤버를 사용할 수 없다 
    Exam0131 obj = new Exam0131();
    // 스태틱 메서드에서 인스턴스를 사용할려면 
    // 스태틱의 인스턴스 멤버를 생성해야 한다 
    javaFilter = obj.new JavaFilter();

    String[] names = dir.list(javaFilter);
    for (String name : names) {
      System.out.println(name);
    }
  }
  
  
}







