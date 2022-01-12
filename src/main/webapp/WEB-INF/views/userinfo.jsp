<%@page import="com.hk.roommate.dtos.InterestDto"%>
<%@page import="com.hk.roommate.dtos.RoomupdateDto"%>
<%@page import="java.util.*"%>
<%@page import="com.hk.roommate.dtos.LoginDto"%>
<%@page import="com.hk.roommate.dtos.filedto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
 <%@ include file="./hf/header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의정보</title>
	<style type="text/css">
		   body{
			text-align: center;
			align-items:  center;  
				
			}
		
		   table {
		    margin-left:auto; 
		    margin-right:auto;
		}
	</style>
	
<script type="text/javascript">
<%  
//scope객체에 저장하면 모두 Object타입
LoginDto ldto=(LoginDto)session.getAttribute("ldto");
//	Object ldto=session.getAttribute("ldto");

//sesseion에 로그인 정보가 없다면(로그아웃) 로그인 페이지로 이동
if(ldto==null){
	pageContext.forward("index.jsp");
//		response.sendRedirect("index.jsp");
}
%>
	function updateForm(id){
		location.href="updateform.do?id="+id;
	}
	
	function deleteUser(id){
		location.href="after_deleteUser.do?id="+id;
	}

</script>
</head>

<body>
<form>
<h1>나의정보</h1>
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
		<td>${address}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${phone}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${email}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${dto.getRole().equals("MANAGER")?"정회원":"일반회원"}</td>
	</tr>

   
</table>
<br></br>
			<button><a href="updateform.do?id=<%=ldto.getId()%>">정보수정</a></button>
			<button><a href="back.do?id=<%=ldto.getId()%>">메인</a></button>  	
</form>
</body> 
  <%@ include file="./hf/footer.jsp" %>    
</html>





