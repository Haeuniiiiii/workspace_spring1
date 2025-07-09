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
    /* 모달 내용 가독성 및 줄바꿈 처리 */
    #modalDesc {
        white-space: pre-line; /* 실제 줄바꿈 인식 */
        font-size: 1.1rem;
        color: #333;
    }
</style>
</head>
<body>

    <table class="table table-bordered study-table">
        <thead>
            <tr>
                <th>항목</th>
                <th>STS</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Framework</td>
                <td data-desc="Spring Boot는 기존의 XML 설정 파일을 대체하고,
application.properties 파일과 자동 설정 기능으로 애플리케이션 구성을 간편하게 합니다.">
                    Spring Boot
                </td>
            </tr>
            <tr>
                <td>DataSource</td>
                <td data-desc="MyBatis는 SQL을 직접 작성하여 사용하는 데이터 매핑
                   프레임워크로, 복잡한 쿼리 처리나 성능 최적화에
                    유리합니다.">
                    MyBatis
                </td>
            </tr>
            <tr>
                <td>Architecture</td>
                <td data-desc="기존 Servlet에서 SpringBoot가 추가되어
보다 객체지향 mvc패턴에 맞게 개발하기 좋아졌습니다.">
                    MVC
                </td>
            </tr>
            <tr>
                <td>buildTool</td>
                <td data-desc="Gradle에서 Maven으로 바뀌었기에
build.gradle에서 POM.XML 형태의 설정파일로 바뀝니다.">
                    Maven
                </td>
            </tr>
        </tbody>
    </table>
    <div class="text-center mt-4">
      <a href="/start.do" class="btn btn-primary btn-lg">메인</a>
    </div>
    

    <!-- Modal -->
    <div class="modal fade" id="detailModal" tabindex="-1" aria-labelledby="detailModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="detailModalLabel">설명</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <p id="modalDesc" class="mb-0"></p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    $(document).ready(function () {
        $('.study-table td[data-desc]').on('click', function () {
            const desc = $(this).data('desc');
            $('#modalDesc').text(desc);  // text()로 넣어야 줄바꿈 인식됨
            const modal = new bootstrap.Modal(document.getElementById('detailModal'));
            modal.show();
        });
    });
</script>
</body>
</html>
