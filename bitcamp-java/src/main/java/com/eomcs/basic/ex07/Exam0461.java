package com.eomcs.basic.ex07;

//# 메서드 : 스택 메모리 응용 II - 스택 오버플로우
//
public class Exam0461 {

  static int sum(int value) {
    if (value == 1)
      return 1;

    return value + sum(value - 1); 
    // f(n) = n + f(n-1)와 동일(단, f(1)= 1)
    // 재귀호출은 수학적인 공식에 활용이 높지만, 메모리를 많이 사용하는 단점이 있다.
  }

  public static void main(String[] args) {

    // 스택 오버플로우 
    // => jVM 스택 메모리가 꽉 차서 더이상 메서드를 실행을 위해 로컬 변수를 
    //    만들 수 없는 상태 이다.
    // 예)
    // 그런데 다음과 같이 큰 수를 계산할 때는 
    // 재귀호출의 수가 높아져서 쉽게 스택 메모리가 부족해지는 문제가 발생한다.
    // 따라서 호출 단계가 깊지 않은 작은 수를 다룰 경우에는 
    // 재귀호출을 써도 되지만,
    // 호출 단계가 많은 큰 수를 다룰 때는 재귀호출 대신 반복문을 사용하라!
    System.out.println(sum(100000));
    
    //메소드 호출이 너무 깊어지는 경우는 재귀 호출 대신 다른 방법을 사용하라.
    /*
    long sum = 0;
    for (int i =1 ; i <= 10000; i++) {
      sum += 1 ;
     System.out.println(sum);
    }
    */
  }
}
