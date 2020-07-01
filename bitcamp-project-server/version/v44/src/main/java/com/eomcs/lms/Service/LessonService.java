package com.eomcs.lms.Service;

import java.util.HashMap;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonService {
  Lesson get(int no) throws Exception;

  List<Lesson> get(HashMap<String, Object> params) throws Exception;

  List<Lesson> list() throws Exception;

  int delete(int no) throws Exception;

  int update(Lesson lesson) throws Exception;

  int add(Lesson lesson) throws Exception;
}
