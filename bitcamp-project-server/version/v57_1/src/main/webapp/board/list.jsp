<%@page import="com.keep.root.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<jsp:include page="/header.jsp"/>

  <h1>게시글(JSP2)</h1>
  <a href='add'>새 글</a><br>
  <table border='1'>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>
<%
  List<Recruit> list =(List<Recruit>) request.getAttribute("list");

 for(Recruit item: list) {
%>    
  <tr>
    <td><%=item.getNo()%></td> 
    <td><a href='detail?no=<%=item.getNo()%>'>=><%=item.getTitle()%></a></td>
     <td><%=item.getDate()%>9</td>
     <td><%=item.getViewCount()%></td></tr>
<% 
}
%>
</table>