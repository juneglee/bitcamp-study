// Object 클래스의 메서드를 오버라이딩 하기 - equals()
package com.eomcs.oop.ex06.d;

public class Exam0310 {

  static class Member /*extends Object */{
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  public static void main(String[] args) {
    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("홍길동", 20);
    System.out.println(m1 == m2);  

    // equals()
    // 이 메서드 object에 정의된 메서드이기 때문에, 
    // 따라서 자바의  모든 클래스는 이 메서드를 사용가능하다 
    // 두개의 인스턴스가 같은 인스턴스인지 비교한다
    // == 연산자와 동일하게 동작한다 
    System.out.println(m1.equals(m2));
    System.out.println("--------------------------");

    String s1 = new String("hello");
    String s2 = new String("hello");
    System.out.println(m1 == m2);  

    System.out.println(s1.equals(s2));
  
    // 그런데 위의 실행 결과를 보면 m1과 m2가 비록 인스턴스는 다르지만 true를 리턴
    
    // 이유?
    // String 클래스에서 object에서  toString()을 오버라이딩 했기 때문
    // 그래서 String에 대해 equals()를 호출하면 member와 달리 true를 리턴
    
    // member에 대해서도 true를 리턴되도록 하고 싶으면  String에 대해 toString()을 오버라이딩 하면된다
    
    
  }
}








