package com.eomcs.spring.ioc.ex12.d;

import java.util.List;
import java.util.Map;
import com.eomcs.spring.ioc.ex12.Board;

// 이 인터페이스의 구현체를 mybatis가 자동으로 생성하여
// Spring IoC 컨테이너에 등록할 것이다.
// 그럴려면 메서드를 만들 때 몇가지 규칙을 따라야 한다.
// 1) 맵퍼 파일의 namespace와 인터페이스명(패키지 포함)과 같아야 한다.
// 예) <mapper namespace="com.eomcs.spring.ioc.ex12.d.BoardDao">
// 2) 메서드의 이름과 SQL 아이디가 같아야 한다.
// 3) 메서드의 리턴 타입과 SQL 맵퍼 파일의
// resultType 또는 resultMap이 같아야 한다.
// insert, update, delete일 경우 리턴 값이 void 또는 int가 될 수 있다.
// 4) SQL 맵퍼는 파라미터 값을 한 개만 받기 때문에
// DAO 인터페이스의 메서드도 한 개의 파라미터를 가져해야 한다.
//

// BoardDao는 Mybatis 에서 proxy를 이용하여 자동으로 생성하여
// spring IoC 컨테이너에 등록한다
public interface BoardDao {
  List<Board> selectList(Map<String, Object> map);

  int insert(Board board);

  int delete(int no);
}


