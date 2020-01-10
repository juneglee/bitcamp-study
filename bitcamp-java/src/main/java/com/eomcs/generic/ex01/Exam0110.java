// 제네릭(Generic) - 사용 전 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0110 {
  static  class MemberBox {
    Member value;


    public void set (Member value) {
      this.value = value ;
    }

    public Member get() {
      return value;
    }
  }
  static  class StringBox {
    String value;


    public void set (String value) {
      this.value = value ;
    }

    public String get() {
      return value;
    }
  }

  static  class IntegerBox {
    Integer value;


    public void set (Integer value) {
      this.value = value;
    }

    public Integer get() {
      return value;
    }
  }

  public static void main(String[] args) {
    MemberBox box1= new MemberBox();
    box1.set(new Member("홍길동",20));
    Member m= box1.get();
    System.out.println(m);

    StringBox box2= new StringBox();
    box2.set(new String("Hello"));
    String str= box2.get();
    System.out.println(str);

    IntegerBox box3= new IntegerBox();
    box3.set(100);
    int i = box3.get();// auto-unboxing - box3.get().intValue()
    System.out.println(i);

    // 갹체를 저장하려면 각 객체의 타입 별로 box 클래스를 생성해야 한다 
    // 같은 클래스임에도 다루는 객체의 타입이 달라서 타입별로 만들어야할 box가 무한정으로 늘어나게 된다
    //
    // 해결책 
    // - 다양한 객체 저장할 수 있도록 다형성의 다형적 변수 특징을 이용하여 값을 저장하는 인스턴스 변수를 Object 타입으로 정의 
    //   

  }
}

