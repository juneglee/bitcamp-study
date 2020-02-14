// 멀티 스레드 재사용 - pooling 기법을 이용하여 생성된 객체를 재활용하기
package com.eomcs.concurrent.ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam0210 {

  static class MyThread extends Thread {
    ThreadPool pool;
    int count;

    public MyThread(String name, ThreadPool pool) {
      super(name);
      this.pool = pool;
    }

    public void setCount(int count) {
      this.count = count;
      synchronized (this) {
        notify();
      }
    }

    @Override
    public void run() {
      synchronized (this) {
        try {
          while (true) {
            // 가다림
            wait();
            // 알림 오면 실행한다
            for (int i = count; i > 0; i--) {
              System.out.printf("[%s] %d \n", getName(), i);
              Thread.sleep(2000);
            }
            // 스레드의 작업이 끝났으면 스레드 풀로 돌아가야 한다
            pool.add(this);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  interface ThreadPool {
    Thread get();

    void add(Thread obj);
  }

  static class MyThreadPool implements ThreadPool {
    ArrayList<MyThread> list = new ArrayList<>();

    public MyThreadPool() {
      MyThread t1 = new MyThread("1번 스레드 =>", this);
      t1.start();
      list.add(t1);

      MyThread t2 = new MyThread("2번 스레드 ==>", this);
      t2.start();
      list.add(t2);

      MyThread t3 = new MyThread("3번 스레드 ===>", this);
      t3.start();
      list.add(t3);
    }

    @Override
    public MyThread get() {
      if (list.size() > 0) {
        return list.remove(0);
      }
      return null;
    }

    // 스레드 다 쓴 후에는 다시 스레드 풀에 돌려 준다
    @Override
    public void add(Thread t) {
      this.add(t);
    }
  }

  public static void main(String[] args) {

    // 스레드 풀에서 한 개의 스레드를 꺼낸다


    // 스레드 풀 준비
    MyThreadPool threadPool = new MyThreadPool();


    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();
      if (str.equals("quit")) {
        break;
      }
      int count = Integer.parseInt(str);

      MyThread t = threadPool.get();
      if (t == null) {
        System.out.println("남는 스레드가 없습니다");
        continue;
      }
      // 스레드의 카운트 설정
      t.setCount(count);
    }
    System.out.println(" main 스레드 종료!");
    keyScan.close();
  }
}


