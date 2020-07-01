package com.eomcs.lms.Service.impl;

import java.util.HashMap;
import java.util.List;
import com.eomcs.lms.Service.LessonService;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;

  public LessonServiceImpl(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public Lesson get(int no) throws Exception {
    // 이 메서드는 사실 별도의 작업을 하지 않는다
    // 그냥 Dao의 메서드를 호출하여 리턴 받은 값을 그대로 다시 리턴할 뿐이다
    // 이렇게 아무런 일도 안하는 메서드를 만든 이유는 무엇인가?
    // => Servlet에서 Service 객체를 사용하도록 구조를 변경하였다.
    // =>프로그래밍의 일관성을 위해 해당 구조에 맞춘 것이다.
    // => Servlet에서 어떤 경우에는 Dao를 직접 사용하고,
    // 또 어떤 경우에는 Service 를 사용한다면 일관성이 없어 유지보수가 어려워진다
    // => 이처럼 때로는 아무런 일도 하지 않는 서비스 클래스를 정의하더라도
    // 프로그래밍의 일관성 때문임을 기억하라.
    return lessonDao.findByNo(no);
  }

  @Override
  public int add(Lesson lesson) throws Exception {
    return lessonDao.insert(lesson);
  }

  @Override
  public int delete(int no) throws Exception {
    return lessonDao.delete(no);
  }

  @Override
  public List<Lesson> get(HashMap<String, Object> params) throws Exception {
    return lessonDao.findBykeyword(params);
  }

  @Override
  public List<Lesson> list() throws Exception {
    return lessonDao.findAll();
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    return lessonDao.update(lesson);
  }

}
