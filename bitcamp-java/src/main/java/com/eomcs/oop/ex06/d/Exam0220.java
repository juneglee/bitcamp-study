// Object 클래스의 메서드를 오버라이딩 하기 - hashCode()
package com.eomcs.oop.ex06.d;

public class Exam0220 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.sum = kor + eng + math;
      this.aver = this.sum / 3f;
    }

    // 인스턴스가 다르더라도 값이 같으면 같은 해시 값을 리턴하도록 오버라이딩 해보자!
    @Override
    public int hashCode() {
      return 1000;
      /*
          // 가장 간단한 방법은 모든 값을 문자열로 만들어 붙인 다음에
            // String 클래스에 있는 hashCode()를 사용하는 것이다.
            // 왜? String 클래스에 있는 hashCode()는 문자열이 같은 경우 
            //     같은 해시 값을 리턴하도록 이미 오버라이딩 되어 있기 때문이다.
            String value = String.format("%s,%d,%d,%d,%d,%.1f", 
                    this.name, this.kor, this.eng, this.math,
                    this.sum, this.aver);
            return value.hashCode(); */
    }
  }

  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 100, 100);
    Score s2 = new Score("홍길동", 100, 100, 100);
    Score s3 = new Score("임꺽정", 90, 80, 70);


    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
    System.out.println(s3.hashCode());

    // 해쉬코드 : 데이터를 식별할때 사용하는 고유 아이디 이다.
    // 보통 데이터을 특별한 공식(ex: MD4. MD5, SHA -1, SHA-256 등)에 대입하여  
    // 계산해서 나온 정수 값을 해쉬값으로 사용한다
    // 해시코르를 지문과 같다고 해서 '디지털 지문'이라고 부른다 
    // 해쉬 코드를 오버라이딩 할때?
    // 인스턴스가 다르더라도 같은 값을 갖는 경우 같은 값으로 취급하기 위해 이 메서드를 재정의한다
    // 따라서 위의 예처럼 데이터가 같은지 따지지도 않고 
    // 모든 인스턴스에 대해 같은 해쉬 코드를 리턴하는 것은 아무런 의미 짓을 하는 것이다 
  }
}






