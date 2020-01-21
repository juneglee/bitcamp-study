// 사용자 입력을 받는 코드를 별도의 메서드를 분리한다
//
package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Lesson;


public class LessonListCommand implements Command {

  List<Lesson> lessonList;


  public LessonListCommand(List<Lesson> list) {
    this.lessonList = list;
  }


  @Override
  public void execute() {
    Iterator<Lesson> iterator = lessonList.iterator();

    while (iterator.hasNext()) {
      Lesson l = iterator.next();
      System.out.printf(
          "번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간" + "\n일수업시간: %d 시간\n조회수: %d\n ",
          l.getNo(), l.getTitle(), l.getDescription(), l.getStartDate(), l.getEndDate(),
          l.getTotalHours(), l.getDayHours(), l.getViewCount());
    }
  }


}
