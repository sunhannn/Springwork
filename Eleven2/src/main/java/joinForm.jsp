<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="joinGo.do">
	<label for="id">
	아이디 : <input type="text" name="id" id="id">
		<button type="button"  onclick="joongbok()">중복체크</button>
	</label><br>
	<label for="pw">
	비밀번호 : <input type="password" name="password">
	</label><br>
	<label for="name">
	이름 : <input type="text" name="name">
	</label> <br>
	
	<label for="role">
	역할 : <input type="text" name="role">
	</label><br>
		
		<button type="submit">가입하기</button>
		
	</form>
	
	<script type="text/javascript">
// 	function joongbok(){
// 		   var objParams={id:document.getElementById("id").values};
// 		   var values=[]; //ArrayList 값을 받을 변수를 선언
		   
// 		   $.ajax({
// 		      method:"POST", url:"joongbok.do", data: objParams, cache: false, success: function(res){
// 		         if(res.code=="OK"){ //controller에서 넘겨준 성공여부 코드
// 		            values=res.joongBok; //java에서 정의한 ArrayList명을 적어준다.
// 		            $.each(values, function(value){
// 		               console.log(value.id); //BoardVO.java의 멤버필드명을 써주면 된다.
// 		               if (res.joongBok == 1){
// 		            	document.alert('중복된 아이디입니다!');   
// 		               }else{
// 		            	   document.alert('사용가능한 아이디입니다!');  
// 		               }
// 		               }
// 		            );
// 		            console.log("성공");
// 		         }else{
// 		            console.log("실패");
// 		         }
// 		      },
// 		      error:function(request, status){
// 		         alert("오류가 발생했습니다.");
// 		      }
// 		   })};
	$(()=>{
   $("#idCheck").click(function(){
      $.ajax({
         url : "joongbok.do",   //컨트롤러 주소래
         type : "post",   //form태그의 method랑 같은거
         data : { idJoonbok: $("#id").val() },   //request.setParameter에 첫번째 매개변수가 seungmu, 두번째매개변수가 보낼값
         cache : false,   //기존 ajax 기록삭제, 캐쉬에
         success : function(idJoonbok){   //아약스처리가 잘됫을때 나타날곳
            console.log('success');
            alert(idJoonbok.id + '는 ' + idJoonbok.str);
         },
         error : function(){   //아약스처리 실패시 나타날곳
            alert('error');
         }
      });            
   });
});
	
	
	
	
	</script>
	
	
	
	
</body>
</html>