package com.eomcs.oop.test;

// gym 회원 정보를 입력 받아 출력
public class test03 {
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
    //Member m1;
    //m1.no = 100;

    // m1은 메모리를 주소를 저장하는 변수이다
    // 주소를 저장하지 않고 사용할 수 없다

    int i;
    // 자바 원시 데이터 타입은 그냥 변수를 선언하는 순간 메모리도 준비된다
    // 변수가 곧 메모리이다.

    // 그러나 레퍼런스가 메모리에 주소를 담는 변수이다. 
    // 레퍼런스를 선언헀다고 해서 해당 설계도에 메모리가 준비되는 것 아니다.

    //m1.no = 100;
    // m1를 사용하기 위해서 메모리(인스턴스)를 생성한 다음 메모리의 주소를 할당해야 한다
    Member m1 = new Member();
    // 이처럼 new를 만들어 연속적으로 객체를 생성시키고 m1이라는 주소시작을 할당한다 
    // 배열과 동일하게 생성되지만 연속적으로 할당되게 된다는점에서 차이가 있다.
    
    m1.no = 100; //ok!
    //m1 = new String(); //오류
    //m1 = new Date(); //오류
  }
}
