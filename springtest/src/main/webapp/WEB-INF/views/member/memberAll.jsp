<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
<script>

</script>
</head>
<body>
	<h3 class="page_title">회원 전체</h3>
	<div>
	<ul class="search">
		<li>메일수신여부</li>
		<li>성별</li>
		<li><button type="button">검색</button></li>
	</ul>
	</div>
	
	<table id="members" border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>job</th>
				<th>reason</th>
				<th>gender</th>
				<th>hobby</th>
				<th>mailsend</th>
				<th>regdate</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="list">		
			<tr>
			<td>${list.id}</td>
			<td>${list.password }</td>
			<td>${list.job}</td>
			<td>${list.reason}</td>
			<td>${list.gender}</td>
			<td>${list.hobby}</td>
			<td>${list.mailsend}</td>
			<td>${list.regdate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>