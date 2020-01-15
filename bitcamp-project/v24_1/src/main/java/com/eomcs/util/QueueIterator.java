package com.eomcs.util;

public class QueueIterator<E> implements Iterator<E> {


  Queue<E> Queue;

  public QueueIterator(Queue<E> Queue) {
    this.Queue = Queue.clone();
  }
  public boolean hasNext() {
    return Queue.size() > 0; 
  }
  public E next() {
    return Queue.poll(); 
  }
}
