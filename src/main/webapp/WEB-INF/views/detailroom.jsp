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
<title>Insert title here</title>
<%
	LoginDto ldto=(LoginDto)session.getAttribute("ldto");
	RoomupdateDto rDto =(RoomupdateDto)request.getAttribute("rDto");
	List<filedto> fList = (List<filedto>) request.getAttribute("fList");
    int cost1 = rDto.getCost1();
    int cost2 = rDto.getCost2();
    String[] src= new String[5]; 
    String lat=rDto.getLat();
    String lng=rDto.getLot();
 
    %>
  
 <style type="text/css">

 .container{
  width : 400vw;
  transition:transform 0.5s;
  overflow:auto; 
  height: 350px; 
}   

 #map {
 		width : 300px;  
        height: 300px;  
        margin: 0.1px auto;       
      } 
      
  .inner{
  width:99.5vw;
  float:left;
  border: 1px;
  }
  
  .inner img{
  width:25%;   
  height:25%;
}     
  
  .btn button{
  
  cursor:pointer;
  height: 13px;   
  width: 13px;  
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;}
  
.line1 { 
		border-top:1px solid #9C9C9C; 
		border-bottom:1px solid #F6F6F6;  
		position:relative; 
		width : 400px;  
		margin: 3px auto;}
  
 </style>
</head>
<body>   
  
<form align="center"> 
  <br></br>
<table border="1" width="50%" height="40%" align="center">      
	<tr>
		<th colspan="8">제목:<%=rDto.getR_title()%></th>
	</tr>    
<%
   if(cost1==0){ //월세가 0 이면 = 전세
%>
		<tr  class="b">
			<th>방종류</th>
			<td><%=rDto.getRoom1()%></td> 
			<th>전세보증금</th>
			<td><%=rDto.getCost2()%></td> 
			
		<th>관리비</th>
		<td><%=rDto.getCost3()%></td> 
	    <tr>
		<th>주차여부</th>
		<td><%=rDto.getParking()%></td>  
		<th>방크기</th>
		<td><%=rDto.getR_size()%>m</td> 
		<th>해당층 </th>
		<td><%=rDto.getStare()%>층</td> 
	</tr>
	<tr>
		<th>옵션</th>
		<td colspan="5"><%=rDto.getRoomoption()%></td> 
	</tr>
	<tr>
		<th>상세설명</th>  
		<td colspan="5"><%=rDto.getDetail()%></td> 
	</tr>		
<%	
  }
  else if(cost2==0){ //전세가 0이면 = 월세 
%>
		<tr>
		    <th>방종류</th>
			<td><%=rDto.getRoom1()%></td> 
			<th>월세</th>
			<td><%=rDto.getCost1()%></td>
			<th>보증금</th>
			<td><%=rDto.getCost4()%></td> 		
			<th>관리비</th>
			<td><%=rDto.getCost3()%></td> 
		    <tr>
			<th>주차여부</th>
			<td><%=rDto.getParking()%></td>  
			<th colspan="2">방크기</th>
			<td><%=rDto.getR_size()%>m</td> 
			<th colspan="2" >해당층 </th>
			<td><%=rDto.getStare()%>층</td> 
	</tr>
	<tr>
		<th>옵션</th>
		<td colspan="8"><%=rDto.getRoomoption()%></td> 
	</tr>
	<tr> 
		<th>상세설명</th>  
		<td colspan="8"><%=rDto.getDetail()%></td> 
	</tr>	
	
<%
   }
%>
	<%

	
	for(int i=0;i<fList.size();i++){
		filedto fDto = fList.get(i);
	
	    if(fDto!=null){
	      
        src[i] = "upload/"+fDto.getStored_fname();
	    }
	    
	    
	}
	%>  
</table>
<br>      
 <div class="btn">
		 <button type="button" class="btn1"></button>  
		 <button type="button" class="btn2"></button> 
		 
		 <%if(src[2]!=null){ %>     
		 <button type="button" class="btn3"></button> 
		 
		 <% if(src[3]!=null){ %>  
		 <button type="button" class="btn4"></button>
		 
		  <% if(src[4]!=null){ %>  
		 <button type="button" class="btn5"></button>	  
		 <% 
		  }
	    }
	}
		 %>
		 <br></br>

 </div>   
<div style="overflow:hidden">
  <div class="container">  
		    <div class="inner">
		   <img src="<%=src[0]%>">
		    </div>
		   <div class="inner">
		   <img  src="<%=src[1]%>">
		    </div>  
		    <% if (src[2]!=null) {%>
		    <div class="inner">      
		   <img  src="<%=src[2]%>">       
		    </div>   
		     <% if(src[3]!=null){ %> 
		    <div class="inner">      
		   <img  src="<%=src[3]%>">       
		    </div>   
		     <% if(src[4]!=null){ %> 
		     <div class="inner">      
		   <img  src="<%=src[4]%>">       
		    </div>  
		    <%}
		     }
		    }%>
   </div>
    <hr class="line1"/>      </div>
   <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCwtLge4OebA21C3vgCVaAY0oOidnlh7lo&callback=initMap"
         async defer></script>  

     <script>
             var map;
             let lat = document.getElementById('lat').value;
             let lng = document.getElementById('lng').value;
             
             function initMap() {
                 var cityHall = {lat: <%=lat%>, lng: <%=lng%>};

                 var defaultOptions = {
                     zoom: 16,
                     center: cityHall,
                     disableDefaultUI:true,
                     zoomControl: true
                     };
                 map = new google.maps.Map(document.getElementById('map'), defaultOptions);

                 var marker = new google.maps.Marker({position: cityHall, map: map});
             }
     </script>  

     <br></br>
     
        <div id="map"></div>
        		<div><h4>문의하기 : <%=rDto.getInfo()%></h4></div>
        
        <div> 
		<input type="button" value="방리스트" onclick="javascript:location.href='roomlist.do'"/> 
		<% if(ldto.getRole()=="USER2"){ %>
		<button>  
		<a href="getilist.do?id=<%=ldto.getId()%>&r_seq=<%=rDto.getR_seq()%>">최근 본 방 / 찜 리스트</a>
		</button>  
		<%} %>  
         
           </div>  

	<script>     
	 document.querySelector('.btn1').addEventListener('click',function(){
	 document.querySelector('.container').style.transform = 'translate(0vw)';}); 
	 
	 document.querySelector('.btn2').addEventListener('click',function(){
	 document.querySelector('.container').style.transform = 'translate(-100vw)';}); 
	 
	 document.querySelector('.btn3').addEventListener('click',function(){
	 document.querySelector('.container').style.transform = 'translate(-200vw)';}); 
	 
	 document.querySelector('.btn4').addEventListener('click',function(){
	 document.querySelector('.container').style.transform = 'translate(-300vw)';}); 
	 
	 document.querySelector('.btn5').addEventListener('click',function(){
	 document.querySelector('.container').style.transform = 'translate(-400vw)';}); 
	 
	 document.querySelector('.location').addEventListener('location',function(){
	 document.getElementById("map").style.display = "none";});   	
	</script>

</form>
          <%@ include file="./hf/footer.jsp" %>  
</body> 
</html>
