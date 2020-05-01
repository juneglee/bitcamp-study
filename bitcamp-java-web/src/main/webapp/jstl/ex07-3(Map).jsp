<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:forEach</h1>
<pre>
- 반복문을 만든다.
</pre>

<h2>Map 객체</h2>
<pre>
- 반복문을 만든다.
</pre>
<%
Map<String,Object> names3 = new HashMap<>();
names3.put("s01", "홍길동");
names3.put("s02", "임꺽정");
names3.put("s03", "유관순");
session.setAttribute("names3", names3);
%>

<ul>
<%-- Map 객체에 대해 반복문을 돌리면 var로 저장하는 것은 
     key와 value를 갖고 있는 Entry 객체이다. --%>
<c:forEach items="${names3}" var="n" varStatus="status">
    <li>${n.key} : ${n.value}</li>
</c:forEach>
</ul>

<%--
<c:foreach items="${리스트가 받아올 배열이름}"
           var="for문 내부에서 사용할 변수"
           varStatus="상태용 변수">
 
  // 반복해서 표시할 내용 혹은 반복할 구문
 
</c:foreach>

${status.current} 현재 for문의 해당하는 번호

${status.index} 0부터의 순서

${status.count} 1부터의 순서

${status.first} 첫 번째인지 여부

${status.last} 마지막인지 여부

${status.begin} for문의 시작 번호

${status.end} for문의 끝 번호

${status.step} for문의 증가값

 --%>


</body>
</html>












