package com.eomcs.basic.ex07.test;

// gym 회원 정보를 입력 받아 출력
public class test06 {
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
    Member m2 = m1;
    System.out.println(m1.no);
    
    //기존 레퍼런스에 새 인스턴스의 주소를 저장한다
    //따라서 m1 과 m2는 서로 달느 인스턴스의 주소를 갖고 있따.
    // 즉 m1과 m2가 가리키는 인스턴스가 다르다.
    
    m1 = new Member();
    m1.no =200;
    System.out.println(m1.no);
    System.out.println(m2.no);
  }
}
