// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0112 {

  public static void main(String[] args) {
    Vehicle v = new Vehicle();
    Bike b = new Bike();
    Car c = new Car();
    Sedan s = new Sedan();
    Truck t = new Truck();


    Bike b2 = null;

    // 하위 클래스의 레퍼런스로 상위 클래스의 인스턴스로 가리킬 수 없다
    //why
    // 상위 클래스의 인스턴스에는 하위 인스턴스의 변수가 없기 때문이다.
    b2 = v; // 컴파일 오류!

    Vehicle v2 = null;
        v2 = b;

        // 만약 위의 코드가 가능하다면, v2에 대해서 engine가능해야 한다
        // 다음과 같이 Bike 레퍼런스로 Bike 인스턴스 변수를 사용하려 할 것이다.

        // 그러나 b2가  bike의 인스턴스 변수가 아니기 때문에 Bike 엔진 변수를 사용할 수 없다
        // Vehicle 실제 가리키는 것은 인스턴스를 가리킨다.

        // 그래서 개발자가 레퍼런스를 통해 존재하지 않는 인스턴스 멤버를 사용할까봐.
        // 이것을 미리 방지하려고 컴파일 단계에서 이런 사용을 막는 것이다.

        b2.engine = "1"; //컴파일 오류!

  }

}
