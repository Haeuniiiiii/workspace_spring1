<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0201</title>
</head>
<body>
	
	<c:set value="${memberVO.memId}" var="id"/>
	<table border="1">
		<tr>
			<td>memId</td>
			<td>${id}</td>
		</tr>
	</table>

	<c:set var="memId">${memberVO.memId}</c:set>
	<table border="1">
		<tr>
			<td>memId</td>
			<td>${memId}</td>
		</tr>
	</table>

</body>
</html>