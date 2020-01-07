// 오버라이딩(overriding) - 준비
package com.eomcs.oop.ex06.c;

public class Exam0110 {
    public static void main(String[] args) {
        A obj1 = new A();
        obj1.name = "홍길동";
        
        obj1.print();
        // 출력을 할려면 인스턴스 주소가 있어야 한다
        // 유효한 값의 인스턴스의 주소를 호출하여야 하며, 
        // 그래야 인스턴스 메서드의 내장변수가 실행 될수 있다
    }
}
