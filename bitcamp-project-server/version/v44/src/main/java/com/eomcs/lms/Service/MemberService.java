package com.eomcs.lms.Service;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberService {

  int add(Member member) throws Exception;

  int delete(int no) throws Exception;

  Member No(int no) throws Exception;

  List<Member> get() throws Exception;

  List<Member> key(String keyword) throws Exception;

  int update(Member member) throws Exception;

}
