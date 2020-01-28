# 28_3 - 파일 포맷으로 JSON 도입하기 
## 학습 목표 

- 외부 라이브러리를 가져와서 프로젝트에 적용할 수 있다 
- JSON 포맷의 사용 이점을 이해한다
- Google JSON 라이브러리를 사용할 수 있다 

JSON 데이터 포맷 특징 
- 문자열로 데이터를 표현한다.
- '[{프로퍼티 : 값, ...}, {프로퍼티 : 값, ...}, ...]' 방식으로 저장한다. 
- 바이너리 방식에 비해 데이터가 커지는 문제가 있지만, 
  모든 프로그래밍 언어에서 다룰 수 있다는 장점이 있다 
- 그래서 이기종 플랫폼(OS, 프로그래밍 언어 등 ) 간에 데이터를 교환할 때 많이 사용한다 
 
## 실습 소스 및 결과
- build.gradle 변경
- src/main/java/com/eomcs/lms/App.java 추가

## 실습   

### 훈련 1 : Gradle 스크립트 파일 (build.gradle) 에  Google JSON 라이브러리를 추가하라 

- mvnrepository.com에서 라이브러리 검색
  - json.org 사이트에서 자바 라이브러리 확인
  - 'gson' 키워드로 검색
- build.gradle 을 편집한다.
  - 의존 라이브러리 블록(dependencies{})에 gson 정보를 추가한다.
- 이클립스 설정 파일을 갱신
  - 'gradle eclipse'를 실행
  - 이클립스를 해당 프로젝트를 refresh를 한다 
  - Referenced Libraaries 노드에서 gson 라이브러리 파일이 추가된 것을 확인한다 
  
### 훈련 2 : 게시물 데이터를 저장할 때 json 형식으로 사용하라 

- App.java
  - saveBaordData()를 변경한다
  - loadBaordData()를 변경한다
  
### 훈련 3 : 회원 데이터를 저장할 때 json 형식으로 사용하라 

- App.java
  - saveBaoData()를 변경한다
  - loadBaordData()를 변경한다
  
### 훈련 4 : 수업 데이터를 저장할 때 json 형식으로 사용하라 

- App.java
  - saveLessonData()를 변경한다
  - loadLessonData()를 변경한다
  
### 훈련 5 : Arrays의 메서드를 활용하여 배열을 List 객체로 만들어라 

- App.java
  - 