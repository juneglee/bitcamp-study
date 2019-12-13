package com.eomcs.basic.ex99;

public class Exam23 {
  public static void main(String[] args){
    java.util.Scanner Scanner = new java.util.Scanner(System.in); 
    //스캐너는 키보드에 들어온 데이터를 끊어주는 도우미
    
    System.out.print("입력>");
    
    int i1 = Scanner.nextInt();
    int i2 = Scanner.nextInt();
    String s = Scanner.nextLine();


    System.out.println("---------------------------------------------------------------------");

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(s);

    //next int()
    // -space/tab/new line 기호을 만나면, 그 앞까지 입력한 문자열을 int 값으로 바꿔 리턴한다
    // -현재 커서의 위치는 공백(White space: space/tab/new line과 같다)에 있다.
    //  즉 값을 읽고 난 후 공백을 제거하지 않는다.
    // -그래서 나음 매서드는 공백부터 읽게 된다
    // -nextInt는 앞에 공백이 있으면 무시한다 
    //  다음 공백을 만날 때까지 읽는다
    // 
    // 결론
    // - nextlnt 다음에 nextline을 실행할때 라인 다음에 int가 읽은 값부터 다음부터 읽게기 때문에 
    // 기대하지 않는 값이 리턴 될수 있다

   
   

  }
}