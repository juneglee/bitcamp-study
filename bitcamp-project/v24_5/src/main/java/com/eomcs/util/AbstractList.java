package com.eomcs.util;

public abstract class AbstractList <E> implements List<E> {
  protected int size;
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {// 밑에 만들어진 것을 Iterator로 바로 리턴하겠다.

    // anonymous class : 인스턴스를 한 개만 생성할 거면 익명 클래스로 정의하라.
    return new Iterator<E>() {  // 슈퍼 클래스 or 인터페이스 둘중 하나만 사용

      List<E> list;
      int cursor;

      // 익명 클래스는 생성자를 만들수 없기 때문에 인스턴스를 초기화 하기 위해서는 
      // 다음과 같이 인스턴스 블록을 생성하여야 한다
      // (단순한 값일때는 필드 선언에 따른 할당 연산자로 사용할 수 있다) 
      {
        this.list = (List<E>) AbstractList.this; 
      }
      public boolean hasNext() {
        return cursor < list.size(); 
      }
      public E next() {
        return list.get(cursor++); 
      }
    };
  }
}

