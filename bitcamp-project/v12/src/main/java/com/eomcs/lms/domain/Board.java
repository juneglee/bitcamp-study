package com.eomcs.lms.domain;
//VO(=value object) or domain의 폴도로 사용한다 
import java.sql.Date;

public class Board { 
  public int no; //공개하고자할때는 public을 각각 붙인다
  public String title;
  public Date date;
  public int viewCount;
  public String writer;
}
