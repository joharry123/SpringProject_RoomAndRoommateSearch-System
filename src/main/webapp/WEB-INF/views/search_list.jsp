

<%@page import="com.hk.roommate.dtos.InterestDto"%>
<%@page import="com.hk.roommate.dtos.RoomupdateDto"%>
<%@page import="java.util.*"%>
<%@page import="com.hk.roommate.dtos.LoginDto"%>
<%@page import="com.hk.roommate.dtos.filedto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style type="text/css">

body{
text-align: center;}

</style>


<%@ include file="./hf/header.jsp" %>  

<%  


   LoginDto ldto=(LoginDto)session.getAttribute("ldto");
   InterestDto idto=(InterestDto)session.getAttribute("idto");

   if(ldto==null){
      pageContext.forward("index.jsp");
   }

   List<filedto> fList=(List<filedto>)request.getAttribute("fList");
   List<RoomupdateDto> rList=(List<RoomupdateDto>)request.getAttribute("rList");

%>

<h4>
	검색 방 list <a href="back.do?id=<%=ldto.getId()%>">메인페이지 </a>
</h4>
<body>
<div >
	<form>
		<table class="a" border="1" width=200 height=200 >

	 <%  
      String role = ldto.getRole();  
          
      for(int i=0;i<fList.size();i++){        
          filedto fDto = fList.get(i);
          RoomupdateDto rDto= rList.get(i);
          
            if(rDto.getR_seq()==fDto.getF_seq()){
            String src="upload/"+fDto.getStored_fname(); 
      %>
			<tr>
				<th><a href="detailroom.do?f_seq=<%=fDto.getF_seq()%>&r_seq=<%=rDto.getR_seq()%>"><%=rDto.getR_title()%></a>

				<% if(ldto.getRole().equals("USER2")) {  
	         %>
					<button alert="게시물이 삭제되었습니다.">
						<a href="removeroom.do?f_seq=<%=fDto.getF_seq()%>">삭제하기</a>
					</button>
			<%   
			}
					if(ldto.getRole().equals("USER1")){
			%> 
					<button alert="관심게시물로 등록되었습니다.">
					<a href="interestRoom.do?r_seq=<%=rDto.getR_seq()%>&id=<%=ldto.getId()%>">찜하기</a>
					</button></th>
			<%  
	         }  
	        %>
	         </tr>
				<%-- 			 <button alert="관심게시물로 등록되었습니다."><a href="interestRoom.do?f_seq=<%=fDto.getF_seq()%>">찜하기</a></button></th> --%>
			<tr>
				<td><img src="<%=src%>" width=200 height=200 /></td>
			</tr>
			
		 <%
          if(rDto.getCost2()==0){
         %>
			<tr>
				<th>월세:<%=rDto.getCost1()%>/보증금:<%=rDto.getCost4()%></th>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<%
          }
          else if(rDto.getCost1()==0){
	        %>
			<tr>
				<th>전세보증금:<%=rDto.getCost2()%></th>
			</tr>
			<tr></tr>
			<tr></tr>  
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<%  
          }
        }            
      }
   %>
		</table>
	</form>
		   <%@ include file="./hf/footer.jsp" %>     
	</div>
	

	
</body>  
</html>
  
