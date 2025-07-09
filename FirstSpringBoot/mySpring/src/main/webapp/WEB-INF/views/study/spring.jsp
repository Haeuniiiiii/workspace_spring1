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
                <td>Bean</td>
                <td>스프링에서 빈으로 등록되면 해당 클래스를 스프링이 관리</td>
            </tr>
            <tr>
                <td>ViewResolver</td>
                <td>Mapping 어노테이션이 붙은 컨트롤러의 반환값을 대상으로 작동</td>
            </tr>
            <tr>
                <td>Annotation</td>
                <td>빈으로 등록된 자바 클래스들은 특정 어노테이션들의 기능을 누릴 수 있음</td>
            </tr>
            <tr>
                <td>Spring</td>
                <td>전통적인 서블릿/JSP 개발의 불편함과 한계를 보완하기 위해 나온 프레임워크</td>
            </tr>
        </tbody>
    </table>
    <div class="text-center mt-4">
      <a href="/start.do" class="btn btn-primary btn-lg">메인</a>
    </div>
    



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
   
</script>
</body>
</html>
