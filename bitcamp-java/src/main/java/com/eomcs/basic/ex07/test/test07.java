package com.eomcs.basic.ex07.test;

// gym 회원 정보를 입력 받아 출력
public class test07 {
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
    
    m1 = new Member();
    m1.no =200;
    
    m1 = m2;
    
    System.out.println(m1.no);
    System.out.println(m2.no);
    // 이제 m2 도 m1과 같은 값을 가지게 되며, 
    // 이전의 m1과 m2에서 지정했던 주소는 사용하지 못하게 되었으며, 이를 Garbage라 한다.
  }
}
