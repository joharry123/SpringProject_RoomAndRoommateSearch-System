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
<title></title>
<link rel = "stylesheet" href="resources/css/main.css">
</head>
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
		font-size: 20px;}
	
	</style>
<%  
   //scope객체에 저장하면 모두 Object타입
   LoginDto ldto=(LoginDto)session.getAttribute("ldto");
//    Object ldto=session.getAttribute("ldto");
    
   //sesseion에 로그인 정보가 없다면(로그아웃) 로그인 페이지로 이동
   if(ldto==null){
      pageContext.forward("index.jsp");
//       response.sendRedirect("index.jsp");
   }
%>
  
   <body >
    
      <div>
         <ul>
            <h1>임차인 메인</h1>
           
            <h4><%=ldto.getId()%>님 반갑습니다.</h4>
            <br></br>
<!--             <li class="menu"><a href="index.jsp">로그아웃</a></li> -->
         </ul>
      </div>  
      
<div>        
   <ul>  
         <button class="size"><a href="userinfo.do?id=<%=ldto.getId()%>">My page </a></button>   
         <button class="size"><a href = "roomlist.do">RoomList</a></button>
         <button class="size"><a href = "getilist.do?id=<%=ldto.getId()%>">MyList</a></button>
         <button class="size"><a href="roommatelist.do?id=<%=ldto.getId()%>">Roommate</a></button>          
   </ul>


      <form class="center" action="after_search.do" method="post" >  
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


