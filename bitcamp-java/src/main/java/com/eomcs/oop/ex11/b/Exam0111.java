// 클래스의 종류 : 패키지 멤버 클래스 사용
package com.eomcs.oop.ex11.b;

import java.io.File; // <<<<<<<<<<<<<<<<<

// 물론 Exam01_1 또한 패키지 멤버 클래스이다.
public class Exam0111 {

  public static void main(String[] args) throws Exception {
   
    // 현재 폴더에 들어 있는 하위 폴더 및 파일들의 이름을 출력하라 
    // 이클립스의 경우 프로젝트 폴더 이다 
    
    // File 클래스를 이용하여 현재 폴더의 정보를 알아낸다 
    // File 클래스는 OS의 기능을 이용하여 폴더 및 파일 정보를 다루는 일을 한다 
    // File 클래스는 java.io 패키지에 소속된 멤버 클래스이다
    File dir = new File("."); 
    
    JavaFilter javaFilter = new JavaFilter(); 
    
    // java.io 패키지에 소속된 File 클래스를 이용하여 
    // 지정된 위치에 있는 폴더나 파일의 이름을 알아낸다 
    String[] names = dir.list(javaFilter); 
    //.list(javaFilter) list로 정의 되어 있기 때문에 특정 된 파라미터 아니면 넣을 수 없다 
    for (String name : names) {
      System.out.println(name);
    }

  }

}







