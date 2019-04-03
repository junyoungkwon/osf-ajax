<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화개봉리스트</title>
</head>
<body>
	<table border="1" id="movieTable">
		<tr onmouseout="this.style.backgroundColor='yellow'">
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
	<c:if test="${sessionScope.user!=null}">
		<a href="/WEB-INF/views/movie/insert">개봉 영화 등록</a>
	</c:if>
	
	<script>
		var xhr = new XMLHttpRequest();
		xhr.open('GET','/am/list');
		xhr.onreadystatechange = function (){
			if(xhr.readyState==4 && xhr.status==200){
				var list = JSON.parse(xhr.response);
				var html='';
				for(var movie of list){
					html += '<tr onmouseover="this.style.background=\'red\'"';
					html += ' onmouseout="this.style.background=\'\'"';
					html += ' onclick="goPage(' + movie['miNum'] + ')"';
					html += ' >'
					html += '<td>' + movie['miNum'] + '</td>';
					html += '<td>' + movie['miName'] + '</td>';
					html += '<td>' + movie['miYear'] + '</td>';
					html += '<td>' + movie['miNational'] + '</td>';
					html += '<td>' + movie['miVendor'] + '</td>';
					html += '<td>' + movie['miDirector'] + '</td>';
					html += '</tr>';
				}
				document.querySelector('#tbody').innerHTML = html;
			}
		}
		xhr.send();
		
	function goPage(mi_num){
		location.href='/views/movie/ajax_view?mi_num='+mi_num;
		
	} 
	</script>
	<a href="${rPath}/movie/list">영화개봉리스트</a><br>
	<a href="${rPath}/views/movie/ajax_list">AJAX영화개봉리스트</a>
	<a href="${rPath}/">main으로 가기 </a>
</body>
</html>

