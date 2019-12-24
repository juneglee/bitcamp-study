// 비트 이동 연산자 : 응용 II
package com.eomcs.basic.ex05;

public class Exam04_5 {
    public static void main(String[] args) {
        // Yes/No 또는 true/false 값을 저장할 때 
        // 비트 연산자를 사용하면 메모리를 절약할 수 있다.

        // 비트 연산자 사용 전
        // => 각각의 상태를 별도의 변수에 저장해야 한다.
        // => 8개의 데이터를 저장하기 위해 32바이트가 소요된다.
        boolean c, cpp, java, js, python, php, html, css;
        c = true;
        cpp = false;
        java = true;
        js = false;
        python = true;
        php = false;
        html = true;
        css = false;

        // => 물론 배열을 이용할 수 있다.
        //    boolean 배열을 JVM에서 다룰 때는 각 boolean에 대해
        //    1바이트를 사용한다.
        // => 따라서 8개의 데이터를 저장하기 위해 8바이트를 사용한다.
        boolean[] lang = new boolean[8];
        lang[0] = true;
        lang[1] = false;
        lang[2] = true;
        lang[3] = false;
        lang[4] = true;
        lang[5] = false;
        lang[6] = true;
        lang[7] = false;

        // 비트 연산자 사용 후
        // => 4바이트 변수 한 개만 있으면 
        //    최대 32개의 데이터를 저장할 수 있다.
        // 어떻게?
        int lang2 = 0;
        // 00000000 00000000 00000000 00000000
        
        // 32비트에서  뒤에 8비트를 사용하여 8개의 값을 저장할 수 있따.
        // 8비트에서 각 언어의 값을 저장할 비트를 다음과 같다고 가정하자
        // 00000000
        // ||||||||- css언어
        // |||||||- Html언어
        // ||||||- PHP언어
        // |||||- python언어
        // ||||- javascript
        // |||- java언어
        // ||- C++
        // |- C언어
        // 이렇게 준비된 32비트 메모리에서 특정 비트의 값이 1로 설정하고 싶다면
        // 다음과 같이 특정 비트의 값이 1인 수를 or(|) 연산하라!
        
        lang2 |= 0x80; // c = true 
        // 0000_0000 | 1000_0000 = 1000_0000

        //lang2 |= 0x00; // c++ = false

        lang2 |= 0x20; // java = true
        // 1000_0000 | 0010_0000 = 1010_0000

        //lang2 |= 0x00; // js = false
        
        lang2 |= 0x08; // python = true
        // 1010_0000 | 0000_1000 = 1010_1000
        
        //lang2 |= 0x00; // php = false

        lang2 |= 0x02; // html = true
        // 1010_1000 | 0000_0010 = 1010_1010

        //lang2 |= 0x00; // css = false
        
        // 즉 비트를 이용하여 각 데이터의 true/false를 표현한다.
        // 실무에서는 비트를 이용하여 여러개의 true/false 상태를 저장하기도 한다
        // 사용자 검사 권한, Powershell 권한 정보를 저장, 리눅스 권한
        // -rwx rwx rwx (read, Write, 실행) - 메모리 사용을 최소한으로 할 수 있다. (기술면접, 손코딩 가능)
    }
}
