<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<style type="text/css">
	.btn-group-wrapper{
		display: flex;
		justify-content: flex-end;
		margin-top: 10px;
		margin-right: 10px;
	}
	.boardInfo:hover{
		cursor: pointer;
	}
</style>
</head>
<body>
 	
<table class="table table-hover">
	<thead>
		<tr>
			<th>순번</th>		
			<th>제목</th>		
			<th>작성자</th>		
			<th>등록일</th>		
			<th>조회수</th>		
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${boardList}" var="board">
		<!-- data-boardno 같은 커스텀 속성에는 대문자 x -->
		<tr data-boardno="${board.boardNo}" class="boardInfo">
			<td>${board.rno}</td>
			<td>${board.boardTitle}</td>
			<td>${board.boardWriter}</td>
			<td>${board.regDt}</td>
			<td>${board.boardHit}</td>
		</tr>
		</c:forEach>
	</tbody>
</table> 	
<div class="btn-group-wrapper">
	<div class="btn-group">
		<button id="registBtn" class="btn btn-primary">등록</button>
	</div> 	
</div>
 	
 	
 	
 	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script>
	
	// 전역변수 
 	$(document).ready(function(){
 		// 등록버튼 클릭 이벤트
 		$("#registBtn").on("click", function(){
			 location.href = "<c:out value='/board/regist.do'/>"			
 		});
 		
		$(".boardInfo").on("click", function(){
// 			console.log($(this).attr("id"));
			let boardNo = $(this).data("boardno");
			location.href="/board/detail.do?boardNo=" + boardNo;
			
		});
 	});
</script>
</body>
</html>