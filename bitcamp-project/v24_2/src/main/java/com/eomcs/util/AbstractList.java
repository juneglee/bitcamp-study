package com.eomcs.util;

public abstract class AbstractList <E> implements List<E> {
  protected int size;
  public int size() {
    return size;
  }
  
  @Override
  public Iterator<E> iterator() {
    // List에서 객체에서 값을 꺼내주는 일을 할 Iterator 객체를 준비하여 리턴한다 
    return new LIstIterator<>(this);
  }
  
  // 중첩 클래스 (nested class), 이 클래스에서만 사용하도록 만든다 
  
  static class LIstIterator<E> implements Iterator<E> {

    List<E> list;
    int cursor;

    public LIstIterator(List<E> list) {
      this.list = list;
    }
    public boolean hasNext() {
      return cursor < list.size(); 
    }
    public E next() {
      return list.get(cursor++); 
    }
  }
}
