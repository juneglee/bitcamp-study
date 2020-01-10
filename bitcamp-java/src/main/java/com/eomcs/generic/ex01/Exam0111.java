// 제네릭(Generic) - 사용 전  : 다형적 변수 활용
package com.eomcs.generic.ex01;

public class Exam0111 {
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
    box1.set(new Member("홍길동",20));
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

