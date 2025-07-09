<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
        padding-top: 50px;
    }
    .study-table {
        max-width: 800px;
        margin: 0 auto;
        background-color: white;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        border-radius: 10px;
        overflow: hidden;
    }
    .study-table th, .study-table td {
        text-align: center;
        vertical-align: middle;
        padding: 15px;
        cursor: pointer;
    }
    .study-table th {
        background-color: #343a40;
        color: white;
        cursor: default;
    }
    .study-table tr:hover td {
        background-color: #f1f1f1;
    }
</style>
</head>
<body>
    <table class="table table-bordered study-table">
        <thead>
            <tr>
                <th>핵심키워드</th>
                <th>간단요약</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>WAS</td>
                <td>(Web Application Server)브라우저의 요청을 받아 동적 웹 콘텐츠를 처리 및 응답하는 서버</td>
            </tr>
            <tr>
                <td>Servlet</td>
                <td>WAS 위에서 작동하면서 HTTP 요청과 응답을 처리해주는 자바 클래스</td>
            </tr>
            <tr>
                <td>Spring</td>
                <td>전통적인 서블릿/JSP 개발의 불편함과 한계를 보완하기 위해 나온 프레임워크</td>
            </tr>
            <tr>
                <td>Bean</td>
                <td>쉽게 말하면 자바의 클래스</td>
            </tr>
        </tbody>
    </table>
    <div class="text-center mt-4">
      <a href="/spring.do" class="btn btn-primary btn-lg">스프링</a>
      <a href="/study.do" class="btn btn-info btn-lg">기존에 배운 스프링</a>
      <a href="/next.do" class="btn btn-warning btn-lg">현재 배우는 스프링</a>
    </div>
    



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
   
</script>
</body>
</html>
