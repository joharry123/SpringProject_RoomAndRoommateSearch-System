<%@page import="com.hk.roommate.dtos.*"%>
<%@page import="java.util.List"%>    
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>  
<html>
<%@include file="hf/header2.jsp" %>       
<head>  
 
<meta charset="UTF-8">

<script type="text/javascript">


	function allSel(bool){
		var chks=document.getElementsByName("chk");
		for(var i=0; i<chks.length; i++){
			chks[i].checked=bool;
		}
	}
	
	function isChecked(){
		var count=0;
		var chks=document.getElementsByName("chk");
		for(var i =0; i < chks.length; i++){
			if(chks[i].checked){
				count++;
			}
		}
			if(count == 0){
				alert("최소 하나 선택하세요");
				return false;
			}else{
				return true;
			}  
	}	  
	
	function attrShow(){
		$("th").slice(5,8).toggle().end().eq(9).toggle();
		$("tr").each(function(){
			$(this).children("td").slice(5,8).toggle().end().eq(9).toggle();
		})
	}
</script>

<%  

   LoginDto ldto=(LoginDto)session.getAttribute("ldto");  

   if(ldto==null){
      pageContext.forward("index.jsp");

   }
 
%>

<style type="text/css">
	#tablebox{
		width: 800px;
		margin: 20px auto; 
		 
	}

	#ajaxform{
		width:600px;
 		margin-left: 450px; 
	}
	

</style>
</head>   


<body> 
<!-- 객체 생성같은의미 -->
<jsp:useBean id="util" class="com.hk.roommate.utils.Util" />        

<div id="tablebox">

<form action="muldel.do" method="post" onsubmit="return isChecked()">
<input type="hidden" name="command" value="muldel" />

<table class="table table-hover">
  
	<tr>
		<th><input type="checkbox" name = "all" onclick="allSel(this.checked)"/></th>
		<th>번호</th> 
		<th>제목</th>    
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>	
	</tr>
	<%    List<AnsDto> list = (List<AnsDto>)request.getAttribute("list"); 
      for(int i = 0;i<list.size();i++){
    	  AnsDto aDto = list.get(i);     
      %> 
	<tr>
	    <td><input type="checkbox" name="chk" value=<%=aDto.getRm_seq()%>/></td>
	    <td><%=aDto.getRm_seq()%></td>
		<td><a href="roommatedetail.do?rm_seq=<%=aDto.getRm_seq()%>"><%=aDto.getRm_title()%></a></td>
		<td><%=aDto.getRm_id()%></td> 
		<td><%=aDto.getRm_date()%></td> 
		<td><%=aDto.getRm_readcount()%></td>       
		</tr>
	
	<%    
	} %>  

	<tr>
		<td colspan="10">

			<button class="btn btn-success"> <a href="insertroommate.do?id=<%=ldto.getId()%>">글작성</a></button>  
			<button class="btn btn-success"> <a href="back.do?id=<%=ldto.getId()%>">돌아가기</a></button>  
			
		</td>  
	</tr>
</table>  
</form>
</div>
   <%@ include file="./hf/footer.jsp" %> 
</body>
</html>