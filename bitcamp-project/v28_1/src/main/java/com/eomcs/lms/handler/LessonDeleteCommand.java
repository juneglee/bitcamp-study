// 사용자 입력을 받는 코드를 별도의 메서드를 분리한다
//
package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;


public class LessonDeleteCommand implements Command {

  List<Lesson> lessonList;
  Prompt prompt;


  public LessonDeleteCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    this.lessonList = list;
  }



  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("번호? "));

    if (index == -1)
      System.out.println("수업이 유효하지 않습니다");

    this.lessonList.remove(index);
    System.out.println("수업을 변경했습니다.");
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
