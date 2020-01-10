// 제네릭(Generic) - 문법 정리  - 제네릭 객체의 메서드 사용
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0230 {
  public static void main(String[] args) {
    
     ArrayList<Object> list1; 
     list1 = new ArrayList<Object>();
     
     // add (Object)
     // add 이때 오브젝트만 받을 수 있다는 것이 아니다 
     list1.add(new Object());
     list1.add(new String());
     list1.add(new Integer(100));
     list1.add(new Member("홍길동",20));
     
     // Object get(int) 
     Object obj = list1.get(0);
     String str = (String) list1.get(1);
     Integer i = (Integer) list1.get(2);
     Member m  = (Member) list1.get(3);
     // 하지만 오브젝트 타입이 아니라서 타입일때는 형변환을 해야 한다 
     
     System.out.println("종료");
     
  }
}








