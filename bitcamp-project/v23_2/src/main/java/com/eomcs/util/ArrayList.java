package com.eomcs.util;

import java.util.Arrays;
public class ArrayList <E> extends AbstractList<E> {
  
  
  private static final int DEFAULT_CAPACITY = 3;
  Object[] elementData ;


  public ArrayList() {
    this.elementData  = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if(initialCapacity < DEFAULT_CAPACITY) {
      this.elementData  = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData  = new Object[initialCapacity];
      // 범위를 넘어가면 초기크기로 설정한다 
    }
  }
  
  // 추상 메서드를 다음과 같이 @Override 에노테이션을 붙이지 않아도 
  // 문법 검사를 한다 
  @Override
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);

      this.elementData = Arrays.copyOf(this.elementData, newSize);
      // 아래의 반복문의 형식을 arrays의 안의 패키를 통해서 간략하게 사용할 수 있다 

      /* 
      Object[] newArr = new Object[newSize];

      for (int i = 0; i < this.size ; i++) {
        newArr[i] = this.elementDate[i];
      }
       */
    }
    this.elementData[this.size++]  = e;
    // elementDate는 배열을 받을 주소를 나다내고 a1는 그때 넣은 인스턴스 레퍼런스 주소를 나타낸다
    // 이때 값을 받은 e를 통해 인스턴스 값에 저장하고
    // 후위 연산자를 통해서 사이즈를 증가시킨다 
  }
  @Override
  @SuppressWarnings("unchecked")
  public E get(int index) {
    // 즉 0 ~ 3의 인덱스는 인덱스 번호는 4개이지만 값을 연결된 것이 3개로 연결되어 있기 때문에 
    // 3개의 움직인 값을 인덱스로 한다

    if (index < 0 || index >= this.size)
      // 유효한 인덱스가 아니면 리턴값을 null 값을 리턴하도록 한다
      return null;
    // object의 자손 중에 선언할 것이다 (string, int 등이 될 수 있다는 것을 표시한다)
    return (E) this.elementData[index];
    // 지정된 배열의 레퍼런스 값의 인덱스 값을 리턴한다 
  }
  @Override
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size)
      return null; 
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  @Override
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size)
      return null; 
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1,this.elementData ,
        index, this.size - (index + 1));
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementDate[i-1]=this.elementDate[i];
      // 줄여진 값을 앞으로 당길 때는 끝에서 해당 값까지 줄줄이 하나씩 당겨진다
    }
     */
    this.size--;
    return oldValue;
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0 ; i < this.size ; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
     */
  }
  @Override
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    // 파라미터로 받은 배열이 작을 때는 새 배열을 만들어 리턴.
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }else {
      System.arraycopy(this.elementData, 0 , arr, 0, this.size);
      // 넉넉할 때는 파라미터로 받은 배열을 그대로 리턴.
    }
    return arr;
  }

  @Override
  public void add(int index, E value) {
    if (index < 0 || index >= this.size)
      return;

    if (this.size == this.elementData.length) {
      grow();
    }

    for (int i = size - 1; i >= index; i--)
      this.elementData[i + 1] = this.elementData[i];

    this.elementData[index] = value;
    this.size++;
  }
  
  private Object[] grow() {
    return this.elementData = Arrays.copyOf(this.elementData, 
        newCapacity());
  }

}

