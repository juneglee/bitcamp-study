package com.eomcs.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {

  public static final int DEFAULT_CAPACITY = 10;
  Object[] elementData; 
  int size;

  public Stack() {
    this.elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  public void push (E value) {
    if (this.size == elementData.length) { 
      grow();
    }
    this.elementData[size++] = value; 
  }

  private void grow() { 
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }

  private int newCapacity () { 
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1 ); 
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    if (empty()) {
      return null;
    }
    E value = (E)this.elementData[--this.size];
    this.elementData[this.size] = null;
   
    return value;
  }

  public boolean empty() {
    return this.size == 0; 
  }

  @SuppressWarnings("unchecked")
  public Stack<E> clone() {
    try {
      Stack<E> temp = (Stack<E>) super.clone();

      Object[] arr = new Object[this.size]; 
      for (int i = 0 ;  i < this.size ; i++) {
        arr[i] = this.elementData[i];
      }
      temp.elementData = arr; 
      return temp;

    } catch (CloneNotSupportedException ex) {
      System.out.println(ex); 
      return null;
    }

    
  }
  public Iterator<E> iterator() {
    // local class : 특정 메서드 안에서만 사용하는 중첩 클래스라면
    // 그 메서드 안으로 위치를 옮긴
    class StackIterator<T> implements Iterator<T> {
      Stack<T> Stack;

      @SuppressWarnings("unchecked")
      public StackIterator() {
        this.Stack = (Stack<T>) Stack.this.clone();
      }
      public boolean hasNext() {
        return !Stack.empty(); 
      }
      public T next() {
        return Stack.pop(); 
      }
    }
    return new StackIterator<>();
  }
}



