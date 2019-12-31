// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

public class Exam0113 {

  public static void main(String[] args) throws Exception {
    
    System.out.println(System.getProperties());
    // UTF-8 문자 코드의 바이트 배열을 사용하여 String 인스턴스 초기화 시키기
    
    byte[] bytes = {
        (byte)0x41,//A
        (byte)0x42,//B
        (byte)0x43,//C
        (byte)0x61,//a
        (byte)0x62,//b
        (byte)0x63,//c
        (byte)0x30,//0
        (byte)0x31,//1
        (byte)0x32,//2
        (byte)0x20,//space
        (byte)0x21,// !
        (byte)0x23,//#
        (byte)0x25,//%
        (byte)0x2b,//+
        (byte)0x20,//space
        (byte)0xea, (byte)0xb0, (byte)0x80, //가
        (byte)0xea, (byte)0xb0, (byte)0x81, //각
        (byte)0xeb, (byte)0x98, (byte)0x98, //똘
        (byte)0xeb, (byte)0x98, (byte)0xa5, //똥
    };
    String s1 = new String(bytes);
    System.out.println(s1);
    // 생성자에 바이트 배열을 넘길 때 
    // 바이트 배열에 들어 있는 데이터의 문자 코드 표를 알려주지 않으면,
    // String 생성자는 OS의 기본 문자 코드표로 간주하여 변환한다
    // 따라서 위 예제를 리눅스, 유닉스, 맥의 
    // CLI(command line Interface: 콘솔창/명령창) 에서 실행하면
    // 정상적으로 한글 문자열이 출력되지만, 윈도우에서 실행하면 한글 문자열이 깨진다
    // 이유 ?
    // 리눅스, 유닉스, 맥OS 기본으로 사용하는 문자 코드표는 UTF8
    // 윈도우가 기본으로 사용하는 문자 코드표는 MS949이다
    //
    // 그런데 이클립스에서는 꺠지지 않는 이유
    // jVM을 실행할 때 입출력 기본 인코딩을 UTF8로 설정한다 
    //
    // 윈도우 CLI에서 깨지지 않는 방법
    // JVM실행 옵션에 다음을 추가하라 
    //   - Dfile.encoding=UTF-8로 실행한다
    // => java - Dfile.encoding=UTF-8 -cp bin/main com....Exam0113
    //    powershell이 아닌 명령창에서 실행 (- Dfile.encoding=UTF-8을 제대로 인식하지 못한다)
    //    
  }
}
















