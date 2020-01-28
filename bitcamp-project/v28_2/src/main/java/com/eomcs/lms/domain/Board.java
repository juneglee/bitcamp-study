package com.eomcs.lms.domain;

// VO(=value object) or domain의 폴도로 사용한다
import java.sql.Date;

public class Board {
  private int no; // 공개하고자할때는 public을 각각 붙인다
  private String title;
  private Date date;
  private int viewCount;
  private String writer;


  // csv 포맷 ;
  // - 번호, 제목, 등록일, 조회수, 등록자
  public static Board valueOf(String csv) {
    String[] data = csv.split(",");

    Board board = new Board();
    board.setNo(Integer.parseInt(data[0]));
    board.setTitle(data[1]);
    board.setDate(Date.valueOf(data[2]));
    board.setViewCount(Integer.parseInt(data[3]));
    board.setWriter(data[4]);

    return board;
  }

  // 특정 작업을 수행하기 위해서static을 사용하지 않는다
  public String toCSVString() {
    return String.format("%d,%s,%s,%d,%s", this.getNo(), this.getTitle(), this.getDate(),
        this.getViewCount(), this.getWriter());
    // 순수한 문자열이기 때문에 \n 삭제
    // 내부에서 문자열을 만들어서 리턴한다

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + no;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + viewCount;
    result = prime * result + ((writer == null) ? 0 : writer.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Board other = (Board) obj;
    if (no != other.no)
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (viewCount != other.viewCount)
      return false;
    if (writer == null) {
      if (other.writer != null)
        return false;
    } else if (!writer.equals(other.writer))
      return false;
    return true;
  }

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
