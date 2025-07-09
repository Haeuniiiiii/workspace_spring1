<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
</head>
<body>

<div class="container mt-3">
  <h2>게시글 등록</h2>
<!--   <form action="/board/regist.do" method="post" id="boardRegistForm"> -->
  <form>
    <div class="mb-3 mt-3">
      <label for="boardTitle">게시글 제목</label>
      <input type="text" class="form-control" id="boardTitle" placeholder="제목을 입력해주세요" name="boardTitle">
    </div>
    <div class="mb-3">
      <label for="boardWriter">작성자</label>
      <input type="text" class="form-control" id="boardWriter" placeholder="작성자를 입력해주세요" name="boardWriter">
    </div>
    <div class="mb-3">
      <label for="boardContent">게시글 내용</label>
      <input type="text" class="form-control" id="boardContent" placeholder="내용을 입력해주세요" name="boardContent">
    </div>
    <button id="cancleBtn" type="button" class="btn btn-danger">취소</button>
    <button id="registBtn"type="button" class="btn btn-primary">등록</button>
  </form>
</div>
 	
 	
 	
 	
 	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	// 취소버튼 클릭 이벤트
	$("#cancleBtn").on("click",function(){
		if(confirm("목록으로 돌아가시겠습니까?\n진행중인 작성은 저장되지 않습니다.")){
			location.href = "<c:out value='/board/list.do'/>";
		}
		
	});
	// 등록버튼 클릭 이벤트 
	$("#registBtn").on("click",function(){
// 		boardTitle
// 		boardWriter	
// 		boardContent
		
		let boardTitle = $("#boardTitle").val();
		let boardWriter = $("#boardWriter").val();
		let boardContent = $("#boardContent").val();
		
// 		console.log("boardTitle ::: ", boardTitle);
// 		console.log("boardWriter ::: ", boardWriter);
// 		console.log("boardContent ::: ", boardContent);
		
		if(boardTitle == null || boardTitle.trim() == ''){
			alert("게시글 제목이 누락되었습니다.");
			$("#boardTitle").focus();
			return;
		}
		if(boardWriter == null || boardWriter.trim() == ''){
			alert("작성자가 누락되었습니다.");
			$("#boardWriter").focus();
			return;
		}
		if(boardContent == null || boardContent.trim() == ''){
			alert("게시글 내용이 누락되었습니다.");
			$("#boardContent").focus();
			return;
		}
		
// 		$("#boardRegistForm").submit();
		
		let data = {
			boardTitle : boardTitle,
			boardWriter : boardWriter,
			boardContent : boardContent
		}
		
		$.ajax({
			url: "<c:out value='/board/regist.do'/>",
			method:"post",
			data : JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			success: function(result){
				if(result == "SUCCESS"){
					alert("게시글 등록에 성공했습니다.");
					location.href = "<c:out value='/board/list.do'/>"
				}else{
					alert("등록에 실패했습니다.\n다시 시도해주세요");
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