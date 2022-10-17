<%@page import="cs.dit.board.BoardDto"%>
<%@page import="cs.dit.board.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="container"><br>	
	<h2 class="text-center font-weight-bold">게시판 목록</h2>
	<br>
	<table class="table table-hover">
		<tr>
			<th>num</th>
			<th>subject</th>
			<th>writer</th>
			<th>regDate</th>
		</tr>

		<c:forEach var='dto' items='${dtos}'>
			<tr>
				<td>${dto.bcode }</td>
				<td><a href="updateForm.jsp?bcode=${dto.bcode}">${dto.subject}</a></td>
				<td>${dto.writer}</td>
				<td><fmt:formatDate value="${dto.regDate}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<input type="button" value ="홈으로" onclick ="location.href='index.do'">
	<input type="button" value ="게시글 등록" onclick ="location.href='insertForm.do'">
	</div>	
		<div class="container">
	  <ul class="pagination">
		  <c:if test="${startNum <= 1 }">
		  	<li class="page-item"><a class="page-link" href="#" onclick="alert('페이지가 없습니다')">Previous</a></li>
		  </c:if>
		  <c:if test="${startNum > 1 }">
		  	<li class="page-item"><a class="page-link" href="list.do?p=${startNum-1}">Previous</a></li>
		  </c:if>
	      <c:forEach var="i" begin="0" end="${numofPages - 1}">
	      	<li class="page-item"><a class="page-link" href="list.do?p=${startNum+i}">${startNum+i}</a></li>
	      </c:forEach>
	      <!-- 넥스트 페이지 해결하셈 -->
		  <c:forEach var="i" begin="0" end="${numofPages - 1}">
	      	<li class="page-item"><a class="page-link" href="#">Next</a></li>
	      </c:forEach>  
	  </ul>
	</div>
</body>
</html>