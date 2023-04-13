<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.user.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.content_all {
	width: 95%;
	margin: 0 auto;
}

.title {
	font-size: 28px;
	font-weight: bold;
	width: 95%;
	margin: 0 auto;
	margin-top: 10px;
	margin-bottom: 20px;
}

.text_zone {
	width: 90%;
	margin: 0 auto;
	margin-top: 50px;
	margin-bottom: 100px;
}

hr {
	height: 3px;
	background: #000;
	border: 0;
}

table {
	margin: auto;
	margin-top: 80px;
	border: none;
	width: 50%;
	height: 450px;
}

td {
	border-bottom: 2px solid gray;
}

.name {
	font-weight: bolder;
	border: none;
}

.mypage {
	text-align: center;
	margin-top: 30px;
}

.gmypage {
	width: 49%;
	height: 35px;
	background-color: #aacef2;
	color: black;
	border: none;
	border-radius: 10px;
}

button:hover {
	background-color: #75b2f0;
}

.v {
	color: gray;
}
</style>
</head>
<body>
	<%@include file="/header.jsp"%>
	<!-- 내정보확인페이지 -->
	<%
	UserVO user = (UserVO) request.getAttribute("member");
	%>
	<div class="content_all">
		<p class="title">개인정보조회</p>
		<hr>
		<div class="text_zone">


			<table>
				<tr>
					<td class="name">아이디</td>
				</tr>
				<tr>
					<td class="v"><%=user.getId()%></td>
				</tr>
				<tr>
					<td class="name">비밀번호</td>
				</tr>
				<tr>
					<td class="v"><%=user.getPassword()%></td>
				</tr>
				<tr>
					<td class="name">이름</td>
				</tr>
				<tr>
					<td class="v"><%=user.getName()%></td>
				<tr>
				<tr>
					<td class="name">전화번호</td>
				</tr>
				<tr>
					<td class="v"><%=user.getRole()%></td>
				</tr>


			</table>
			<div class="mypage">
				<form action="myPage.jsp]">
					<button type="submit" class="gmypage">마이페이지</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>