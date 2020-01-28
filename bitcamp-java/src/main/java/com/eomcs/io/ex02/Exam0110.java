// Byte Stream - 바이트 단위로 출력하기
package com.eomcs.io.ex02;

import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // 1) 파일로 데이터를 출력하는 객체를 준비한다.
    // - new FileOutputStream(파일 경로)
    // - 지정된 경로에 해당 파일을 자동으로 생성
    // - 기존의 같은 이름의 파일이 있으면 덮어쓴다
    // - 주의! 기존 파일이 삭제 된다
    // - 파일 경로가 절대 경로가 아니면
    // - 리눅스,유닉스: /로 시작하지 않으면,
    // - 윈도우 : c:\. d:\ 등으로 시작하지 않으면
    // 현재 디렉토르로 지정된다
    FileOutputStream out = new FileOutputStream("temp/test1.data");

    // 2) 1바이트를 출력한다.
    // => int 값을 아규먼트로 넘기더라도 맨 마지막 1바이트만 출력한다.
    out.write(0x7a6b5c4d); // 출력하는 값은 0x4d 이다.

    // 3) 출력 도구를 닫는다.
    // - 여러 프로그램이 공유하는 자원중 한정된 개수를 가지는 자원은 OS에서 관리하며,
    // 사용 후에는 OS에 반납해야 한다
    // 그래야 다른 프로그램이 해당 자원을 사용할 수 있다
    // ex) 파일, 메모리, 네트워크 연결 등..
    // - 이런 자원을 사용하는 클래스는 항상 자원을 해체시키는 close()라는 메서드가 있다.
    // - 이번 예제는 FileOutputStream 클래스가 사용되며 close()로 해체해야 한다
    // - close()를 호출하면 FileOutputStream이 작업하는 동안 사용했던 버퍼(임시메모리)에
    // 남아 있던 메모리를 삭제한다
    // OS에서 제공한 파일과의 연결을 끊는다

    out.close();
    // 물론, JVM 을 종류하면 JVM 을 실행하는 동안 사용했던 모든 자원은 자동으로 해제된다
    // 이처럼 짧은 시간동안 실행되는 경우, close()를 호출하지 않아도 문제가 되지 않지만.
    // 365일 멈추지 않고 실행하는 서버 프로그램인 경운 사용한 자원을 해제시키지 않으면 문제 발생

    // 결론 : 쓰고 닫아라
    System.out.println("데이터 출력 완료!");

  }

}

// 파일 입출력 API 주요 클래스 (java.io 패키지)

// 1) 데이터 읽기
//
// InputStream (추상 클래스) : 바이트 단위로 읽기 (binary Stream)
// +-- FileInputStram
//
// Reader (추상 클래스) : 문자 단위로 읽기 (character Stream)
// +-- FileReader

// 2) 데이터 쓰기
//
// OutputStream (추상 클래스) : 바이트 단위로 쓰기 (binary Stream)
// +-- FileOutputStram
//
// writer (추상 클래스) : 문자 단위로 쓰기 (character Stream)
// +-- FileWriter

// 바이너리 파일 vs 텍스트 파일
// 1) 바이너리 파일
// - 기본 텍스트 편집기 (메모장, vi 에이터 등 )로 편집할 수 없는 파일을 말한다
// - 만약 텍스트 편집기로 변경한 후 저장하면, 파일 포맷이 깨지기 때문에 무효한 파일이 된다
// - ex) .pdf, .ppt, .xls, .gif, .mp3, .jpg, .hwp, .mox 등
// - 바이너리 파일을 편집하려면 해당 파일 포맷을 이해하는 전용 프로그램이 필요하다
// 2) 텍스트 파일
// - 기본 텍스트 편집기 (메모장, vi 에이터 등 )로 편집할 수 있는 파일을 말한다
// - 예) .txt, .csv, .html, .js, .css, .xml, .bat, .c, 등
// - 텍스트 파일은 전용 에이터가 필요없다
// - 텍스트를 편집할 수 있는 에이터라면 편집 후 저장해도 유효하다.

// ## 바이너리 데이터 읽고, 쓰기
// - 읽고 쓸 때 중간에서 변환하는 것 없이 바이트 단위로 그래도 읽고 써야 한다
// - InputStream/OutputStream 계열의 클래스를 사용하라

// ## 텍스트 데이터 읽고, 쓰기
// - 읽고 쓸 때 중간에서 문자 코드표에 따라 변환하는 것이 필요하다
// - Reader/Writer 계열의 클래스를 사용하라


