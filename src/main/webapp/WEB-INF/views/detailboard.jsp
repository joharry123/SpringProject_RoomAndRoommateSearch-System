
<%@page import="com.hk.roommate.dtos.AnsDto"%>
<%@page import="java.util.List"%>
<%@include file="hf/header2.jsp" %>   
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>  
<meta charset="UTF-8">
<title></title>
<title>글추가폼</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<%
 AnsDto aDto =(AnsDto)request.getAttribute("ansDto");
    
    %>
<style type="text/css">
	#tablebox{
		width:600px;
		margin: 0 auto;
	}
	#replyForm{
		display: none;
	} 
	#tablebox{
		overflow: auto;
		height: 500px;
	}
</style>
</head>
<body>
<div id="tablebox">
<table class="table table-hover">

	<tr> 
		<th>제목</th>
		<td><%=aDto.getRm_title()%></td>
	</tr>
	<tr>  
    	<th>작성자</th>
		<td><%=aDto.getRm_id()%></td>
	</tr>
	<tr> 
		<th>성별</th>
		<td><%=aDto.getRm_mf()%></td>  
	</tr>
	<tr> 
		<th>흡연여부</th>
		<td><%=aDto.getRm_c()%></td>
	</tr>
	<tr>  
    	<th>월세</th>
		<td><%=aDto.getRm_cost1()%></td>
	</tr>
	<tr>  	
		<th>보증금</th>
		<td><%=aDto.getRm_cost2()%></td>
    </tr>	
    <tr>
		<th>전세</th>
		<td><%=aDto.getRm_cost3()%></td>
	</tr>  
   
	
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="60" name="content"  class="form-control" readonly> <%=aDto.getRm_content()%> </textarea></td>
	</tr>
	<tr>
		<td colspan="2" text-align="center">  

			<button class="btn btn-info"><a href="roommatelist.do?id=<%=aDto.getRm_id()%>">목록</a></button>       
		</td>  
	</tr>    
</table>
 
	<div id="replyForm">	
		<table  class="table table-hover">
		<tr>
			<th>작성자</th>  
			<td><input type="text" name="rm_id"  class="form-control" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="rm_title"  class="form-control"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" name="rm_content"  class="form-control"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="답글추가" class="btn btn-primary" /></td>
		</tr>  
		</table>  
	</div>
</div>
</body>
	  <%@ include file="./hf/footer.jsp" %>  
</html>
