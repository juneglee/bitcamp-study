package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {

  Node<E> first;
  Node<E> last;
  int size;

  @SuppressWarnings("unchecked")
  public void add (E value) {
    Node<E> newNode = new Node();
    newNode.value = value;

    if(first == null) {
      last = first = newNode; 
    } else {
      last.next = newNode;
      last = newNode;
    }
    this.size++;
  }

  public E get (int index) { 

    if(index < 0 ||  index >= this.size) 
      return null;

    Node<E> cursor = first;
    for (int i = 0 ; i < index ; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  @SuppressWarnings("unchecked")
  public void add (int index, E value) { 
    //(위치,값 )
    // 위치를 지정하기 때문에 유효한범위가 있어야 한다
    if(index < 0 ||  index >= this.size) 
      return; //void이기 때문에 null을 사용하지 않느다 

    Node<E> newNode = new Node();
    newNode.value = value;

    Node<E> cursor = first;
    for (int i = 0 ; i < index -1 ; i++) {
      // 추가할 값의 인덱스 전에서 찾아야 한다
     
      cursor = cursor.next;
     }
    if (index == 0) { // 인덱스가 0일때 즉 범위내의 값중에서 가장 작을 때 
      newNode.next = first; //첫번째 노드는 두번째가 된다
      first = newNode; //새로 추가된 노드를 첫번쨰가 된다
    } else { 
    newNode.next = cursor.next; // 삽입할려는 곳에 커스를 위치 시키는 것이 새로 추가된 노드의 다음이 같은 곳에 위치된다
    cursor.next = newNode; //기존 노드의 다음은 새 노드를 가르키게 한다
    }
    this.size++;
  }
  
  public E remove (int index) { //기존의 값을 리턴하기 때문에 object를 사용하였다.    
    if(index < 0 ||  index >= this.size) 
      return null;
    
    Node<E> cursor = first;
    for (int i = 0 ; i < index - 1 ; i++) {
      cursor = cursor.next;
    }
    // 삭제할 것 전것을 찾아서 커서로 위치 시킨다
    Node<E> deleteNode = null ;
    if (index == 0) {
      deleteNode = first;
      first = deleteNode.next;
    } else {
    deleteNode = cursor.next; // 현재 커서의 다음이 삭제할 노드라고 알려줌
    cursor.next = deleteNode.next; // 삭제할 노드의 다음값의 주소를 현재 커스 주소에 넣음으로써 삭제할 다음 노드와 연결
    }
    deleteNode.next =null; //쓰레기가 다른 가비를 가르쳐 유효한 값이 되지 않도록 한다
    size--;
    return deleteNode.value; //삭제할 노드의 값을 찾고 싶은 사람이 있기 때문에 값으로 리턴한다
  }
  

  public E set (int index, E value) { 

    if(index < 0 ||  index >= this.size) 
      return null;

    Node<E> cursor = first;
    for (int i = 0 ; i < index ; i++) {
      cursor = cursor.next;
    }
    
    E oldValue = cursor.value;
    cursor.value = value;
    
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray() {
    E[] arr = (E[]) new Object[size]; 
    
    Node<E> cursor = first;
    for (int i = 0 ; i < size ; i++) {
      arr[i] = cursor.value; // 현재 커스를 배열에 담는다
      cursor = cursor.next; //커서를 다음방으로 이동한다
    }
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size); 
      //(배열의 자체타입, 각 항목의 타입, 길이)
    }
    
    Node<E> cursor = first;
    for (int i = 0 ; i < size ; i++) {
      arr[i] = cursor.value; // 현재 커스를 배열에 담는다
      cursor = cursor.next; //커서를 다음방으로 이동한다
    }
    return arr;
  }
  
  public int size() {
    return this.size;
  }

  
  static class Node<T> {
    T value;
    Node<T> next; //.next라고 지정하여 주소의 값을 나타낸다
  }
}
