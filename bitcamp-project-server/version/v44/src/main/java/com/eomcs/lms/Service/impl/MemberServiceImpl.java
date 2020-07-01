package com.eomcs.lms.Service.impl;

import java.util.List;
import com.eomcs.lms.Service.MemberService;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberServiceImpl implements MemberService {

  MemberDao memberDao;

  public MemberServiceImpl(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return memberDao.delete(no);
  }

  @Override
  public List<Member> get() throws Exception {
    return memberDao.findAll();
  }

  @Override
  public List<Member> key(String keyword) throws Exception {
    return memberDao.findByKeyword(keyword);
  }

  @Override
  public Member No(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  @Override
  public int add(Member member) throws Exception {
    return memberDao.insert(member);
  }

  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }
}
