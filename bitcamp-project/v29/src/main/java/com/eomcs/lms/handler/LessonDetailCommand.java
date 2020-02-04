// 사용자 입력을 받는 코드를 별도의 메서드를 분리한다
//
package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;


public class LessonDetailCommand implements Command {

  List<Lesson> lessonList;
  Prompt prompt;


  public LessonDetailCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    this.lessonList = list;
  }


  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당번호의 수업이 없습니다");
      return;
    }

    Lesson lesson = this.lessonList.get(index);

    System.out.printf("번호 : %d\n", lesson.getNo());
    System.out.printf("수업명 : %s\n", lesson.getTitle());
    System.out.printf("설명 : %s\n", lesson.getDescription());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간 : %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간 : %d\n", lesson.getDayHours());
    System.out.printf("조회수 : %d\n", lesson.getViewCount());
  }



  private int indexOfLesson(int no) {
    for (int i = 0; i < this.lessonList.size(); i++) {
      if (this.lessonList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }


}
