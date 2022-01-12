<%@page import="com.hk.roommate.dtos.InterestDto"%>
<%@page import="com.hk.roommate.dtos.RoomupdateDto"%>
<%@page import="java.util.*"%>
<%@page import="com.hk.roommate.dtos.LoginDto"%>
<%@page import="com.hk.roommate.dtos.filedto"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="./hf/header.jsp" %>  
</head>
<%  
	//scope객체에 저장하면 모두 Object타입
	LoginDto ldto=(LoginDto)session.getAttribute("ldto");
// 	Object ldto=session.getAttribute("ldto");
	
	//sesseion에 로그인 정보가 없다면(로그아웃) 로그인 페이지로 이동
	if(ldto==null){
		pageContext.forward("index.jsp");
// 		response.sendRedirect("index.jsp");
	}
%>   
	<style type="text/css">
		body{
		
		/* margin-bottom:100px; */
		/* margin-top: 120px; */
		text-align: center;
			
		}
		
		.center{
		  display: flex;
		  justify-content: center;
		  align-items:  center;
		  min-height: 100px;
		 
		}
		
		.size{
		width : 200px;
		height: 100px;
		font-size: 20px;
		}
		
	</style>
<body>
<h4  class="center" >임대인메인</h4> 
<div>   
	<span><%=ldto.getId()%></span>님 반갑습니다. </div>
	<br></br>
	<div>
			<button class="size"><a href="userinfo.do?id=<%=ldto.getId()%>">MyPage</a></button>
			<button class="size"><a href="roomlist.do">Roomlist</a></button>
			<button class="size" ><a href = "roomadd.do">AddRoom</a></button>
    </div>
	<form class ="center" action="after_search.do" method="post" >  
	<table>  
	<tr>  
<td><select name="searchName">
		<option value="Title">글제목</option>
		</select></td>
	<td colspan="2">
	<input type="text" name="searchValue">
	</td>
	<td>
	<input type="submit" value="검색">
	</td>
</tr>	
</table>
</form>

</div>
   <%@ include file="./hf/footer.jsp" %>  
</body>
</html>



