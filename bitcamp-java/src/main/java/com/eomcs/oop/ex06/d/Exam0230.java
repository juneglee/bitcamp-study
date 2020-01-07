// Object 클래스의 메서드를 오버라이딩 하기 - hashCode()
package com.eomcs.oop.ex06.d;

public class Exam0230 {

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

    // 인스턴스가 다르더라도 값이 같으면 
    // 같은 해시 값을 리턴하도록 오버라이딩 해보자!
    @Override
    public int hashCode() {
      // 가장 간단한 방법은 모든 값을 문자열로 만들어 붙인 다음에
      // String 클래스에 있는 hashCode()를 사용하는 것이다.
      // 왜? String 클래스에 있는 hashCode()는 문자열이 같은 경우 
      //     같은 해시 값을 리턴하도록 이미 오버라이딩 되어 있기 때문이다.
      String value = String.format("%s,%d,%d,%d,%d,%.1f", 
          this.name, this.kor, this.eng, this.math,
          this.sum, this.aver);
      return value.hashCode();
    }
  }

  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 100, 100);
    Score s2 = new Score("홍길동", 100, 100, 100);
    Score s3 = new Score("홍길동", 100, 100, 99);
    Score s4 = new Score("홍길동", 99, 100, 100);

    // 인스턴스는 모두 다르다
    System.out.println(s1 == s2);
    System.out.println(s1 == s3);
    System.out.println(s1 == s4);
    System.out.println(s2 == s3);
    System.out.println(s2 == s4);
    System.out.println(s3 == s4);

    // 인스턴스는 다르지만 데이터가 같아서 해쉬코드는 동일하다
    System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
    System.out.println(s1.hashCode() == s2.hashCode());
    // 문자열이 같은 문자열인지 확인할때 해쉬 코드를 오버라이딩하여 사용한다 
  }
}

