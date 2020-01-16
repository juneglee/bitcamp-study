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

    // local class : 특정 메서드 안에서만 사용하는 중첩 클래스라면
    // 그 메서드 안으로 위치를 옮긴
    class QueueIterator<T> implements Iterator<T> {

      Queue<T> Queue;

      @SuppressWarnings("unchecked")
      public QueueIterator() {
        this.Queue = (Queue<T>) Queue.this.clone();
      }
      public boolean hasNext() {
        return Queue.size() > 0; 
      }
      public T next() {
        return Queue.poll(); 
      }
    }

    return new QueueIterator<>();
  }

}
