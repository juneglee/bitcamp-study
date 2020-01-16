package com.eomcs.util;

public abstract class AbstractList <E> implements List<E> {
  protected int size;
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {
    
    // local class : 특정 메서드 안에서만 사용하는 중첩 클래스라면
    // 그 메서드 안으로 위치를 옮긴
    class LIstIterator<T> implements Iterator<T> {  

      List<T> list;
      int cursor;

      @SuppressWarnings("unchecked")
      public LIstIterator() {
        // 로컬 클래스는 인스턴스 멤버가 
        
        this.list = (List<T>) AbstractList.this; // 클래스와 인터페이스 관계에서 형변환
      }
      public boolean hasNext() {
        return cursor < list.size(); 
      }
      public T next() {
        return list.get(cursor++); 
      }
    }
    // 로컬 클래스는 인스턴스 멤버가 아니기 때문에
    // 앞쪽에 인스턴스 주소를 전달해서는 안된다 
    // 즉 this. 를 붙여서는 안된다
    // 바깥에 있던 LIstIterator의 멤버라서 this를 사용했는데, 안쪽으로 옮겨서 this를 못찾는다
    
    return new LIstIterator<>();
  }
}

/* 다음은 로컬 클래스에 대한 의미 전달을 위해서 간략하게 작성한 코드이다
 pseudo :의사 코드 
class 클래스 {
필드
블록
생성자
메서드 {
  this 사용
  로컬 변수
  중첩 클래스 - (바깥에 있던 것을 안으로 옮김) >>> 로컬 클래스로 변경됌
              - 이때는 바깥클래스.this 사용 가능 
              - 로컬 변수 접근 가능 
}
중첩 클래스 {
  바깥클래스.this 사용
} 
 */
