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

<h2>배열</h2>
<pre>
- setAttribute
- c:forEach
</pre>

<%
pageContext.setAttribute("names", new String[]{"홍길동", "임꺽정", "유관순"});

/*
String[] names = (String[]) pageContext.getAttribute("names");
for (String n : names) {
  out.println("<li>" + n + "</li>");
}
*/
%>

<ul>
<c:forEach items="${pageScope.names}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>

</body>
</html>












