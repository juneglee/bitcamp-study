package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;


public class LessonHandler {

  ArrayList<Lesson> lessonList;
  Scanner input;


  public LessonHandler(Scanner input){
    this.input = input;
    this.lessonList = new ArrayList<>();
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(input.nextInt());
    input.nextLine(); 

    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine()); 

    System.out.print("설명? ");
    lesson.setDescription(input.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(input.next()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(input.nextInt());

    System.out.print("일수업시간? ");
    lesson.setDayHours(input.nextInt());
    input.nextLine(); 

    lessonList.add(lesson);
    System.out.println("저장하였습니다");
  }

  public void listLesson() {
    // 수업 객체 목록을 복사 받을 배열을 준비하고, toArray()를 실행한다.
    // toArray()의 리턴 값은 파라미터로 넘겨준 배열의 주소이다.

    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]);
    // this.lessonList.toArray(Lesson[].class);
    for (Lesson l : arr) {
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간"
          + "\n일수업시간: %d 시간\n조회수: %d\n ",
          l.getNo(), l.getTitle(), l.getDescription(), l.getStartDate(), 
          l.getEndDate(),l.getTotalHours(),l.getDayHours(),l.getViewCount());
    }
  }

  public void detailLesson() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfLesson(no);

    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다");
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
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfLesson(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 수업이 없습니다.");
      return;
    }
    
    Lesson oldLesson = this.lessonList.get(index);
    
    boolean changed = false;
    String inputStr =null;
    Lesson newLesson = new Lesson();
    
    newLesson.setNo(oldLesson.getNo());
    //해당 no를 받는 셋터값을 주지 않으면 번호의 값이 내려간다 
    
    System.out.printf("수업명(%s) ? ", oldLesson.getTitle());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setTitle(oldLesson.getTitle());
      // old에서 꺼내서 new로 집어 넣어라 
    } else {
      newLesson.setTitle(inputStr);
      changed = true;
    }
    System.out.printf("설명(%s) ? ", oldLesson.getDescription());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setDescription(oldLesson.getDescription());
    } else {
      newLesson.setDescription(inputStr);
      changed = true;
    }
    
    System.out.printf("시작 기간 (%s)? ", oldLesson.getStartDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setStartDate(oldLesson.getStartDate());
    } else {
      newLesson.setStartDate(Date.valueOf(inputStr));
      changed = true;
    }
    
    System.out.printf("종료 기간 (%s)? ", oldLesson.getEndDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setEndDate(oldLesson.getEndDate());
    } else {
      newLesson.setEndDate(Date.valueOf(inputStr));
      changed = true;
    }
    
    System.out.printf("총 수업시간(%d) ? ", oldLesson.getTotalHours());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setTotalHours(oldLesson.getTotalHours());
    } else {
      newLesson.setTotalHours(Integer.parseInt(inputStr));
      // 문자로 정의 된 것을 숫자 (정수)로 변경해준다
      changed = true;
    }
    System.out.printf("일 수업시간(%d) ? ", oldLesson.getDayHours());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setDayHours(oldLesson.getDayHours());
    } else {
      newLesson.setDayHours(Integer.parseInt(inputStr));
      changed = true;
    }

    if (changed) {
      this.lessonList.set(index, newLesson);
      System.out.println("수업을 변경했습니다.");
    } else {
      System.out.println("수업 변경을 취소했습니다.");
    }
  } 


  public void deleteLesson() {
    System.out.print("번호 ? ");
    int no = input.nextInt();
    input.nextLine();
    
    int index = indexOfLesson(no);
    
    Lesson lesson = this.lessonList.get(index);

    if (index == -1) 
      System.out.println("수업이 유효하지 않습니다");

    this.lessonList.remove(index);
    System.out.println(" 수업을 변경했습니다.");
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
