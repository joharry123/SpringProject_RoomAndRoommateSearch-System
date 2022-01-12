<%@page import="com.hk.roommate.dtos.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
 <%@ include file="./hf/header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<%
	LoginDto ldto=(LoginDto)session.getAttribute("ldto");
	if(ldto==null){
		pageContext.forward("index.jsp"); }
%>

<body>
<h1>관리자 메인</h1>
<div>
	<span><%=ldto.getName()%></span>님 반갑습니다.(아이디:<%=ldto.getId()%>)
	<a href="index.jsp">로그아웃</a>
</div>
<div>
	<ul>
		<li><a href="userlist_status.jsp">회원상태정보조회</a></li>
		<li><a href="userlist.jsp">회원정보조회(사용가능계정)</a></li>
	</ul>
</div>
</body>
  <%@ include file="./hf/footer.jsp" %>  
</html>



