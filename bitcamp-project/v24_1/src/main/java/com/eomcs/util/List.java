package com.eomcs.util;

public interface List<E> {
  // 사용규칙 (호출할 메서드 시그너처 형식)이기 때문에 메서드는 추상 메서드이다.
  // 또한 규칙은 공개 되어야 하기 때문에 모든 메서든 public 이다.
  // => 문법
  //    public abstract 리턴타입 메서드명 (파라미터.....);
  //public 과 abstract 각각 생략이 가능하다 

  public abstract void add (E e); 

  void add (int index, E value);

  E get(int index); 

  E set (int index, E value); 

  E remove(int index); 

  Object[] toArray(); 

  E[] toArray(E[] arr); 

  int size();

  // 내부에 보관된 값을 꺼내주는 메서드를 추가한다.
  // = > 값을 저장하는 방식에 따라 구현 방법이 다르기 때문에 
  //     서브 클래스가 반드시 구현해야만 하는 추상 메서드 이다.
  public abstract Iterator<E> iterator();

}
