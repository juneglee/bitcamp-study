<%@page import="java.util.HashMap"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL - Map 객체에서 값 꺼내기</h1>
<%
HashMap<String,Object> map = new HashMap<>();
map.put("s01", "김구");
map.put("s02", "안중근");
map.put("s03", "윤봉길");
map.put("s04 ^^", "오호라");

pageContext.setAttribute("map", map);
%>

${map["s01"]}<br>
${map['s01']}<br>
${map.s01}<br>

<%-- 
key 문자열에 공백이나 특수 문자가 포함된 경우에는 점(.)을 사용할 수 없다.
--%>
<%-- 프로퍼티 이름 중간에 특수 문자나 공백이 들어가는 경우 
    다음과 같이 OGNL 표기법을 쓸 수 없다.
${map.s04 ^^}<br>
--%>
${map["s04 ^^"]}<br>
${map['s04 ^^']}<br>

</body>
</html>












