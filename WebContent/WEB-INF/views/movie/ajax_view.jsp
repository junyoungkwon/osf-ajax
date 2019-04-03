<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="rDiv"></div>
<c:if test="${sessionScope.user!=null }">
	<button onclick="deleteMovie()">삭제</button>
</c:if>


	<table border="1">
		<tr>
			<th>번호</th>
			<th>영화명</th>
			<th>년도</th>
			<th>국가</th>
			<th>제작사</th>
			<th>감독</th>
		</tr>
		<tbody id="tbody">
		</tbody>
	</table>
	<script>
		function deleteMovie(){
			xhr.open('post', '/am/delete');
			xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			xhr.onreadystatechange = function(){
				if (xhr.readyState == 4 && xhr.status == 200) {
					var result = JSON.parse(xhr.response);	
					alert(result.msg);
					if(result.url){
						location.href = result.url;
					}
				}
			}
			xhr.send('mi_num=${param.mi_num}');
		}
	
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/am/${param.mi_num}');
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var movie = JSON.parse(xhr.response);
				var html = '';
				html += '<tr>';
				html += '<td>' + movie['miNum'] + '</td>';
				html += '<td>' + movie['miName'] + '</td>';
				html += '<td>' + movie['miYear'] + '</td>';
				html += '<td>' + movie['mivendor'] + '</td>';
				html += '<td>' + movie['miNational'] + '</td>';
				html += '<td>' + movie['miDirector'] + '</td>';
				html += '</tr>'
				document.querySelector('#tbody').innerHTML = html;
			}
		}
		xhr.send();
		
	</script>
	<a href="${rPath}/movie/list">영화개봉리스트</a><br>
	<a href="${rPath}/views/movie/ajax_list">AJAX영화개봉리스트</a>
	<a href="${rPath}/">main으로 가기 </a>


</body>
</html>