<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-3">
  <h2>게시글 상세</h2>
  <input type="hidden" id="boardNo" name="boardNo" value="${boardVO.boardNo}"
  > 
<!--   <form action="/board/regist.do" method="post" id="boardRegistForm"> -->
  <form>
    <div class="mb-3 mt-3">
      <label for="boardTitle">게시글 제목</label>
      <input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${boardVO.boardTitle}" readonly>
    </div>
    <div class="mb-3">
      <label for="boardWriter">작성자</label>
      <input type="text" class="form-control" id="boardWriter" name="boardWriter" value="${boardVO.boardWriter}" readonly>
    </div>
    <div class="mb-3">
      <label for="boardContent">게시글 내용</label>
      <input type="text" class="form-control" id="boardContent" name="boardContent" value="${boardVO.boardContent}" readonly>
    </div>
    <div class="mb-3">
      <label for="regDt">등록일</label>
      <input type="text" class="form-control" id="regDt" name="regDt" value="${boardVO.regDt}" readonly>
    </div>
    <div class="mb-3">
      <label for="boardHit">조회수</label>
      <input type="text" class="form-control" id="boardHit" name="boardHit" value="${boardVO.boardHit}" readonly>
    </div>
    <button id="updateBtn" type="button" class="btn btn-warning">수정</button>
    <button id="saveBtn" type="button" class="btn btn-primary">저장</button>
    <button id="cancelBtn" type="button" class="btn btn-basic">취소</button>
    <button id="deleteBtn"type="button" class="btn btn-danger">삭제</button>
    <button id="listBtn"type="button" class="btn btn-secondary">목록</button>
  </form>
</div>
 	
 	
 	
 	
 	
 	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
  
<script>
	$(document).ready(function(){
		
		// 처음에는 저장버튼과 취소 버튼은 보이지 않음 
		$("#saveBtn").hide();
		$("#cancelBtn").hide();
		
		let boardNo = $("#boardNo").val();
		
		$("#listBtn").on("click", function(){
			location.href="<c:out value='/board/list.do'/>"
		});
		
		$("#deleteBtn").on("click", function(){
			if(confirm("게시글을 정말 삭제하시겠습니까?")){
				
				
				let data = {
						boardNo : boardNo
				}
				
				$.ajax({
					url: "<c:out value='/board/delete.do'/>",
					method:"post",
					data : JSON.stringify(data),
					contentType: "application/json; charset=UTF-8",
					success: function(result){
						if(result == "SUCCESS"){
							alert("게시글 삭제를 성공했습니다.");
							location.href = "<c:out value='/board/list.do'/>"
						}else{
							alert("삭제를 실패했습니다.\n다시 시도해주세요");
							return;
						}
					},
					error: function (xhr, error, status) {
						alert("비동기 통신 도중 에러가 발생했습니다.")
					}
					
				});
				
				
			}	
		});
		
		$("#updateBtn").on("click", function(){
			
			$("#saveBtn").show();
			$("#cancelBtn").show();
			
			$("#deleteBtn").hide();
			$("#listBtn").hide();
			
			let excludeIds = ["regDt", "boardHit"];
			
			$("input").each(function(index, input){
				let $input = $(input);
				let id = $input.attr("id");
				
				if($input.is("[readonly]") && !excludeIds.includes(id)){
					$input.removeAttr("readonly");
				}
				
			});
			
			
// 			let inputs = $("input");
//  			console.log(inputs);
			
// 			inputs.each(function(index, input){
//  				객체를 열때는 + 사용 하지말고 , 사용하기 alert는  +
//  				console.log(index +"번째 input 요소 : ",input);
// 				$(input).removeAttr("readonly");
						

			});
			
			$("#cancelBtn").on("click", function(){
				location.reload();
			
			});
			
			$("#saveBtn").on("click", function(){
			
				let boardTitle = $("#boardTitle").val();
				let boardWriter = $("#boardWriter").val();
				let boardContent = $("#boardContent").val();
			
				let data = {
						boardNo : boardNo,
						boardTitle : boardTitle,
						boardWriter : boardWriter,
						boardContent : boardContent
				}
				
				$.ajax({
					url: "<c:out value='/board/update.do'/>",
					method:"post",
					data : JSON.stringify(data),
					contentType: "application/json; charset=UTF-8",
					success: function(result){
						if(result != "SUCCESS"){
							alert("게시글 수정 성공했습니다.");
							$("#boardTitle").val(result.boardTitle);
							$("#boardWriter").val(result.boardWriter);
							$("#boardContent").val(result.boardContent);
							
							$("#saveBtn").hide();
							$("#cancelBtn").hide();
							
							$("#deleteBtn").show();
							$("#listBtn").show();
							
							let excludeIds = ["regDt", "boardHit"];
							
							$("input").each(function(index, input){
								let $input = $(input);
								let id = $input.attr("id");
								
								if(!$input.is("[readonly]") && !excludeIds.includes(id)){
									$input.attr("readonly", true);
								}
								
							});
							
							
						}else{
							alert("수정을 실패했습니다.\n다시 시도해주세요");
							return;
						}
					},
					error: function (xhr, error, status) {
						alert("비동기 통신 도중 에러가 발생했습니다.")
					}
				});
			});
			
		});
		
</script>  
  
</body>
</html>