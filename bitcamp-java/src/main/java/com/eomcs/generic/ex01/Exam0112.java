// 제네릭(Generic) - 사용 전  : 다형적 변수 활용 문제점
package com.eomcs.generic.ex01;

public class Exam0112 {
  static  class ObjectBox {
    Object value;


    public void set (Object value) {
      this.value = value ;
    }

    public Object get() {
      return value;
    }
  }
 

  public static void main(String[] args) {
    
    
    ObjectBox box1= new ObjectBox();
    
    box1.set(new Member("홍길동",20)); //값을 저장
    box1.set(new String("Hello"));
    
    // set의 파라미터가 object이기 때문에 모든 객체를 받을 수 있다 
    // 원래의 목적과 다르게 String 객체를 넣어도 실행
    // 다양한 객체를 보관할 수 있지만, 특정 타입의 객체로 제한 할 수 없다 
    // 이런 object의 단점을 극복하기 위해서 '제네릭(Generic)' 사용
    //
    // 제네릭(Generic)
    // 지정한 한 개의 클래스로 다양한 타입의 객체를 제한적으로 다룰 수 있다.
    // 각 타입 별로 따로 클래스를 정의한 효과가 있다
    //
    Member m= (Member) box1.get(); // 값을 꺼낼 때 형변환해야 한다
    System.out.println(m);

    ObjectBox box2= new ObjectBox();
    box2.set(new String("Hello"));
    String str= (String)box2.get(); // 값을 꺼낼 때 형변환
    System.out.println(str);

    ObjectBox box3= new ObjectBox();
    box3.set(100);
    int i = (int) box3.get(); // 값을 꺼낼때 원시로 지정하면 자동으로 언박싱
    System.out.println(i);
    
    // 값을 꺼낼 때 원래의 타입을 바꾸기 워해 형변환이 필요하다
    // 의도와 다른 타입의 값을 저장하는 것이 있을 수 있다 (Object 단점)
    

  }
}

