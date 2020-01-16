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
    // anonymous class :인스턴스를 한 개만 생성한다면 로컬 클래스를 익명 클래스로 정의하라 
    // 익명 클래스의 코드를 리턴하는 것이 아니라 
    // 이터레이터 규칙에 의해서 만들어진 객체들을 생성하고
    // 만들어진 객체을 담은 주소를 리턴한다
    return  new Iterator<E>() { 
      Stack<E> Stack;
      {
        this.Stack = (Stack<E>) Stack.this.clone();
      } // 익명 클래스는 생성자가 없기 때문에 초기화 블록으로 만든다 

      public boolean hasNext() {
        return !Stack.empty(); 
      }
      public E next() {
        return Stack.pop(); 
      }
    };
  }
}



