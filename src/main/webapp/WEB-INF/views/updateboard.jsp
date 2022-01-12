<%@include file="hf/header2.jsp" %>    
<%@page import="com.hk.roommate.dtos.*"%>
<%@page import="java.util.List"%>    
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>  
<%@ include file="./hf/header.jsp" %>  
<html>  
<head>
<meta charset="UTF-8">
<title>수정하기폼</title>
<%  
    
   LoginDto ldto=(LoginDto)session.getAttribute("ldto");

   if(ldto==null){    
      pageContext.forward("index.jsp");
   }

%> 

</head>  
<body>
<div id="tablebox">
<h1>게시판 수정하기</h1>
<form action="updateboard.do" method="post">
<!-- 	<input type="hidden" name="command" value="updateboard"/> -->
	<input type="hidden" name="seq" value="${requestScope.dto.seq}"/>
	<table class="table table-hover">
		<tr>
			<th>작성자</th>
			<td>${requestScope.dto.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input name="title" value="${dto.title}"  required="required" type="text"  class="form-control"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" required="required" rows="10" cols="60"  class="form-control">${dto.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정완료" class="btn btn-primary"/>
				<input type="button" value="취소" class="btn btn-primary"
				 onclick="location.href='detailboard.do?seq=${dto.seq}'"/>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
   <%@ include file="./hf/footer.jsp" %> 
</html>