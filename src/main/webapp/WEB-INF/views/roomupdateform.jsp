
<%
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<%@page import="com.hk.roommate.dtos.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
response.setContentType("text/html; charset=UTF-8");
%>
<%@ include file="./hf/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%  

   LoginDto ldto=(LoginDto)session.getAttribute("ldto");

   if(ldto==null){
      pageContext.forward("index.jsp");
   }

%> 

  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCwtLge4OebA21C3vgCVaAY0oOidnlh7lo&callback=myMap"></script>
  
   <script>  
            var geocoder;
            var map;
            
            function getLocation(){
                if(navigator.geolocation){
                    navigator.geolocation.getCurrentPosition(initialize);
                }else{
                    alert("Not Support Browser");
                }
            }        
        
            function initialize(position){            
                geocoder = new google.maps.Geocoder();
                var mapOption = {
                    center:new google.maps.LatLng(position.coords.latitude,position.coords.longitude),
                    zoom:15,
                    mapTypeId:google.maps.MapTypeId.ROADMAP
                };
                map=new google.maps.Map(document.getElementById("googleMap"),mapOption);
            }
            google.maps.event.addDomListener(window, 'load', getLocation);
            
            function codeAddress() {
                var address = document.getElementById('address').value;            
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        map.setCenter(results[0].geometry.location);
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location
                        });
                        
                        alert(('위도(latitude) : ' + marker.position.lat()));
                        // 경도  
                        alert(('경도(longitude) : ' + marker.position.lng()));
                        
                        let lat = marker.position.lat();
                        document.form.lat.value = lat;
                        let lng = marker.position.lng();  
                        document.form.lng.value = lng;      
                        
               
                    } else {
                        alert('Geocode was not successful for the following reason: ' + status);
                    }
                });
            }
            
               
        </script>
   
<style type="text/css">
   .b{display: none;}
   .a{display: none;}
   
   body{

/* margin-bottom:100px; */
/* margin-top: 120px; */
text-align: center;
align-items:  center;  
	
}

div{
text-align: center;  
align-items:  center;
   margin: 0.1px auto; 
}

form{
text-align: center;  
align-items:  center;
     margin: 0.1px auto;   
}

.center{
text-align: center;  
align-items:  center;
     margin: 0.1px auto;    
}



 #googleMap {
 		width : 300px;  
        height: 300px;  
        margin: 0.1px auto;       
      } 
      
      
      table {
    margin-left:auto; 
    margin-right:auto;
}


</style>

<script type="text/javascript">
   function testCh(selObj){  
      var optionsT=selObj.options;
      if(optionsT[0].selected=null){
          document.getElementsByClassName("a")[0].style.display="none";
          document.getElementsByClassName("b")[0].style.display="none";
          document.getElementsByClassName("c")[0].style.display="block";
      }
      if(optionsT[1].selected){
         document.getElementsByClassName("a")[0].style.display="block";
         document.getElementsByClassName("b")[0].style.display="none";
      }else{
         document.getElementsByClassName("a")[0].style.display="none";
         document.getElementsByClassName("b")[0].style.display="block";
      }
   } 
 </script>   
</head>


<body>
	<h1>RoomUpdate page</h1>
	
	 <div  class="center" id="googleMap" style="width:300px; height:300px;"></div>   
        <div id="panel">
            <input id="address" type="textbox" >
            <input type="button" value="Geocode" onclick="codeAddress()">
            </div>
              
<!--     <form method="post" id="frm" name="form" action="traking.do"> -->

	
	<h4>파일업로드</h4>
	<form action="after_roomupdate.do" method="post" height="300" weight="400"
		enctype="multipart/form-data" id="frm" name="form" >
		 
		   
		         <input type="hidden" name="lat" value=""> 
     			 <input type="hidden" name="lng" value="">    
    
		<table>  
		<tr>	
			<td><input type="file" multiple="multiple" name="filename" /></td>	
		</tr> 
		</table>
	
		
		<div class="td">제목</div>
			<div class="td">
				<input type="text" name="r_title" required="required" />
			</div>
		<div class="tr">
			<div class="td">지역</div>
			<div class="td">
				<input type="text" name="location" required="required" />
			</div>
			<div class="td">방종류</div>
			<div class="td">
				<select name="room1">
					<option value="ONEROOM">원룸</option>
					<option value="TWO/THREE ROOM">투룸/쓰리룸</option>
					<option value="OFFICEHOTEL">오피스텔/도시형 생활주택</option>
					<option value="AP">아파트</option>
					<option value="PUBLICHOUSE">공공주택</option>
				</select>
			</div>
		</div>
		<div class="tr">
			<div class="td">매물종류</div>
			<div class="td">
				<select name="room2" onchange="testCh(this)">
				    <option value="선택">선택하기</option>
					<option value="월세">월세</option>
					<option value="전세">전세</option>
				</select>
				 <div class="c"></div> 
				 <div class="a">
					<div class="td">월세</div>
					<div class="td">
						<input type="text" name="cost1" value="0" />
					</div>
					<div class="td">보증금</div>
					<div class="td">
						<input type="text" name="cost4" value="0"/>
					</div>
				</div>
				    
				<div class="b">
					<div class="td">전세보증금</div>
					<div class="td">
						<input type="text" name="cost2" value="0"/>
					</div>
				</div>
				
				<div class="td">관리비</div>
				<div class="td">
					<input type="text" name="cost3" required="required" />
				</div>
			</div>
		</div>
		<div class="tr">
			<div class="td">주차여부</div>
			<div class="td">  
				<select name="parking">
					<option value="YES">O</option>
					<option value="NO">X</option>
				</select>
				<div class="td">방크기</div>
				<div class="td">
					<input type="text" name="r_size" required="required" />
				</div>
				<div class="td">해당층</div>
				<div class="td">
					<input type="text" name="stare" required="required" />
				</div>
				<div class="td">옵션</div>
				<div class="td">
					<input type="text" name="roomoption" required="required" />
				</div>
				<div class="td">상세설명</div>
				<div class="td">
					<input type="text" name="detail" required="required" />
				</div>
				<div class="td">부동산/연락처</div>
				<div class="td">
					<input type="text" name="info" required="required" />
				</div>
			</div>  
		</div>  
		<input type="submit" value="등록" />                  
	</form> 
  
    <button><a href = "back.do?id=<%=ldto.getId()%>">취소</a></button>
       <%@ include file="./hf/footer.jsp" %> 
</body>  
</html>     


