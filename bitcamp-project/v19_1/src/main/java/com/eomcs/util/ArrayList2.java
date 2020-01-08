package com.eomcs.util;

import java.util.Arrays;

public class ArrayList2 <E>{

  private static final int DEFAULT_CAPACITY = 2;
  Object[] elementData;
  int size;

  public ArrayList2() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList2(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY ) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  public void add (E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >>1);

      this.elementData = Arrays.copyOf(this.elementData, newSize);
    }
    this.elementData[this.size++] = e;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index > this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index > this.size) {
      return null;
    }
    
    E oldValue =  (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
                     this.elementData, index, this.size - (index + 1));
   
    this.size--;
    return oldValue;
  }

  public int size() {
    return this.size;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size); 
  }
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }else {
      System.arraycopy(this.elementData, 0, arr, 0, this.size);
   }
  return arr;
}

  
}
