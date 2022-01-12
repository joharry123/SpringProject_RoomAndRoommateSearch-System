<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<style type="text/css">

		.header{
		background-color : white;
		height:180px; 
		text-align: center; 
		 position:relative; 
		 width:100%;
		 z-index: 4;
		}   
		
		.header1{
		
		font-weight: bold; 
		font-size: 27pt; 
		text-align: center; 
		 position:relative;   
		
		
		}
		                      
		.subname{     
		color:lightgray;
		font-weight: bold;
		font-size:8px; 
		text-align: center; 
		margin:20px;
		height:15px; position:relative;    }    
		             
		.logout{
		font-size: 12px;
		color:red;
		font-weight: bold;
		text-align: right;
		  position:relative;   
		
		 }
		 
		.moon{      
		
		vertical-align: right;  
		width: 200px;        
		height: 130px;
		margin: 5px;
		position:relative; 
		
		         
		} 
		  
		.line { border-top:1px solid #9C9C9C; border-bottom:1px solid #F6F6F6;  position:relative; margin: 2px; }
		
		a{   
		text-decoration: none}   
            
</style>    
</head>   
<body>  
    <div class="header"><div class="logout"><a href="index.jsp">로그아웃</a></div>
     <img class="moon" src='resources/image/header4.png'>
     <br></br>  
    <hr class="line"/>      </div>
</body>
</html>


