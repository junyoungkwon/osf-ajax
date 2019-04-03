<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저는 views</title>
</head>
<body>
<div align="center">
<a href="${rPath}/movie/list">영화개봉리스트</a><br>
<a href="${rPath}/views/movie/ajax_list">AJAX영화개봉리스트</a>
<br>
</div>

<c:if test="${sessionScope.user==null}">
	<form method="post" action="/user">
		<table border="1" align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="ui_id" id="ui_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="ui_pwd" id="ui_pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>로그인</button></td>
			</tr>
		</table>
		<input type="hidden" name="cmd" value="login">
	</form>
	<div align="center">
		<a href="/views/user/join" align="center">회원가입</a>
	</div>
</c:if>

<c:if test="${sessionScope.user!=null}">
	<b>${sessionScope.user.uiName}님 반갑습니다.</b>
	<form method="post" action="/user">
		<input type="hidden" name="cmd" value="logout">
		<button>로그아웃</button>
	</form>
</c:if>
</body>
</html>