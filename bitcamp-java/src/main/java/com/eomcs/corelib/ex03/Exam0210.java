// contains() 와 equals()의 관계
package com.eomcs.corelib.ex03;

public class Exam0210 {
  public static void main(String[] args) {
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    String s4 = new String("bbb"); // s2 != s4

    ArrayList list = new ArrayList();
    list.add(s1);
    list.add(s2);
    list.add(s3);
    print(list);

    // contains() 가 값을 비교할 때는
    // hashCode() 같은지 비교한다
    // 또한 equals()의 결과가 true인지 비교한다
    // 결론 !
    // String 클래스의 경우 equals()를 오버라이딩 했기 때문에
    // 서로 다른 개체 (s2와 s4)라 하더라도 같은 객체로 간주하다
    System.out.println(list.contains(s4)); // true
    // list 안에서 s4와 같은 값이 있는지 비교한다
  }

  static void print(ArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }
}
