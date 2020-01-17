// non - static nested class = inner class 응용2
package com.eomcs.oop.ex11.a;

import java.util.ArrayList;
import java.util.List;

public class Exam0241 {
  public static void main(final String[] args) {
    final Musics2 m1 = new Musics2();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");

    final Musics2.Player p1 = m1.createPlayer(); // <<<
    final Musics2.Player p2 = m1.createPlayer(); // <<<

    p1.play();
    p2.play();

    final Musics2 m2 = new Musics2();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");
    final Musics2.Player p3 = m2.new Player(); // 이전 방법

    p3.play();
  }
}


// 실무에서는 inner class를 사용할 때
// 클래스 내부에 player에 종속되어있는 메서드를 만들어 리턴한다
class Musics2 {
  class Player {
    public void play() {
      for (final String song : songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------");
    }
  }

  List<String> songs = new ArrayList<>();

  public void add(final String song) {
    songs.add(song);
  }

  public Player createPlayer() { // <<<<
    return new Player();
  }

  public void delete(final int index) {
    songs.remove(index);
  }
}

