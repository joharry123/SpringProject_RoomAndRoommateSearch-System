<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="./hf/header.jsp" %> 
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resources/css/joinuser/joinuser.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<style type="text/css">
	   .table, .tr, .td {border: 1px solid black;
	     margin: 0.1px auto;    }
	   .table{display: table;}
	   .tr{display: table-row;}
	   .td{display: table-cell; padding: 5px;}
	   #container{width: 400px; margin: 200px auto; }
	      
	   h4{
	   text-align: center;}
	</style>
	
<script type="text/javascript">
   function idChk(){
      var id=document.getElementsByName("id")[0].value;//입력된 아이디 구하기
      if(id==null||id==""||id==undefined){
         alert("반드시 아이디를 입력하세요");
         document.getElementsByName("id")[0].focus();
      }else{
         open("idchk.do?id="+id,"중복체크","width=400px,height=400px");
      }  
   }
   $(function(){
      $("input[name]").not("[name=id]").focus(function(){
         var idTitle=$("input[name=id]").attr("title");
         if(idTitle=="n"){
            alert("아이디 중복체크를 확인하세요!!");
            document.getElementsByName("id")[0].focus();
         }
      });
      
      var a=0; 
      $("input[name=id]").focus(function(){
         a=$(this).val().length;
         console.log(a);
      }).keydown(function(){
         console.log(a);
         if(a!=$(this).text().length){
            $(this).attr("title","n");         
         }     
      })        
   })
   
</script>
</head>
<body>
<h4>회원가입하기</h4> 
<form action="after_regist.do" method="post">
   <div class="table">
      <div class="tr">  
         <div class="td">아이디</div>
         <div class="td">
            <input type="text" name="id" title="n" required="required" autocomplete="off" />
            <input type="button" value="중복체크" onclick="idChk()"/>
         </div>
      </div>
      <div class="tr">
         <div class="td">비밀번호</div>
         <div class="td">
            <input type="password" name="password" required="required" />
         </div>
      </div>
      <div class="tr">
         <div class="td">이름</div>
         <div class="td">
            <input type="text" name="name" required="required" />
         </div>
      </div>
      <div class="tr">
         <div class="td">주소</div>
         <div class="td">
            <input type="text" name="address" required="required"  />
         </div>
      </div>
      <div class="tr">
         <div class="td">전화번호</div>
         <div class="td">
            <input type="tel" name="phone" required="required"  />
         </div>
      </div>
      <div class="tr">
         <div class="td">이메일</div>
         <div class="td">
            <input type="email" name="email" required="required" />
         </div>
      </div> 
      <div class="tr">
         <div class="td">사용자 종류</div>
         <div class="td">
         <select name="role">
            <option value ="USER1"> 임차인 </option>
            <option value ="USER2"> 임대인 </option>
         </select>
         </div>
      </div> 
      <div class="tr">
         <div class="td">
            <input type="submit" value="가입"/>
            <input type="button" value="취소" onclick="location.href='index.jsp'" />
         </div>
      </div>
   </div>
</form>
  <%@ include file="./hf/footer.jsp" %>  
</body>
</html>





