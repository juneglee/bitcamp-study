package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Member;

public class MemberList {
  static final int memberSIZE = 100;

  Member[] list; 
  int size = 0;


  public MemberList() {
    this.list = new Member[memberSIZE];
  }


  public Member[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Member member) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      // 기본의 배열은 인덱스를 사용하여 0에서부터 시작하고 이때 늘어난 인덱스의 값을 old값으로 한다
      // 또한 게시판의 count는 1부터 시작하여 이때 값을 비교 한다
      // 즉. 인덱스(old) 3일때 게시판(new)은 4가 된다 
      // (old 3+(3/2=1) ==  new 4) --- 4번째 게시판 (인덱스 3)
      // (old 4+(4/2=2) ==  new 6) --- 5번째 게시판 (인덱스 4)
      // (old 6+(6/2=3) ==  new 9) --- 7번째 게시판 (인데스 6)
      // (old 9+(9/2=4) ==  new 13) --- 10번째 게시판 (인데스 9) 
    }
    this.list[this.size++] = member;
  }

}
