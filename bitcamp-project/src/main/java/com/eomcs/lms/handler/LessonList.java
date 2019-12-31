package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int lessonSIZE = 3;
  
  Lesson[] list;
  int size = 0;
  
  public LessonList () {
    this.list = new Lesson[lessonSIZE];
  }
  
  public Lesson[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  public void add (Lesson lesson) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = lesson;
  }
}
