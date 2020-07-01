package com.eomcs.lms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// 서브 클래스에게 공통 필드나 메서드를 상속해주는 역학을 하기 때문에
// => abstract
// 서브 클래스에게 상속해주는 메서드중에서 indexof()처럼 구현되지 안흔 메서드가 있기때문에
// => abstract
public abstract class AbstractObjectFileDao<T> {
  // board.member.lesson 모두 사용하기 위해서 <T>타입 사용
  protected String filename;
  protected List<T> list;

  // 담을 공간을 생성자를 통해서 받겠다
  public AbstractObjectFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();// 객체가 생성될때 로딩하겠다
  }

  @SuppressWarnings("unchecked")
  protected void loadData() {
    File file = new File(filename);

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      list = (List<T>) in.readObject();
      System.out.printf("총 %d 개의 객체를 로딩했습니다.\n", list.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  protected void saveData() {
    File file = new File(filename);

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.reset(); // 기존의 직렬화 대이터를 초기화 시킨후 다시 직렬화를 수행한다
      out.writeObject(list);
      System.out.printf("총 %d 개의 객체를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }

  protected abstract <K> int indexOf(K key);
  // <K>의 선언은 두가지 이다
  // 사용할 곳에 바로 저장하는 것과, class에서 선언하는 방법 <T, K>

  // 서브 클래스들의 공통 메서드이기
  // => 수퍼 클래스에 정의한다
  // 서브 클래스에 접근할 수 있어야 하기 때문에
  // => protected // 서브 클래스마다 구현 방법이 다르기 때문에
  // => abstract (수퍼클래스에서 구현할 수도 없고, 구현해 봐야 소용없다.)
  // 서브 클래스에서 반드시 구현해야할 메서드이기 때문에
  // => abstract

  // getNo은 현재의 클래스들에는 있지만, // 만약 문자로 된 클래스가 있다면 찾을 수 없다 return i; } } return -1;

}
