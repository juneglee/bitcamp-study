package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.sql.DataSource;

public class PhotoBoardDaoImpl implements PhotoBoardDao {
  DataSource dataSource;

  public PhotoBoardDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }


  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {

    try (Connection con = dataSource.getConnection(); //
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("insert into lms_photo(titl,lesson_id) values('" //
          + photoBoard.getTitle() + "'," + photoBoard.getLesson().getNo() + ")",
          Statement.RETURN_GENERATED_KEYS // insert 한 후에 PK값 리턴 받기
      );
      // auto-increment PK 값을 꺼내기 위한 준비를 한다
      try (ResultSet generResultSet = stmt.getGeneratedKeys()) {
        // PK 컬럼의 값을 가져온다
        generResultSet.next();
        // 가져온 PK 컬럼의 값을 PhotoBoard 객체에 꺼구로 담는다
        photoBoard.setNo(generResultSet.getInt(1));
      }
      return result;
    }
  }

  @Override
  public List<PhotoBoard> findAllByLessonNo(int lessonNo) throws Exception {
    try (Connection con = dataSource.getConnection(); //
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery( //
            "select photo_id, titl, cdt, vw_cnt, lesson_id " //
                + " from lms_photo" //
                + " where lesson_id=" + lessonNo //
                + " order by photo_id desc")) {

      ArrayList<PhotoBoard> list = new ArrayList<>();

      while (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();

        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setCreateDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        list.add(photoBoard);
      }

      return list;
    }
  }

  @Override
  public PhotoBoard findByNo(int no) throws Exception {
    try (Connection con = dataSource.getConnection(); //
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( //
            "  select" //
                + " p.photo_id," //
                + " p.titl,"//
                + " p.cdt,"//
                + " p.vw_cnt,"//
                + " l.lesson_id,"//
                + " l.titl lesson_titl"//
                + " from lms_photo p"//
                + " inner join lms_lesson l on p.lesson_id=l.lesson_id"//
                + " where photo_id=" + no)) {

      if (rs.next()) {

        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setCreateDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        lesson.setTitle(rs.getString("lesson_titl"));

        photoBoard.setLesson(lesson);

        return photoBoard;

      } else {
        return null;
      }
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {
    try (Connection con = dataSource.getConnection(); //
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate( //
          "update lms_photo set titl = '" //
              + photoBoard.getTitle() //
              + "' where photo_id=" + photoBoard.getNo());

      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = dataSource.getConnection(); //
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate( //
          "delete from lms_photo " //
              + " where photo_id=" + no);

      return result;
    }
  }
}
