package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      ServletContext servletContext = getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");
      MemberService memberService = iocContainer.getBean(MemberService.class);

      int no = Integer.parseInt(request.getParameter("no"));
      if (memberService.delete(no) > 0) {
        response.sendRedirect("list");
      } else {
        request.getSession().setAttribute("errorMessage", //
            "삭제할 게시물 번호가 유효하지 않습니다.");
        request.getSession().setAttribute("url", //
            "member/list");
        response.sendRedirect("../error");
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
