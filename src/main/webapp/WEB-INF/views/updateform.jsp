<%@page import="com.hk.roommate.dtos.LoginDto"%>
<%@page import="com.hk.roommate.daos.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<%@ include file="./hf/header.jsp" %>  

<style type="text/css">
		
		
		table {
		    margin-left:auto; 
		    margin-right:auto;
		}
		
		h4{
		text-align: center;}
</style>
<body>
<h4>나의정보수정하기</h4>
<form action="after_updateuser.do" method="post">
<input type="hidden" name="id" value="${id}"/>
<table border="1">
	<tr>
		<th>아이디</th>
		<td>${id}</td>
	</tr>  
	<tr>
		<th>이름</th>
		<td>${name}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="address" value="${address}"/></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><input type="tel" name="phone" value="${phone}"/></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="email" name="email" value="${email}"/></td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${role}</td>
	</tr>
	<tr>
		<td colspan="2">  
			<button type="submit">수정완료</button>
			<button onclick="location.href='userinfo.do">나의정보</button>
		</td>
	</tr>  
</table>
</form>
</body>
   <%@ include file="./hf/footer.jsp" %> 
</html>