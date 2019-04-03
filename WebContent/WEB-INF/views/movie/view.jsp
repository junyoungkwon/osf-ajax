<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${movie.miName}을 검색하셨습니다.</title>
</head>
<body>
	<c:if test="${movie==null}">
		조회하신 번호는 없는 번호입니다.
		<a href="/movie/list">리스트로 돌아가기</a>
	</c:if>
	<c:if test="${movie!=null}">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>${movie.miNum}</td>
			</tr>
			<tr>
				<td>영화 제목</td>
				<td>${movie.miName}</td>
			</tr>
			<tr>
				<td>년도</td>
				<td>${movie.miYear}</td>
			</tr>
			<tr>
				<td>국가</td>
				<td>${movie.miNational}</td>
			</tr>
			<tr>
				<td>제작사</td>
				<td>${movie.miVendor}</td>
			</tr>
			<tr>
				<td>감독</td>
				<td>${movie.miDirector}</td>
			</tr>
		</table>
	
		<c:if test="${sessionScope.user!=null}">
			<form method="post" action="/movie/delete">
				<input type="hidden" name="mi_num" value="${movie.miNum}">
				<button>삭제</button>
			</form>
		</c:if>
	</c:if>
<a href="${rPath}/movie/list">영화개봉리스트</a><br>
<a href="${rPath}/views/movie/ajax_list">AJAX영화개봉리스트</a>
<a href="${rPath}/">main으로 가기 </a>

</body>
</html>