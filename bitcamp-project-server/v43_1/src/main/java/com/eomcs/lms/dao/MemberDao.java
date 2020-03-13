package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  // 데이터를 저장하고 꺼내는 방식(파일, 웹하드 ,클라우드저장소, DB 등)에 사용할 떄
  // DAO 사용법을 통일하기 위해서 메서드 호출 규칙을 정의한다

  int insert(Member member) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByNo(int no) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  default List<Member> findByKeyword(String keyword) throws Exception {
    return null;
  }

  default Member findByEmailAndPassword(String email, String password) throws Exception {
    return null;
  }

}
