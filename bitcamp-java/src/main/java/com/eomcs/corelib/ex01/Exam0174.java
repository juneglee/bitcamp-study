// Object 클래스 - clone() : deep copy
package com.eomcs.corelib.ex01;
 
public class Exam0174 {
  
  static class Engine implements Cloneable {
    int cc;
    int valve;
    
    public Engine(int cc, int valve) {
      this.cc = cc;
      this.valve = valve;
    }
    
    @Override
    public String toString() {
      return "Engine [cc=" + cc + ", valve=" + valve + "]";
    }

    @Override
    public Engine clone() throws CloneNotSupportedException {
      return (Engine) super.clone();
    }
  }
  
  static class Car implements Cloneable {
    String maker;
    String name;
    Engine engine;
    
    public Car(String maker, String name, Engine engine) {
      this.maker = maker;
      this.name = name;
      this.engine = engine;
    }

    @Override
    public String toString() {
      return "Car [maker=" + maker + ", name=" + name + ", engine=" + engine + "]";
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
      // deep copy
      // => 포함하고 있는 하위 객체에 대한 복제를 수행하려면 다음과 같이 
      //    개발자가 직접 하위 객체를 복제하는 코드를 작성해야 한다.
      // 
      Car copy = (Car) super.clone(); //shallow
      copy.engine = this.engine.clone(); 
      // 인스턴스의 따로 복제하여, 그 주소를 shallow copy의 해당 상위 객체에 주소를 넘겨준다  
      return copy;
    }
  }
  
  public static void main(String[] args) throws Exception {
    Engine engine = new Engine(3000, 16);
    Car car = new Car("비트자동차", "비트비트", engine);
    
    // 자동차 복제
    Car car2 = car.clone();
    
    System.out.println(car == car2);
    System.out.println(car);
    System.out.println(car2);
    System.out.println(car.engine == car2.engine);
    
  }
}







