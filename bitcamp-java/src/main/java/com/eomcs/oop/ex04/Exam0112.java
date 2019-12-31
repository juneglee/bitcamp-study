// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

public class Exam0112 {

  public static void main(String[] args) throws Exception {

    // 한글 문자 코드의 바이트 배열을 가지고 String 인스턴스 초기화시키기
    byte[] bytes = {
        (byte)0xb0, (byte)0xa1, //가
        (byte)0xb0, (byte)0xa2, //각
        (byte)0xb6, (byte)0xca, //똘
        (byte)0xb6, (byte)0xcb  //똥
    };
    String s1 = new String(bytes);
    System.out.println(s1);
    // 결과 : 한글 출력이 꺠진다

    // 이유 ? 
    // String 클래스는 파라미터로 넘겨 받은 바이트 배열에 가지고 
    // 유니코드(UCS-2) 문자열로 변환할 때 바이트 배열이 OS의 기본으로 문자 코드로 있다고 가정한다 
    // OS 마다 기본으로 사용하는 문자 코드 (character set)가 다르다
    // 윈도우 : MS949, 유닉스/리눅스/MAC : UTF8  
    // 위의 예제는 EUC-KR 코드이다. 그래서 바이트 배열을 제대로 해석하지 못한 것이다 
    // 해결책?
    // String 클래스의 생성자를 호출할 때 
    // 바이트 배열과 인코딩 정보를 함께 받는 생성자를 호출하라!
    // => 즉 bytes 배열에 EUC-KR의 코드 값이 들어 있다고 알려준다.
    //    그러면 JVM은 바이트 배열에 들어 있는 값을 제대로 유니코드 바꿀 것이다.
    String s2 = new String(bytes, "EUC-KR");
    System.out.println(s2);
  }
}

// 생성자의 활용
// => 인스턴스 변수를 초기화시키기 위해 여러 개의 생성자를 만들어 제공할 수 있다.
// => 자신에게 맞는 적절한 생성자를 호출하여 인스턴스를 초기화시킨 후 사용하면 된다. 















