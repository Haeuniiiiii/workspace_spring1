<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0501</title>
</head>
<body>
	<c:if test="${memberVO.memId == null }">
		<p>memberVO.memId = null</p>
	</c:if>
	
	<c:if test="${memberVO.memId eq null }">
		<p>memberVO.memId eq null</p>
	</c:if>
	
	<c:if test="${memberVO.memId ne null }">
		<p>memberVO.memId ne null</p>
	</c:if>
	
	<c:if test="${!memberVO.foreigner }">
		<p>member.foreigner == true</p>
	</c:if>
</body>
</html>