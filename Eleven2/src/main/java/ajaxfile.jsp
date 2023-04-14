<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
   table {
      border-collapse:collapse;
      border:1px solid #333;
      width:60%;
   }
   th, td{
      border:1px solid #333;
   }
   th{
      background-color:#aaa;
      color:#fff;
   }
</style>
<script>
function getBoard(val){
   var objParams={seq:val};
   var values=[]; //ArrayList 값을 받을 변수를 선언
   
   $.ajax({
      method:"POST", url:"reqAjax2.do", data: objParams, cache: false, success: function(res){
         if(res.code=="OK"){ //controller에서 넘겨준 성공여부 코드
            values=res.boardList; //java에서 정의한 ArrayList명을 적어준다.
            $.each(values, function(index, value){
               console.log(index+" : "+value.title); //BoardVO.java의 멤버필드명을 써주면 된다.
               $("#status").append("<tr><td>"+value.seq+"</td><td>"+value.title+"</td><td>"+value.writer+"</td></tr>");
            });
            $("#demo").hide();
            console.log("성공");
         }else{
            console.log("실패");
         }
      },
      error:function(request, status){
         alert("오류가 발생했습니다.");
      }
   });
}
</script>
</head>
<body>
   <h2>ajax Object 받기</h2>
   <table id="status">
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>작성자</th>
      </tr>
   </table>
   <br>
   <div id="demo">
      <button type="button" onclick="getBoard(2)">데이터 불러오기</button>
   </div><br><br>
</body>
</html>