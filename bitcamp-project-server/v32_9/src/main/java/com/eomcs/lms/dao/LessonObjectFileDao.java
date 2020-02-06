package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonObjectFileDao extends AbstractObjectFileDao<Lesson> {
  public LessonObjectFileDao(String filename) {
    super(filename);
  }

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드 정의
  public int insert(Lesson lesson) throws Exception {
    // 마이바티스 int를 사용하여 리턴한다

    // 중복 저장하지 않기 위한 방법
    if (indexOf(lesson.getNo()) > -1) { // null 값이 아니기 때문에 같은 번호의 게시물이 있다면,
      return 0; // 같은 번호가 있기 떄문에 0개 리턴한다
    }

    list.add(lesson);
    saveData(); // 객체가 변할때마다 저장하겠다
    return 1; // 같은 번호의 게시물이 없기때문에 1개를 리턴한다
  }

  public List<Lesson> findAll() throws Exception {
    return list;
  }

  public Lesson findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Lesson lesson) throws Exception {
    int index = indexOf(lesson.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, lesson);// 기존 객체를 파라미터로 받은 객체로 바꾼다
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
