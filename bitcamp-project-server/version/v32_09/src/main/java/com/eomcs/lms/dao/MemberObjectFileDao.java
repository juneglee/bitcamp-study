package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberObjectFileDao extends AbstractObjectFileDao<Member> {

  public MemberObjectFileDao(String filename) {
    super(filename);
  }

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드 정의
  public int insert(Member member) throws Exception {
    // 마이바티스 int를 사용하여 리턴한다

    // 중복 저장하지 않기 위한 방법
    if (indexOf(member.getNo()) > -1) {
      return 0;
    }

    list.add(member);
    saveData(); // 객체가 변할때마다 저장하겠다
    return 1; // 같은 번호의 게시물이 없기때문에 1개를 리턴한다
  }

  public List<Member> findAll() throws Exception {
    return list;
  }

  public Member findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Member member) throws Exception {
    int index = indexOf(member.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, member);// 기존 객체를 파라미터로 받은 객체로 바꾼다
    saveData();
    return 1;
  }

  public int delete(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;

  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i;
      }
    }
    return -1;
  }

}
