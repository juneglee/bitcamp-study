package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;


public class LessonHandler {

  LessonList lessonList;
  Scanner input;

  
  public LessonHandler(Scanner input){
    this.input = input;
    lessonList = new LessonList();
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

    this.lessonList.add(lesson);
    System.out.println("저장하였습니다");
  }
  public void listLesson() {
    Lesson[] lessons = this.lessonList.toArray();
    for (int i = 0; i < lessonList.size; i++) {
      Lesson l = lessonList.list[i];
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간"
          + "\n일수업시간: %d 시간\n조회수: %d\n ",
          l.getNo(), l.getTitle(), l.getDescription(), l.getStartDate(), 
          l.getEndDate(),l.getTotalHours(),l.getDayHours(),l.getViewCount());
    }
  }

}
