// 스레드 재사용 - 4단계) wait()/notify() 사용
// 일을 시키지도 않았는데 계속 일을 한다
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0140 {

  public static void main(String[] args) {
    class MyThread extends Thread {
      int count;

      public void setCount(int count) {
        this.count = count;
        synchronized (this) {
          notify();
          // 이 객체에 사용하는 스레드에게
          // 이제 기다림을 끝내고 작업을 시작하라고 알린다
          // notify() 도 동기화 영역에서 호출해야 한다
          // 안그러면 예외가 발생
        }
      }

      @Override
      public void run() {
        // 어떤 객체를 대상으로 여러 스레드가 동시에 사용하지 못하게 할 것인지
        // 지정해야 한다
        // 동기화 블록 문법
        // synchronized(접근대상) {...]
        synchronized (this) {
          System.out.println("스레드 시작했음!");
          try {
            while (true) {
              System.out.println("스레드 대기중...");
              wait();
              // 스레드를 시작하자 마자 일단 작업 지시를 기다리게 한다
              // wait()는 반드시 동기화 블록(synchronized로 선언된 블록이나 메서드) 안에서
              // 호출해야 한다

              // notify()를 통해 기다림이 끝났다는 것을 알림 받아야 한다
              System.out.println("카운트 시작");
              for (int i = count; i > 0; i--) {
                System.out.println("==>" + i);
                Thread.sleep(1000);

              }
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }

    MyThread t = new MyThread();

    t.start();

    Scanner keyScan = new Scanner(System.in);
    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();
      if (str.equals("quit")) {
        break;
      }
      int count = Integer.parseInt(str);
      t.setCount(count);
    }
    System.out.println(" main 스레드 종료!");
    keyScan.close();
  }
}


