<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0901</title>
</head>
<body>
	<p>특정 URL의 결과를 읽어와서 현재 위치에 삽입한다</p>
	<p>절대 URL</p>
	<c:import url="http://localhost:8080/jstl/home0201"/>
	
	<c:import url="http://localhost:8080/jstl/home0201">
		<c:param name="memId" value="sunshin"/>
	</c:import>
</body>
</html>