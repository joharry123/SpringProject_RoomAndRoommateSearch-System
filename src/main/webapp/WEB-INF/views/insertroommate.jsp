<%@include file="hf/header2.jsp" %>    
<%@page import="com.hk.roommate.dtos.*"%>
<%@page import="java.util.List"%>    
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<title>글추가폼</title>
<%  
    
   LoginDto ldto=(LoginDto)session.getAttribute("ldto");

   if(ldto==null){    
      pageContext.forward("index.jsp");
   }

%> 

<style type="text/css">
	#tablebox{
		width:600px;
		margin: 0 auto;
	}
</style>
</head>
<body> 
	<h1>RoommateUpdate page</h1>  
	<form action="after_roommateupdate.do" method="post" height="300" weight="400"
		enctype="multipart/form-data">
		<table class="table table-hover">
		<tr>
		<th>아이디</th>
        <th><input type="text" name="rm_id" value="<%=ldto.getId()%>" /></th>
	    </tr>
	    <tr>  
		<th>제목</th>
        <th><input type="text" name="rm_title" required="required" /></th>
	    </tr>
	    <tr>
		<th>지역</th>
        <th><input type="text" name="rm_location" required="required" /></th>
	    </tr>
	    <tr>
		<th>성별</th>
				<th>
                <select name="rm_mf">
					<option value="MAN">남자</option>
					<option value="WOMAN">여자</option>		
				</select>
				</th>
	    </tr>
	    <tr>
		<th>흡연여부</th>
        <th><select name=rm_c>
					<option value="O">O</option>
					<option value="X">X</option>
				</select>
		</th>  
	    </tr>
	    <tr>
		<th>월세</th>
        <th><input type="text" name="rm_cost1" required="required" /></th>
	    </tr>
	    <tr>
		<th>보증금</th>
        <th><input type="text" name="rm_cost2" required="required" /></th>
	    </tr>
	    <tr>
		<th>전세</th>
        <th><input type="text" name="rm_cost3" required="required" /></th>
	    </tr>
	    <tr>
		<th>관리비</th>
        <th><input type="text" name="rm_cost4" required="required" /></th>
	    </tr>
	    <tr>
	    <th>소개</th>
        <th><textarea rows="10" cols="60" name="rm_content" required="required"></textarea></th>
	    </tr>
	     <tr>	
        </tr>  
    	</table>
    	 <input type="submit" value="등록" />                  
		<button><a href = "back.do?id=<%=ldto.getId()%>">취소</a></button>
    	</form> 
</body>  
</html>
	  <%@ include file="./hf/footer.jsp" %>    