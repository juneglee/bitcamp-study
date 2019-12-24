// 논리 연산자 : && vs &
package com.eomcs.basic.ex05;

public class Exam03_3 {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean r = a && (b = true); 
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
        // a=false, b=false, r=false 
        // && 연산에서 왼쪽 값이 이미 false이기 때문에 결과는 확정되었다.
        // &&은 ()을 실행하기전에 이미 결과를 예측하면 ()을 먼저 실행해야 하더라도 실행하지 않음

        boolean a1 = false;
        boolean b1 = false;
        boolean r1 = a1 & (b1 = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a1, b1, r1);
        // 결과를 예측할 수 있더라도 모든 과정을 수행한다
    }
}
// &&, ||
// - 앞의 피연산자의 값으로 결과를 알 수 있다면 뒤의 명령은 실행하지 않는다.
// 
// &, |
// - 앞의 피연산자로 결과를 알 수 있을 지라도, 
//   뒤에 놓은 명령까지 모두 실행한다.