package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {
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

  public Object[] toArray() {

    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Object obj) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d 개 생성하였음", newCapacity);
    }
    this.list[this.size++] =obj;
  }


  public Object get (int idx) { // 게시물의 번호 대신 인덱스 번호를 비교한다
    if (idx >= 0 && idx < this.size) {
      return this.list[idx];
    } else {
      return null;
    }
  }
}
