package com.eomcs.basic.ex07.test;

// gym 회원 정보를 입력 받아 출력
public class test04 {
  public static void main(String[] args) {

    // 회원 정보를 담을 수 있는 메모리의 설계도
    class Member {
      int no;
      String name;
      int birthYear;
      char gender;
      float height;//키, 몸무게는 float, 그외는 double
      float weight;
      boolean personalTrainingt;
    }
    Member m1;
    m1 = new Member();
    m1.no = 100;
    System.out.println(m1);
    //인스턴스에 부여된 고유 번호와 클래스명이 출력된다.
    System.out.println(m1.no);
    
    //레퍼런스의 주소를 없애는 방법
    m1 = null; // 주소가 없다는 의미로 실제 메모리에 0으로 설정된다.
    System.out.println(m1);
    System.out.println(m1.no);//NullPointerException : 주소 없이 썼다는 의미
  }
}
