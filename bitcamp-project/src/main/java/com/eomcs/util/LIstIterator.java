package com.eomcs.util;

// ArrayList 객체에서 iterator 규칙을 정의
public class LIstIterator<E> implements Iterator<E> {


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
