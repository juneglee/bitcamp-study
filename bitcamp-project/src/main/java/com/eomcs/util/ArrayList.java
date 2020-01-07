package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> { 
  static final int DEFAULT_CAPACITY = 3;

  Object[] list; 
  int size = 0;

  public ArrayList() { 
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }

  @SuppressWarnings({"unchecked"})
  public E[] toArray(E[] arr) {
    
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
    }
    System.arraycopy(this.list, 0, arr, 0, this.size);
 
    return arr;
  }

  public void add(E obj) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      
    }
    this.list[this.size++] =obj;
  }

  @SuppressWarnings("unchecked")
  public E get (int idx) { 
    if (idx >= 0 && idx < this.size) {
      return (E)this.list[idx];
    } else {
      return null;
    }
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E obj) {
    if (index < 0 || index >= this.size)
      return null;
    E old = (E) this.list[index]; // index를 저장한 주소를 저장 
    this.list[index] = obj; //기존의 index 값에 새 값 obj을 넣겠다
    return old; // 변경한 새 값을 리턴해라 
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) // 범위를 벗어난 값은 무시한다
      return null;
    
    E old = (E) this.list[index];  // 삭제할 항목을 따로 보관해 둔다
    
    for (int i = index + 1; i < this.size ; i++) {
      // 만일 삭제하는 값이 2라면 i는 3이 된다 size는 4가 되기 때문에 1번의 반복을 실행한다 
      // 이때 i는 +1를 더한 값이 된기 때문에 
      this.list[i - 1] = this.list[i];
      // i-1 은 지워질 인덱스 값이 되고 이때 i는 지워질 인덱스의 다음 값이 되기 때문에 
      // 결국 앞으로 당겨지게 되는 것이다 
      // 그림을 생각해야 한다 
    }
    // 
    
    this.size--; // 삭제한 만큼 size를 줄인다
    this.list[this.size] = null; // 비워진 곳에는 null값으로 만들어 garbage를 줄인다 
    
    // 삭제한 항목을 리턴한다
    return old;
  }
  
  public int size() {
    return this.size;
  }
  
}
