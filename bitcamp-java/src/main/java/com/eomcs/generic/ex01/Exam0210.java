// 제네릭(Generic) - 문법 정리  - 레퍼런스와 인스턴스 생성
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0210 {
  public static void main(String[] args) {
    
    // 만일 <타입명> 을 생략한다면.
     ArrayList list5; // => ArrayList<?> list5;
     list5 = new ArrayList();
     list5 = new ArrayList<>();     
     list5 = new ArrayList<Object >();
     list5 = new ArrayList<String >();
     list5 = new ArrayList<Member >();
     
     // arrayList가 다루는 타입에 상관없이 ArrayList 레퍼런스를 선언하고 싶다면
     // list 처럼 선언하지 말고 다음과 깉이 <?> 를 명시하라
     ArrayList<?> list2;
     list5 = new ArrayList(); // 이렇게 사용하지 않고 , 명확히 제네릭을 사용하라 
     list5 = new ArrayList<>();
     list5 = new ArrayList<Object >();
     list5 = new ArrayList<String >();
     list5 = new ArrayList<Member >();
     

  }
}








