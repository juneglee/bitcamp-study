// 예외 다루기
package bitcamp.app2;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c06_1")
public class Controller06_2 {

  // 테스트:
  // http://.../app2/c06_1/get
  @GetMapping("get")
  // void 를 지정하면 jsp로 경로가 자동저장된다.
  public void get() {}

  @PostMapping("post")
  // post 일때만
  public void post() {}

  // 테스트:
  // http://.../app2/c06_1/error
  @GetMapping("error1")
  public void error1() throws Exception {
    throw new Exception("request handler 오류 발생");
    // Request Handler 에서 예외를 던졌을 때 페이지 컨트롤로에서 처리절차
    // 1) 페이지 컨트롤러 안에 예외 처리기가 있다면,
    // => 해당 메서드를 호출
    // 2) @ControllerAdvice 객체에 예외 처리기가 있다면,
    // => 해당 메서드를 호출
    // 3) Web.xml에 지정된 오류처리 기본 페이지가 설정되어 있다면
    // => 해당 페이지를 호출
    // 4) 서블릿 컨테이너의 기본 오류 처리 페이지를 실행한다.
    //
  }

  // 테스트:
  // http://.../app2/c06_1/error2
  @GetMapping("error2")
  public void error2() throws Exception {
    throw new IOException("request handler 오류 발생");
  }

  // 테스트:
  // http://.../app2/c06_1/error2
  @GetMapping("error3")
  public void error3() throws Exception {
    throw new SQLException("request handler 오류 발생");
  }


  @ExceptionHandler // 예외 처리기
  public ModelAndView exceptionHandler(Exception ex) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("error", ex);
    mv.setViewName("error6");
    return mv;
  }


}


