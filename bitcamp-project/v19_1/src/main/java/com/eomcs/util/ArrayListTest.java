package com.eomcs.util;

public class ArrayListTest {
  public static void main(String[] args) {
    ArrayList<String> a1 = new ArrayList<>();

    a1.add("aaa");
    a1.add("bbb");
    a1.add("ccc");
    a1.add("ddd");
    a1.add("eee");
    a1.add("fff");
    // a1.add(new Member()); //컴파일 오류
    // 제네릭을 사용하면 String으로 지정해기 때문에 지정한 것 이외에 다른것을 사용할 수 없다
    // 즉 형변환을 하지 않아도 된다 

    System.out.println(a1.get(-1));
    System.out.println(a1.get(6));

    String oldValue = a1.set(0, "xxx");
    System.out.printf("%s ==> %s\n", oldValue, a1.get(0));

    a1.set(-1, "yyy");
    a1.set(6, "zzz");

    System.out.println("---------------");

    print(a1);

    a1.remove(-1);

    oldValue = a1.remove(5);
    System.out.printf("삭제 전(%s) ==> 삭제 후(%s)\n", oldValue, a1.get(0));

    System.out.println("---------------");

    print(a1);
  }

  static void print(ArrayList<String> arr) {
    String[] list = arr.toArray(new String[] {});//빈배열이라도 넘겨야 한다 
    for (String e : list) {
      System.out.println(e);
    }
  }
}

