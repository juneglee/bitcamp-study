package com.eomcs.util;

public abstract class AbstractList <E> implements List<E> {
  protected int size;
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {
    // List에서 객체에서 값을 꺼내주는 일을 할 Iterator 객체를 준비하여 리턴한다 
    // return new LIstIterator<>(this);// this :iterator를 호출할때 this의 내장변수로 넘겨준다
    return this.new LIstIterator<>();
  }

  // non-static nested class = inner class
  class LIstIterator<T> implements Iterator<T> { // 중첩클래스와 클래스 사이에 요소(T)를 달리 한다 

    List<T> list;
    int cursor;

    @SuppressWarnings("unchecked")
    public LIstIterator() {
      this.list = (List<T>) AbstractList.this; // 클래스와 인터페이스 관계에서 형변환
    }
    public boolean hasNext() {
      return cursor < list.size(); 
    }
    public T next() {
      return list.get(cursor++); 
    }
  }
}
