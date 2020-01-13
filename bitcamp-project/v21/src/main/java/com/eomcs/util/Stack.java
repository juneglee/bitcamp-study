package com.eomcs.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {

  public static final int DEFAULT_CAPACITY = 10;
  Object[] elementData; // 제네릭에서 배열은 Object를 그대로 사용
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
    //배열에 사이즈를 증가시키는 것은 배열을 증가 시키고 사이즈를 하나쯕 후위 증가하여 
    //결국 size의 위치는 빈 공간을 가리키게 된다 
  }

  private void grow() { // 새로 증가된 배열과 그 안의 값들을 elementData에 저장
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }

  private int newCapacity () { // 배열을 증가 시킨다
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1 ); //연산결과를 바로 리턴 할 수 있다.
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    // 사이즈는 하나씩 증가하면서 0~ 사이즈까지 증가하게 된다
    // 이때 0부터 시작하는 값떄문에 사이즈는 결국 빈방을 가리킨다 
    if (empty()) {
      return null;
    }
    E value = (E)this.elementData[--this.size];
    //--this.size;//element에 대한 배열을 안가르키면 숫자을 가르킨다
    this.elementData[this.size] = null;
    // deep copy를 하지 않기 떄문에 복제한 레퍼런스서는 이전의 인스턴스를 같이 공유하여 사용하게 된다
    // 그래서 복제한 레퍼런스에서 garbage를 제거하기 위해서 null를 사용하면 
    // 기존의 인스턴스 값에서 null값이 되어 값이 변경하기 힘들어 진다. 
    // 이러한 복제를 쉐로우 shallow 복제라고 하며, 
    // 복제를 할떄는 인스턴스도 복제할 수 있는 Deep 복제를 해서 값이 변경되지 않도록 해야 한다 
    /*
     * 명령> history
       history
       null
       null
       null
       null
       :
     */
    return value;
  }

  public boolean empty() {
    return this.size == 0; //refactory 
  }

  // Object.clone()의 shallow copy 이용하여 스택 객체 복사하기
  //=> 객체의 인스턴스 변수를 그대로 복제한다
  // => 인스턴스 변수가 가리키는 객체는 복제하지 않는다
  // 문제점?
  // 데이터가 실제 저장된 배열은 복제하지 않는다 
  // 그래서 배열의 값을 바꾸면 원본 스택에도 영향을 끼친다.
  /*
  @Override
  public Stack clone() {
    // 문제가 발생하면 null을 리턴
    try { 
      return (Stack) super.clone(); 
    }catch (CloneNotSupportedException ex) {
      // Object 의 clone() 메서드는 복제가 허용된 객체에 대해서만 해당 인스턴스 변수를 복제한다 
      // 복제가 허용되지 않은 객체에 대서 clone()을 호출하면 
      // CloneNotSupportedException 실행 오류가 발생한다.
      //
      // 해결책 
      // 즉 해당 객체가 복제할 수 있음을 표시하는 문법이다.
      // => clone()을 재정의하는 메서드는 반드시 Cloneable 인터페이스를 지정해야 한다
      // 방법 : 클래스명 implements Cloneable { }
      System.out.println(ex); //문자열을 리턴하며 toString를 안써도 된다(Object소속이기 때문)
      return null;
    }

  }
   */

  // deep copy를 이용하여 객체 복제하기
  // 데이터가 들어있는 배열도 그대로 복제한다
  // 따라서 배열의 값을 바꾸더라도 원본 객체의 영향을 끼치지 않는다 

  @SuppressWarnings("unchecked")
  public Stack<E> clone() {
    try {
      // 1) shallow copy를 통해 이 객체의 인스턴스 변수는 그대로 복제한다
      Stack<E> temp = (Stack<E>)/*제네릭 할때 형변환을 가리킬때는 안쪽에 넣는다*/ super.clone();

      // 2) elementData 배열을 복제
      //    => 배열에 저장된 객체까지는 복제를 수행하지 않는다
      //    => 어디까지 deep 복제할 것인지 상황에 따라 결정한다 (이 예제에서는 문자열 ) 
      Object[] arr = new Object[this.size]; // 새로 만든 배열
      for (int i = 0 ;  i < this.size ; i++) {
        arr[i] = this.elementData[i]; // 기존의 배열을 새로만든 곳에 저장
      }
      //3) 복제한 스택 객체가 새로 만든 배열을 가르키도록 한다 
      temp.elementData = arr; // 새로만든것을 임시 저장
      return temp;

    } catch (CloneNotSupportedException ex) {
      System.out.println(ex); 
      return null;
    }

  }
}
