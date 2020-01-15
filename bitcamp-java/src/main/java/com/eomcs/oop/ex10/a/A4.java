// 추상 클래스와 추상 메서드 II
package com.eomcs.oop.ex10.a;

public abstract class A4 {
    // 추상 클래스의 용도는 서브 클래스들이 가져야할 공통 변수나 메서드를 제공하는 것이다.
    // 그래서 일반 변수나 메서드를 정의할 수 있다.
    public static int value1;
    private int value2;
    
    static void m0() {}
    public void m1() {}
    private void m2() {}
    
    // 추상 클래스는 추상 메서드도 가질 수 있다.
    // 의미?
    // => 서브클래스마다 구현이 다를 경우 굳이 수퍼 클래스에서 정의할 필요가 없기 때문에
    //    완전히 정의하지 않은 추상 메서드로 남겨둔다.
    // => 서브클래스에게 메서드 구현을 강제하고 싶을 때도 추상 메서드를 활용한다.
    //    추상 메서드를 상속 받은 서브 클래스는 반드시 정의해야 하기 때문이다.
    //    서브 클래스가 상속 추상 메서드를 구현하지 않는다면
    //    추상 메서드를 그냥 보유하기 때문에 일반 클래스로 사용할 수 없다.
    //    즉 추상 클래스가 되어야 한다.
    // "이 메서드는 수퍼 클래스에서 정의해봐야 소용없어. 어차피 서브 클래스에서 재정의할 메서드야!"
    // "이 메서드는 서브 클래스에서 반드시 정의해야 해. 왜냐하면 수퍼 클래스에 정의한 다른 
    //  메서드가 이 메서드를 사용하기 때문이야!"
    public abstract void m3();
}

// 추상 클래스를 볼때 일부는 구현되있고, 일부는 내가 만들어서 쓰라고 만들어져 있을 것이다.
// 그래서 확인해야 할 것이다.







