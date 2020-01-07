package com.eomcs.util;

import java.util.Arrays;
// 게시글을 저장하는 공간

public class ArrayList<E> { //E : 클래스이름을 받는 변수 
  static final int DEFAULT_CAPACITY = 100;

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
      // 배열에 크기와 상관없이 새로 만들어서 리턴한다 
    }
    System.arraycopy(this.list, 0, arr, 0, this.size);
    /// 데이터 있는 곳/ 시작 / 빈곳/ 빈곳의 시작/ size 만큼
    
    /*
    // 위의 arraycopy()는 다음 코드와 같다 
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (E) this.list[i];
    }
    */
    return arr;
  }

  public void add(E obj) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d 개 생성하였음", newCapacity);
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
  
  public int size() {
    return this.size;
  }
}
