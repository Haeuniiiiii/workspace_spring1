<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0102</title>
</head>
<body>
	<h2>home0102</h2>
	<table border="1">
		<tr>
			<td>사용자 아이디:</td>
			<td>${memberVO.memId}</td> 
		</tr>
		<tr>
			<td>사용자 패스워드:</td>
			<td>${memberVO.memPw}</td>
		</tr>
		<tr>
			<td>사용자 아이디:</td>
			<td><c:out value="${memberVO.memId}"/></td>
		</tr>
		<tr>
			<td>사용자 패스워드:</td>
			<td><c:out value="${memberVO.memPw}"/></td>
		</tr>
		<!--
			escapeXml: 속성의 기본값은 true이고 , 특수문자를 변환하여 출력(태그가 포함되어 있다면 태그가 나옴)
			escapeXml: 속성을 false로 설정 하면 태그를 인식하여 출력 
			태그가 태그의 역할을 하도록 출력된다. (escapeXml 속성의 값이 false일때)
		  -->
		<tr>
			<td>사용자 아이디:</td>
			<td><c:out value="${memberVO.memId}" escapeXml="false"/></td>
		</tr>
		<tr>
			<td>사용자 패스워드:</td>
			<td><c:out value="${memberVO.memPw}" default="12341234"/></td>
		</tr>
	</table>
</body>
</html>