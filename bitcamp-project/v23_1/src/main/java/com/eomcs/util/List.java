package com.eomcs.util;

// 1) Generalization 1단계
//  => ArrayList와 LinkedList 사이의 공통 분모를 추출하여 수퍼 클래스를 정의 
//  => ArrayList와 LinkedList 이렇게 정의한 수퍼 클래스를 상속 받는다


public class List <E> {
  protected int size;

  public int size() {
    return size;//this 삭제, 자동생성됌
  }

  public void add (E e) {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에 
    // 여기서 구현할 필요가 없다
    // add에서 사용한 내부 (즉, 사용한 코드 동작 방법)이 다르다 
  }
  public void add (int index, E value) {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에 
    // 여기서 구현할 필요가 없다
  }

  public E get(int index) {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에 
    // 여기서 구현할 필요가 없다
    return null;
  }

  public E set (int index, E value) {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에 
    // 여기서 구현할 필요가 없다
    return null;
  }

  public E remove(int index) {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에 
    // 여기서 구현할 필요가 없다
    return null;
  }
  
  public Object[] toArray() {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에 
    // 여기서 구현할 필요가 없다
    return null;
  }
  
  public E[] toArray(E[] arr) {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에 
    // 여기서 구현할 필요가 없다
    return null;
  }

}
