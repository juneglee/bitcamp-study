package com.eomcs.oop.ex08.test;

public class J3 { 
  public void m1() {
    Student s = new Student();
    Teacher t = new Teacher();
    
    // Member m = new Member();
    // 추상 클래스는 인스턴스를 생성할 수 없다 
    // 즉 추상 클래스는 직접 사용할 수 없다 
    // 단지 서브 클래스 공통 분모를 돌려주는 일을 한다 
    
  }
  // 보통 Generalization 통해 정의한 수퍼 클래스는
  // 직법 사용할 일이 없기 때문에 추상 클래스로 정의하여 직접 사용하지 않게 한다 
  abstract class Member {
    String email;
    String pwd;
    String name;
    String tel;

    void print() {
      System.out.println("회원 정보");
    } 
  }

    // 대신 기본 클래스는 수퍼 클래스를 상속 받는다 
    class Student extends Member {
      int grade;
      boolean working;
      @Override
      void print() {
        System.out.println("학생정보");

      }
    }

    class Teacher extends Member {
      int pay;
      String major;
      @Override
      void print() {
        System.out.println("학생정보");

      }
    }
  
}