package com.eomcs.oop.ex08.test;

public class J2 { 
  // student와 teacher의 공통 분모를 뽑아서 수퍼 클래스를 정의
  // Generalization
  //
  class Member {
    String email;
    String pwd;
    String name;
    String tel;

    void print() {
      System.out.println("학생정보");
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

    class Teacher {
      int pay;
      String major;
      void print() {
        System.out.println("학생정보");

      }
    }
  }
}