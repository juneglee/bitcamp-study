# 37_1 - Application Server 구조로 변경하기 : 규칙1에 따라 통신하는 클라이언트 만들기  

## 학습목표

- 한 개의 DB 커넥션을 여러 DAO 에서 공유할 수 있다

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/mariadb/BoardDaoImpl.java 생성
- src/main/java/com/eomcs/lms/dao/mariadb/LessonDaoImpl.java 생성
- src/main/java/com/eomcs/lms/dao/mariadb/MemberDaoImpl.java 생성
- src/main/java/com/eomcs/lms/ClientApp.java 변경

## 실습  

### 훈련1: 한 개의 DB 커넥션 객체를 DAO 모두가 공유하여 사용하라  
- com.eomcs.lms.ClientApp 변경
- com.eomcs.lms.dao.mariadb.XxxDaoImpl 변경

