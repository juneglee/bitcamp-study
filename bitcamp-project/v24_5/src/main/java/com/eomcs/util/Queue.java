package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable { //순서의 규칙이 있다 

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);
  }
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    for (int i = 0 ; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }

  public Iterator<E> iterator() {
    // anonymous class :인스턴스를 한 개만 생성한다면 로컬 클래스를 익명 클래스로 정의하라 
    return new Iterator<E>() {

      Queue<E> Queue = (Queue<E>) Queue.this.clone();
      // 인스턴스 블록 대신 변수 초기화 문법으로 필드 값을 설정
      
      public boolean hasNext() {
        return Queue.size() > 0; 
      }
      public E next() {
        return Queue.poll(); 
      }
    };
  }
}
