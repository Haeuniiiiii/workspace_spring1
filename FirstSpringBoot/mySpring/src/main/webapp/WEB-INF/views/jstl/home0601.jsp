<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0601</title>
</head>
<body>
	<c:choose>
		<c:when test="${memberVO.gender == 'M' }"><!--  반복되면 else if -->
			<p>남자</p>
		</c:when> 
		<c:otherwise> <!--  else -->
			<p>여자</p>
		</c:otherwise> 
	</c:choose>
</body>
</html>