// java.util.ArrayList의 contains()의 동작 원리 확인
package com.eomcs.corelib.ex03;

import java.util.ArrayList;

public class Exam0230 {
  // equals()를 오버라이딩 한다면?
  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return String.format("[%s,%d]", this.name, this.age);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      if (age != other.age)
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      return true;
    }


  }

  public static void main(String[] args) {
    Member s1 = new Member("홍길동", 20);
    Member s2 = new Member("임꺽정", 30);
    Member s3 = new Member("유관순", 16);
    Member s4 = new Member("임꺽정", 30);

    ArrayList list = new ArrayList();
    list.add(s1);
    list.add(s2);
    list.add(s3);
    print(list);

    System.out.println(list.contains(s4)); // true
    // Member 클래스는 equals()를 오버라이딩 했다.
    // 따라서 인스턴스가 다르더라도 Member의 name과 age 값이 같다면
    // equals()의 검사 결과가 true이기 때문에,
    // contains()는 같은 객체로 판단할 것이다.

    // 결론
    // arrayList에 객체를 보관한 후 같은 값을 갖는 객체가 있는지 확인하기 위해
    // contains() 호출할 때 주의해라
    // => contains() 각 객체에 대해 equals()를 호출하여 비교한다
    // 따라서 equals를 오버라이딩 하지 않을 경우,
    // contains의 결과를 원하는대로 나오지 않을 것이다

    // 즉. 모든 도메인 클래스는 equals()와 hashCode()를 오버라딩해라
    // 근데 hashcode()는 왜 오버라이딩하나용?
    // => hashset과 hashmap을 사용할때 hashcode() 메서드를 사용하기 때문에


  }

  static void print(ArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }
}


