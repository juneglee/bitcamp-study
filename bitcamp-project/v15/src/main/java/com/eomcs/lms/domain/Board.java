package com.eomcs.lms.domain;
//VO(=value object) or domain의 폴도로 사용한다 
import java.sql.Date;

public class Board { 
  private int no; //공개하고자할때는 public을 각각 붙인다
  private String title;
  private Date date;
  private int viewCount;
  private String writer;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  
  
}
