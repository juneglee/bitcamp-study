package com.eomcs.basic.ex07;

//# 메서드 : 스택 메모리 응용 I
//
public class Exam0440 {

  static int m1(int value) { // 파라미터(parameter= value)도 로컬변수이다
    int r1 = m2(value);
    int r2 = m3(value);
    return r1 + r2;
  }

  static int m2(int value) { //리턴후에는 stack에서 제거
    return value + 100;
  }

  static int m3(int value) { //리턴후에는 stack에서 제거
    return value + 200;
  }

  public static void main(String[] args) {
    int r = m1(5);
    System.out.println(r);
  }
}

// 메서드 호출은 stack방식으로 진행 LIFO

// JVM Stack 메모리의 사용
// 0) 시작
// 1) main()
// 2) main() => m1()
// 3) main() => m1() => m2()
// 4) main() => m1()
// 5) main() => m1() => m3()
// 6) main() => m1()
// 7) main()
// 8) 종료!