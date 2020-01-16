// 클래스의 종류 : non-static 중첩 클래스(nested class) 사용
package com.eomcs.oop.ex11.b;

import java.io.File;
import java.io.FilenameFilter;

public class Exam0130 {

  // non-static nested class = inner class
  // => 스태틱이 붙지 않은 중첩 클래스. 결국 인스턴스 멤버이다.
  // => 이 클래스는 인스턴스가 있어야 만 사용할 수 있다.
  // => 보통 인스턴스 멤버를 사용하는 중첩 클래스를 만들 때 inner class로 정의한다.
  // => 당연히 inner 클래스는 인스턴스 메서드에서 주로 사용할 것이다.
  class JavaFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
      if (name.endsWith(".java")) 
        return true; 
      return false; 
    }
  }

  // static 메서드
  public static void test1() {
    // JavaFilter은 inner class이기 때문에 
    // 인스턴스를 생성할 때 바깥 인스턴스가 필요
    // 안의 static안에서 사용할려고 하면 오류가 발생할 것이다
    JavaFilter javaFilter; // 레퍼런스를 선언할 때는 상관없다 
    //javaFilter = new JavaFilter(); 컴파일 오류
  }

  // 인스턴스 메서드
  public void test() {
    File dir = new File(".");

    // inner class의 인스턴스를 생성한다.
    JavaFilter javaFilter; // 레퍼런스를 생성할 때는 스태틱 또는 인스턴스 모두 가능하다
    javaFilter = new JavaFilter();// this를 써도 되고 생략이 가능하다 

    // inner class의 인스턴스를 필터로 사용하여 디렉토리 안의 목록을 추출한다.
    String[] names = dir.list(javaFilter);
    for (String name : names) {
      System.out.println(name);
    }
  }

  public static void main(String[] args) throws Exception {
    Exam0130 obj = new Exam0130();
    obj.test();
  }

}







