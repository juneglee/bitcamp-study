// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//

package com.eomcs.basic.ex04.assignment;

public class Test03 {
    import java.io.BufferedReader;

    import java.io.InputStreamReader;

    import java.io.IOException;
    public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner (System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int = a,b;
    char = op;

    System.out.print("첫 번째 정수 입력    : ");

		a = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력    : ");

		b = Integer.parseInt(br.readLine());

		System.out.print("연산자 입력(+ - * /) : ");


    op = (char)System.in.read();	



		if(op=='+')		{
			System.out.printf("%n>> %d + %d = %d%n", a, b, (a+b));
		}		else if(op=='-')	{

			System.out.printf("%n>> %d - %d = %d%n", a, b, (a-b));

		}		else if(op=='*')	{

			System.out.printf("%n>> %d * %d = %d%n", a, b, (a*b));

		}		else if(op=='/') {			System.out.printf("%n>> %d / %d = %d%n", a, b, (a/b));

		}		else	{
			System.out.printf("입력 과정에 오류가 존재합니다.");

		}

  }
}