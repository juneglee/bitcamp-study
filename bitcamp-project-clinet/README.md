# 33 - 리팩토링 : 서버 연결 부분을 캡슐화하기 

## 학습목표

- 리팩토링의 목적

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/proxy/worker.java 
- src/main/java/com/eomcs/lms/ClientApp.java 변경

## 실습
### 훈련 1 : `Stateful' 통신 방식을 `Stateless` 통신 방식으로 바꿔라 

- com.eomcs.lms.ServerApp을 변경한다 
  - 