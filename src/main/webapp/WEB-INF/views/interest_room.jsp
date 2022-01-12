<%@page import="java.util.*"%>
<%@page import="com.hk.roommate.dtos.*"%>
<%@page import="com.hk.roommate.daos.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ include file="./hf/header.jsp" %> 
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>

<%    
   LoginDto ldto=(LoginDto)session.getAttribute("ldto");

   if(ldto==null){
      pageContext.forward("index.jsp");  
   }

   List<filedto> FIList=(List<filedto>)request.getAttribute("FIList");
   List<RoomupdateDto> RIList=(List<RoomupdateDto>)request.getAttribute("RIList");

%>  


<body>
	<form class="size">
	<h4>
	내가 찜한 방 목록 
	<a href="back.do?id=<%=ldto.getId()%>">메인페이지 </a>
	</h4>
		<table border="1" width=200 height=200>

			<%  
  
      for(int i=0;i<FIList.size();i++){        
          filedto fDto = FIList.get(i);
          RoomupdateDto rDto= RIList.get(i);
        
          
            if((rDto.getR_seq()==fDto.getF_seq())){
            String src="upload/"+fDto.getStored_fname(); 

            	
     		 %>
			<tr>  
						<th><a href="detailroom.do?f_seq=<%=fDto.getF_seq()%>&r_seq=<%=rDto.getR_seq()%>"><%=rDto.getR_title()%></a>
						 <% if(ldto.getRole().equals("USER2")) {  
	         %>   
					<button alert="게시물이 삭제되었습니다.">  
						<a href="removeroom.do?f_seq=<%=fDto.getF_seq()%>">삭제하기</a>
					</button>
			  		
					<button alert="관심게시물로 등록되었습니다."><a href="interestRoom.do?f_seq=<%=fDto.getF_seq()%>">찜하기</a></button></th>
			<%  
	         }    
	         %>
	        </tr>
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
</body>
</html>
  <%@ include file="./hf/footer.jsp" %>  
