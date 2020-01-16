// 스택은 배열 및 링크 리스트로 사용이 가능하지만, 큐는 링크드 리스트가 휠씬 편함
package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable { //순서의 규칙이 있다 

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);
  }
  /*
  @Override
  public Queue clone() {
    // 단순히 객체의 인스턴스 변수를 복제하는 shallow copy 수행
    // Object(모든 객체)의 clone은 shallow copy를 수행한다
    //
    // Queue에서 poll()을 수행하면 다음 노드를 가리키는 first를 노드를 삭제하게 되고,
    // 이때 원본 객체의 노드의 링크 정보를 변경하게 된다
    // 따라서 다음에 다시 복제를 수행하면, 원본 노드가 링크 정보가 제거되었기 때문에 제대로 수행할 수 없다 
    // 해결책
    // => 원본객체가 사용하는 노드도 함께 복제 해야한다.
    //    즉, deep copy로 수행해야 한다 
    try {
      return (Queue)super.clone();
    }catch (CloneNotSupportedException ex) {
      System.out.println(ex); 
      return null; 
    }
  }
  */ 
  
  // deep 수행
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    // linkedList의 경우 노드와 노드 사이를 연결해야 하기 때문에 단순히 shallow는 안된다
    // 새 Queue만들고, 기존의 큐를 새 큐에 저장 
    // 큐에서는 deleteNode에서 null값을 지정한 remove() 메서드로 인하여 linkedlist의 다음 주소값이 없어지기 때문에 
    // 단순히 배열의 null으로 초기화 되는 것과 다르게 아에 값이 나오지 않게 된다
    
    for (int i = 0 ; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
  
  public Iterator<E> iterator() {
    // this = 인스턴스 주소;
    // inner class의 생성자를 호출할 때는 바깥 클래스의 인스턴스 주소를 파라미터로 넘기지 말고
    // 앞에서 넘겨라
    return this.new QueueIterator<>();
  }
  
  // non static nestedx class = inner class
  class QueueIterator<T> implements Iterator<T> {

    Queue<T> Queue;

    @SuppressWarnings("unchecked")
    public QueueIterator() {
      this.Queue = (Queue<T>) Queue.this.clone();
    }
    public boolean hasNext() {
      return Queue.size() > 0; 
    }
    public T next() {
      return Queue.poll(); 
    }
  }

}
