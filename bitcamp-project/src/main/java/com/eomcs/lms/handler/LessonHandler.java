// 사용자 입력을 받는 코드를 별도의 메서드를 분리한다 
//
package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Prompt;


public class LessonHandler {

  LinkedList<Lesson> lessonList;
  Prompt prompt;


  public LessonHandler(Prompt prompt){
    this.prompt = prompt;
    this.lessonList = new LinkedList<>();
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    lesson.setNo(prompt.inputInt("번호? "));
    lesson.setTitle(prompt.inputString("수업명? ")); 
    lesson.setDescription(prompt.inputString("설명? "));
    lesson.setStartDate(prompt.inputDate("시작일? "));
    lesson.setEndDate(prompt.inputDate("종료일? "));
    lesson.setTotalHours(prompt.inputInt("총수업시간? "));
    lesson.setDayHours(prompt.inputInt("일수업시간? "));

    lessonList.add(lesson);
    System.out.println("저장하였습니다");
  }

  public void listLesson() {

    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]);
    for (Lesson l : arr) {
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간"
          + "\n일수업시간: %d 시간\n조회수: %d\n ",
          l.getNo(), l.getTitle(), l.getDescription(), l.getStartDate(), 
          l.getEndDate(),l.getTotalHours(),l.getDayHours(),l.getViewCount());
    }
  }

  public void detailLesson() {
    int index = indexOfLesson(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당번호의 수업이 없습니다");
      return;
    }

    Lesson lesson = this.lessonList.get(index);

    System.out.printf("번호 : %d\n", lesson.getNo());
    System.out.printf("수업명 : %s\n", lesson.getTitle());
    System.out.printf("설명 : %s\n", lesson.getDescription());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(),lesson.getEndDate());
    System.out.printf("총수업시간 : %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간 : %d\n", lesson.getDayHours());
    System.out.printf("조회수 : %d\n", lesson.getViewCount());
  }

  public void updateLesson() {
    int index = indexOfLesson(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Lesson oldLesson = this.lessonList.get(index);
    Lesson newLesson = new Lesson();

    newLesson.setNo(oldLesson.getNo());

    newLesson.setTitle(prompt.inputString( String.format("수업명(%s) ? ", oldLesson.getTitle()), 
        oldLesson.getTitle()));
    // 호출 순서는 안쪽부터 바깥쪽으로 호출하여 출력한다
    // 라벨을 만드는데  String.format 기존의 데이터를 가져와서 문자열을 입력하는 것에 사용하여 출력한다
    
    newLesson.setDescription(prompt.inputString( "설명 ? ", oldLesson.getDescription()));

    newLesson.setStartDate(prompt.inputDate(String.format("시작 일(%s) ? ", oldLesson.getStartDate()), 
        oldLesson.getStartDate()));

    newLesson.setEndDate(prompt.inputDate(String.format("종료 일(%s) ? ", oldLesson.getEndDate()), 
        oldLesson.getEndDate()));

    newLesson.setTotalHours(prompt.inputInt(String.format("총 수업시간(%d) ? ", oldLesson.getTotalHours()), 
        oldLesson.getTotalHours()));

    newLesson.setDayHours(prompt.inputInt(String.format("일 수업시간(%d) ? ", oldLesson.getDayHours()), 
        oldLesson.getDayHours()));
    
    /*
    int oldValue = oldLesson.getDayHours();
    String label = "일수업시간(" + oldValue + ")? ";
    int newValue = inputInt(label, oldValue);
    newLesson.setDayHours(newValue);
     */

    if (oldLesson.equals(newLesson)) {
      //기존의 값과 새로운 값이 동일할떄 
      System.out.println("수업 변경을 취소했습니다.");
      
    } else {
      //기존의 값과 새로운 값이 다를 때 
      this.lessonList.set(index, newLesson);
      System.out.println("수업을 변경했습니다." );
      // 이 제어문을 사용하면 엔터를 사용할 시에는 공백이 생겨서  두 인스턴스의 값이 달라지게 된다 
      // 그렇기 때문에 상속받은 변수를 재정의하기 하기 위해서 오버라이딩이 필요하게 된다
      // 즉 입력받은 값을 한번에 모두 입력 받고 상속받은 서브 클래스에서 재정의 한다
    }
  } 


  public void deleteLesson() {
    int index = indexOfLesson(prompt.inputInt("번호? "));

    if (index == -1) 
      System.out.println("수업이 유효하지 않습니다");

    this.lessonList.remove(index);
    System.out.println("수업을 변경했습니다.");
  }

  private int indexOfLesson(int no) {
    for (int i = 0 ; i < this.lessonList.size() ; i++ ) {
      if (this.lessonList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

 
}
