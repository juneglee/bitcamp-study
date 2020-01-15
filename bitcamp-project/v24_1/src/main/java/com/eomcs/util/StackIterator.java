package com.eomcs.util;

public class StackIterator<E> implements Iterator<E> {


  Stack<E> Stack;

  public StackIterator(Stack<E> Stack) {
    this.Stack = Stack.clone();
    //꺼내는 순간 제거되기 때문에 복제를 해야 한다 
  }
  public boolean hasNext() {
    return !Stack.empty(); 
  }
  public E next() {
    return Stack.pop(); 
  }
}
