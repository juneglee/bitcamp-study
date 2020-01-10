// 제네릭(Generic) - 사용 전  : 다형적 변수의 한계 극복
package com.eomcs.generic.ex01;

public class Exam0113 {
 
  // 객체 타입을 파라미터로 받는다
  static  class Box <T> {
    // T변수 = "타입 파라미터" - 클래스의 객체 타입 
    // (ex> element, obj, datatype)
    // element = E, type = T, key = K,  
    // number = N, value = v , s= 2번째  U =3번째  v=4번째 파라미터
    // ex) class Box <T, S, U, V> 
    T value;

    public void set (T value) {
      this.value = value ;
    }

    public T get() {
      return value;
    }
  }
 

  public static void main(String[] args) {
    
    Box<Member> box1;
    
    // 인스턴스를 생성 할 때도 지정, 객체를 생성할 때 타입 지정 생략 가능
    box1 = new Box<>();
    
    box1 = new Box(); 
    // 지정하는 것을 생략하면, 내부적으로는 Object를 타입으로 지정한 것으로 다룬다
    // box1 = new Box<Object>(); 와 같다
    
    box1.set(new Member("홍길동",20)); //값을 저장
    // box1.set(new String("Hello"));
    Member m= box1.get(); 
    System.out.println(m);

    Box<String> box2= new Box<>();
    box2.set(new String("Hello"));
    String str= (String)box2.get(); 
    System.out.println(str);

    Box<Integer> box3= new Box<>();
    box3.set(100);
    int i = box3.get(); 
    System.out.println(i);
    

  }
}

