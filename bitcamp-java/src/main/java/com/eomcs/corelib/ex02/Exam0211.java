// Wrapper 클래스 - 종류
package com.eomcs.corelib.ex02;

public class Exam0211 {
  public static void main(String[] args) {
    // new 명령을 사용하여 Integer객체를 만들면
    // 무조건 새 인스턴스를 생성한다
    Integer i1 = new Integer(127);
    Integer i2 = new Integer(127);
    System.out.println(i1 == i2);// false

    // -128 ~ 127 범위로 valueOf()를 호출하면
    // 내부 메모리 (cache)에 보관한다
    // -128 ~ 127 범위는 자주 사용되는 수이기 때문에
    // 이 범위의 수를 가지고 integer 객체를 만들면
    // 그래서 같은 값의 객체가 여러 개 생성되지 않도록 한다
    Integer i3 = Integer.valueOf(127);
    Integer i4 = Integer.valueOf(127);
    System.out.println(i3 == i4); // true

    // -128 ~ 127 범위 이외의 수는 새로운 인스턴스를 생성한다
    Integer i5 = Integer.valueOf(128);
    Integer i6 = Integer.valueOf(128);
    System.out.println(i5 == i6); // false

    // 결론
    // wrapper 객체를 사용하여 비교할때 ==를 사용하면 -128 ~ 127 범위 이외의
    // 값은 새로운 인스턴스로 비교하기 때문에 동일한 값이 나오지 않는다
    // 그러므로 equals()를 사용하여 비교하는 것이 바람직하다
  }
}

