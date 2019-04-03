<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("user")==null){
%>
	<script>
		alert("세션이 만료되었습니다.");
		location.href="/";
	</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화등록 페이지 입니다.</title>
</head>
<body>
<form method="post" action="/movie/insert" align="center">
	<table>
		<tr>
			<td>영화제목</td>
			<td><input type="text" name="mi_name"></td>
		</tr>
		<tr>
			<td>제작년도</td>
			<td><input type="text" name="mi_year"></td>
		</tr>
		<tr>
			<td>국가</td>
			<td><input type="text" name="mi_national"></td>
		</tr>
		<tr>
			<td>제작사</td>
			<td><input type="text" name="mi_vendor"></td>
		</tr>
		<tr>
			<td>영화감독</td>
			<td><input type="text" name="mi_director"></td>
		</tr>
		<tr>
			<td colspan="2"><button>영화등록</button></td>
		</tr>
	</table>
</form>
<a href="${rPath}/movie/list">영화개봉리스트</a><br>
<a href="${rPath}/views/movie/ajax_list">AJAX영화개봉리스트</a>
<a href="${rPath}/">main으로 가기 </a>
	

</body>
</html>