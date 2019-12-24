package com.eomcs.oop.test;

// gym 회원 정보를 입력 받아 출력
public class test12 {
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
   //레퍼런스 배열
    // 배열 주소를 저장할 변수 선언
    // 배열의 주소를 저장하는 변수도 레퍼런스라 부른다

    Member[] arr1; 
    // 레퍼런스 배열을 선언한다
    // 즉 레퍼런스 배열을 다음과 같단
    // 즉 m1.m2.m3.m4.m5개 생성되는 것과 같다
    arr1 = new Member[5]; // 인스턴스를 생성한 후, 주소를 반드시 저장해야 한다
    
    //인스턴스를 300개 만들 것이다
    //레퍼런스를 300개 준비하라!
    
    // 각각을 변수를 만드는 일반적인 방식으로 레퍼런스를 선언하면 너무 길어져서 코딩할 수 없다.
    // 이런 상황에서 배열을 사용하면 쉽게 해결할 수 있다
    // 즉 배열을 이용하면 많은 레퍼런스 변수를 손쉽게 만들 수 있다
    
    
    Member[] arr;
    arr = new Member[3000];
    // Member 인스턴스 주소를 담을 레퍼런스 변수를 3000개 만들어진다.
    // Member 인스턴스 3000개 만드는 것이 아니다.
    // 배열을 이용해서 인스턴스를 3000개 만드는 방법은 ? 없음
    
    // arr[0].no = 100 ; // runtime(실행) 오류 
    
    int count = 0;
    while (count < 3000) {
      arr[count] = new Member();
      count++;
    }
    // 위의 반복문을 이용해서 인스턴스를 생성해야 한다.
    
  }
}
