package com.eomcs.util;

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("fff");
    list.add("ggg");
    
    //list.add(7, "xxx");
    
    //list.remove(6);
    
    System.out.println(list.set(-1, "xxx"));
    System.out.println();
    
    print(list);
    
    //System.out.println(list.get(-1));
    //System.out.println(list.get(7)); 
    //7개 이지만 값이 벗어나게 된다

  }
  
  static void print (LinkedList<String> list) {
    //String[] arr = list.toArray(new String[0]);
    String[] arr = new String[list.size];
    list.toArray(arr);
    
    for (String  value : arr) {
      System.out.println(value);
    }
  }
}
