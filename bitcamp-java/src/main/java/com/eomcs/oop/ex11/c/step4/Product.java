package com.eomcs.oop.ex11.c.step4;

public class Product {
  // 문자열 대신 상수로 사용하면 메모리의 사용량을 줄일 수 있으며,
  // 실무에서는 일반적으로 정수로 처리하여 사용한다
  // 이때 상수의 이름을 대문자로 사용
  public static final int COMPUTER_CPU = 1;
  public static final int COMPUTER_VGA = 2;
  public static final int COMPUTER_RAM = 3;
  public static final int COMPUTER_MOUSE = 4;
  public static final int COMPUTER_KEYBOARD = 5;

  public static final int APPLIANCE_TV = 10;
  public static final int APPLIANCE_AUDIO = 11;
  public static final int APPLIANCE_DVD = 12;
  public static final int APPLIANCE_VACUUMCLEANER = 13;

  public static final int BOOK_POET = 100;
  public static final int BOOK_NOVEL = 101;
  public static final int BOOK_ESSAY = 102;
  public static final int BOOK_IT = 103;
  public static final int BOOK_LANG = 104;

  int category;
  String name;
  String maker;
  int price;
}
