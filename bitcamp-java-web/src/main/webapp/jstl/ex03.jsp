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
<h1>JSTL - c:set</h1>
<pre>
- 보관소에 값을 저장한다.
</pre>
<%
//request.setAttribute("name1", "홍길동");
%>
<%--위에와 아래가 같은 것 --%>
<c:set scope="request" var="name1" value="홍길동"/>
1: ${requestScope.name1}<br>
2: ${pageScope.name1}<br>
3: ${name1}<br> 
<hr>
<%-- scope을 생략하면 기본이 pagecontext이다 --%>
<c:set var="name2" value="임꺽정"/>
1: ${requestScope.name2}<br>
2: ${pageScope.name2}<br>
3: ${name2}<br>
<hr>
<%-- 시작태그와 끝 태그 사이(content)에 값을 넣을 수 있다.--%>
<c:set var="name3">유관순</c:set>
1: ${requestScope.name3}<br>
2: ${pageScope.name3}<br>
3: ${name3}<br>

<h2>객체의 프로퍼티 값 설정하기</h2>
<%--useBean으로 정의하고 값을 저장하여 출력 --%>>
<jsp:useBean id="m1" class="com.eomcs.web.vo.Member"/>
<%--
Member m1 = (Member) pageContext.getAttribute("m1");
if (m1 == null) {
  m1 = new Member();
  pageContext.setAttribute("m1", m1);
}
 --%>
<%-- 
m1.setNo(100);
--%>

<%--
<jsp:setProperty name="m1" property="no" value="200"/>
 --%>
<c:set target="${pageScope.m1}" property="no" value="300"/>
<c:set target="${pageScope.m1}" property="email" value="hong@test.com"/>
<%--
 객체의 경로를 설정하는 대신 위에는 한줄의 코드로 설정한다. 
 
Object obj = pageContext.getAttribute("m1");
Method m = obj.getClass().getMethod("setEmail", String.class);
m.invoke(obj, "hong@test.com");

=> m1.setEmail("hong@test.com"); 
결국 setter 를 넣은것과 같은 의미이다.
--%>

${pageScope.m1.no}<br>
${pageScope.m1.email}<br>
</body>
</html>












