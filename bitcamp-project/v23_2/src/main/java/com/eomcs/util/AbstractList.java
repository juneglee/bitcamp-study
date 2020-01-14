package com.eomcs.util;

// 1) Generalization 1단계
//  => ArrayList와 LinkedList 사이의 공통 분모를 추출하여 수퍼 클래스를 정의 
//  => ArrayList와 LinkedList 이렇게 정의한 수퍼 클래스를 상속 받는다

//2) Generalization 2단계
// 서브 클래스에 공통 분모(멤버)를 물려주는 용도의 클래스는 직접 인스턴스를 생성하지 못하도록 
// 추상 클래스로 선언한다
// 개발자가 추상 클래스 여부를 즉각적으로 확인할 수 있도록 
// 보통 클래스 이름을 AbstractXX형식으로 짓는다

// 추상 
// => 서브 클래스에서 구현할 메서드를 그냥 일반 메서드로 정의하면,(@Override를 사용하지 않았을 때) 
//  서브 클래스를 정의하는 개발자가 해당 메서드를 오버라이딩 한다는 보장을 하지 못한다.
// => 상속 받는 메서드 중에서 반드시 서브 클래스에서 오버라이딩 해야 할 메서드라면 
// 문법으로 표시하는 것이 좋다, 이런 용도로 만든 문법이 추상 메서드 이다
// 추상메서드는 선택이 아니라 필수이다.
// 따라서 서브 클래스를 만ㄷ는 개발자는 반드시 이 추상 메서드를 구현해야 ㅎ나다

// 추상메서드 
// 서브 클래스가 반드시 재 정의 해야 할 메스드라면 수퍼 클래스에서 정의하지 않는다 
// 또한 서브 클래스가 반드시 해당 메서드를 오버라이딩 하도록 강제하고 싶을때 사용하는 문법이다

public abstract class AbstractList <E> {
  protected int size;

  public int size() {
    // 수퍼클래스에서 구현해도 상관없는 것은 
    // 수퍼 클래스에서 일반 메서드 구현한다
    return size;//this 삭제, 자동생성됌
  }

  public abstract void add (E e); 
// 서브 클래스에 정의할 메서드라면 수퍼 클래스에서 정의하지 않는다 
    // 대시 서브 클래스 반드시 구현하도록 강제한다
  
  public abstract void add (int index, E value);

  public abstract E get(int index); 

  public abstract E set (int index, E value); 

  public abstract E remove(int index); 
  
  public abstract Object[] toArray(); 
  
  public abstract E[] toArray(E[] arr); 

}
