// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam04_1 {
    public static void main(String[] args) {
        int i = 1;
        //   00000000 00000000 00000000 00000001 = 1
        System.out.println(i << 1);
        // 0|00000000 00000000 00000000 0000001x  
        //   00000000 00000000 00000000 00000010 = 2
        System.out.println(i << 2);
        // 00|00000000 00000000 00000000 000001xx  
        //    00000000 00000000 00000000 00000100 = 4
        System.out.println(i << 3);
        // 000|00000000 00000000 00000000 00001xxx  
        //     00000000 00000000 00000000 00001000 = 8
        System.out.println(i << 4);
        // 왼쪽으로 이동 후, 
        // 오른 쪽 빈자리 : 0으로 채운다.
        // 왼쪽 경계를 넘어간 비트 : 짜른다.

        i = 0b0000_1011; // 11 * 1(2^0)/ *2(2^1)/ *4(2^2)/ *8(2^3) 
        System.out.println(i << 1); // 22 => 00010110
        // 0|0001 011x
        //   0001 0110 = 22
        System.out.println(i << 2); // 44 => 00101100
        // 00|0010 01xx
        //    0010 1100 = 44
        System.out.println(i << 3); // 88 => 01011000
        // 000|0101 1xxx
        //     0101 1000 = 44
    }
}
// tip 왼쪽 이동
// - 1비트 이동은 곱하기 2 한 것과 같은 효과를 준다.
// - 값을 배수로 증가시킬 때 곱하기 연산보다 비트 왼쪽 이동 연산이 빠르기 때문에 
//   실무에서는 배수 연산을 수행할 때 비트 왼쪽 이동 연산을 자주 사용한다 