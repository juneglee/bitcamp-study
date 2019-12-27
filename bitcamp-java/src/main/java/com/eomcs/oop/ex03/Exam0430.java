// 생성자 - 여러 개의 생성자 정의하기 
package com.eomcs.oop.ex03;

public class Exam0430 {
    
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float average;
        
        Score() {
            System.out.println("Score()");
        }
        
        Score(String name) {
            System.out.println("Score(String)");
            this.name = name;
        }
        
        Score(String name, int kor, int eng, int math) {
            System.out.println("Score(String,int,int,int) 호출!");
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.compute();
        }
        
        public void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.average = this.sum / 3f;
        }
    }
    
    public static void main(String[] args) {
        // 생성자가 여러 개 일 때 파라미터에 전달하는 값으로 구분한다.
        Score s1 = new Score();
        
        // d인스턴스 후에 생성자를 생성할 수 없다 
        // s1.Score = new Score("홍길동", 100, 90, 77);
        Score s2 = new Score("유관순");
        Score s3 = new Score("홍길동", 100, 90, 77);
        //Score s4 = new Score(true);// 단 논리값을 출력하는 값이 없다 boolean x
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
                s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.average);
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
                s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.average);
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
                s3.name, s3.kor, s3.eng, s3.math, s3.sum, s3.average);
    }
}







