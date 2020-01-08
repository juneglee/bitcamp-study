package com.eomcs.util;

public class ArrayList {
  // ArrayList의 전체 요소를 담을 공간을 만들때는 elementDate로 사용한다 
  //Object[] elementDate = new Object[100]; //객체를 저장한는 공간을 100개 만든다
  // 초기값이 100으로 고정되기 때문에 이공간에 사용하는 것보다 생성자에 사용하는 것이 낫다
  Object[] elementDate; //컴파일시에 레퍼런스을 생성자로 넘겨서 받는다  
  int size; //배열공간안에 정보를 담기 위한 공간

  public ArrayList() {
    // super();
    this.elementDate = new Object[100]; 
    // 생성자에 생성하던지 클래스 로컬변수로 만들지 결정할 수 있다
    // 생성자에서 설정하게 되면 생성자에서 특정 조건에서 목적에 따라 초기 값을 변경할 수 있기 때문에 더욱 편하다
  }
  
  public ArrayList(int initialCapacity) {
    // super();
    this.elementDate = new Object[initialCapacity];
  }
  
}
