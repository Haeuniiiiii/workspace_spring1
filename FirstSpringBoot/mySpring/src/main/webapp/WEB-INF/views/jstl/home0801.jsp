<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0801</title>
</head>
<body>									 <!--구분자 -->
	<c:forTokens items="${memberVO.hobby }" delims="," var="hobby">
		${hobby} <br/> 
	</c:forTokens>
</body>
</html>