# 37_4 - Application Server 구조로 변경: 검색 기능 추가

## 학습목표

- Application Server 아키텍처의 구성과 특징을 이해한다.
- 통신 프로토콜 규칙에 따라 동작하는 서버를 만들 수 있다.
- 새 기능을 추가하더라도 클라이언트 앱을 재 배포할 필요가 없음을 안다

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/MemberDao.java 변경
- src/main/java/com/eomcs/lms/dao/mariadb/MemberDaoImpl.java 변경
- src/main/java/com/eomcs/lms/servlet/MemberSerachervlet.java 변경
- src/main/java/com/eomcs/lms/ServerApp.java 변경

## 실습  

### 훈련1: 회원 검색 기능을 추가하라

