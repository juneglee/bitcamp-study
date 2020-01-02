package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {
  static final int DEFAULT_CAPACITY = 3;

  Board[] list; //배열의 주소만 가지고 있기 때문에 생성자로 주소와 조인한다
  int size = 0;

  //생성자
  public BoardList() { 
    this.list = new Board[DEFAULT_CAPACITY];
  }
  //생성자
  public BoardList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Board[DEFAULT_CAPACITY];
    else
      this.list = new Board[capacity];
  }

  public Board[] toArray() {
    // 전체의 배열중에서 인스턴스 있는 배열의 주소만을 리턴한다
    /*
    Board[] arr = new Board[this.size];
    for (int i=0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
     */
    return Arrays.copyOf(this.list, this.size);
    // list 배열을 주고 size 몇개까지
  }

  public void add(Board board) {
    if (this.size == this.list.length) {
      // 현재 배열에 게스글 객체가 꽉 찼으면, 배열을 늘린다.
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      /*
      Board[] arr = new Board[newCapacity];
      for (int i = 0; i<this.list.length;i++) {
        arr[i] = this.list[i];
      // 기존 배열은 가비지가 되어 비효율적이고
      // 그래서 linklist를 사용하게 된다
      }      this.list = arr;
       */
      this.list = Arrays.copyOf(this.list, newCapacity);
      // 배열에 값을 new값만큼 늘린다
      System.out.printf("새 배열을 %d 개 생성하였음", newCapacity);
    }
    this.list[this.size++] =board;
  }


  public Board get (int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        // 배열의 값을 하나씩 no와 비교하여 값이 동일하면 그값을 리턴한다
        return this.list[i];
      }
    }
    return null;

  }
}
