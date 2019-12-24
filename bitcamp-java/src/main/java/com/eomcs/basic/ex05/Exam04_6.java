// 비트 이동 연산자 : 응용 III
package com.eomcs.basic.ex05;

public class Exam04_6 {
  public static void main(String[] args) {
    // 다음 변수의 값을 조사하여 개발자가 
    // 어떤 프로그래밍 언어를 사용할 수 있는 지 출력하라!
    // => 각 비트의 해당하는 프로그래밍 언어는 다음 순서를 따른다.
    //    c, cpp, java, js, python, php, html, css
    //    
    // lang 변수에 들어 있는 각 비트 값을 조사하여 
    // 1이면 그 변수에 해당하는 프로그래밍 이름을 출력한다.
    // => if 조건문, &, == 연산자를 활용하라!
    // => 실행 결과
    // c cpp java html css
    // 
    // => 공식 
    //    (값이 들어 있는 변수) & (특정 언어를 표현한 비트 값) 
    //     => & 연산의 결과와 (특정 언어를 표한한 비트 값)이 같은지 비교한다.


    int lang = 0b1110_0011;


    if ((lang & 0x80) == 0x80) System.out.print("c ");
    //  11100011
    // &10000000
    //----------
    //  10000000 (& 를 연산하여 특정 비트(C)를 추출한다 )

    if ((lang & 0x40) == 0x40) System.out.print("cpp ");
    //  11100011
    // &01000000
    //----------
    //  01000000 (& 를 연산하여 특정 비트(C++)를 추출한다 )
    if ((lang & 0x20) == 0x20) System.out.print("java ");
    if ((lang & 0x10) == 0x10) System.out.print("js ");
    //  11100011
    // &00010000
    //----------
    //  00000000 (& 를 연산하여 특정 비트(JS)를 추출이 안되기 때문에 특정 언어를 사용하지 못한다 )
    if ((lang & 8) == 8) System.out.print("python ");
    if ((lang & 4) == 4) System.out.print("php ");
    if ((lang & 2) == 2) System.out.print("html ");
    if ((lang & 1) == 1) System.out.print("css ");
    System.out.println(); // 줄바꿈 
    //c cpp java html css


  }
}
