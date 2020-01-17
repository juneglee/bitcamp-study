// non - static nested class = inner class 응용
package com.eomcs.oop.ex11.a;

import java.util.ArrayList;
import java.util.List;

public class Exam0240 {
  public static void main(final String[] args) {
    final Musics m1 = new Musics();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");
    // Musics.Player p1 = new Musics.Player();
    final Musics.Player p1 = m1.new Player();
    final Musics.Player p2 = m1.new Player();

    p1.play();
    p2.play();

    final Musics m2 = new Musics();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");
    final Musics.Player p3 = m2.new Player();

    p3.play();
  }
}

// 바깥 클래스에 종속되어 일을 할때 non static nested class로 만들어라


class Musics { // 클래스를 여러개 사용할 때는 public 을 사용하지 않는다

  class Player {
    public void play() {
      // 이 메서드가 호출되려면, player 객체가 존재해야 한다
      // player 객체가 존재하려면, music 객체가 존재해야 한다
      // E따라서 이 메서드가 호출 될 때는 이미 music 객체가 존재한 상태이다
      // music 객체로 player 객체를 만ㄷ는 것이다
      // 따라서 inner class 의 객체는 항상 자신을 만든 객체의 주소를 보관한다
      // => 바깥_클래스명.this 내장 변수에 보관한다
      // => player를 만든 musics 객체를 사용하고 싶다면 바깥_클래스명.this 변수를 이용하라
      // for (int i = 0 ; i < Musics.this.songs.size() ; i ++) {
      // System.out.println(Musics.this.songs.get(i));
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

  public void delete(final int index) {
    songs.remove(index);
  }


}

