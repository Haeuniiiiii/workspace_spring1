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
        max-width: 900px;
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
    /* 모달 내용 줄바꿈 가독성 */
    #modalDesc {
        white-space: pre-line; /* 줄바꿈 처리 */
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
				<th>IntelliJ</th>
				<th>STS</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td data-desc="프레임워크란 애플리케이션 개발을 쉽게 해주는 기본 뼈대로, 반복되는 작업을 줄이고  일정한 규칙에 따라 개발할 수 있게 도와주는 도구">
                    Framework
                </td>
				<td data-desc="Spring Boot는 설정이 간편하며, 내장 톰캣 서버와 스타터 의존성 제공으로 빠르게 웹 애플리케이션을 개발할 수 있습니다.">
				    Spring Boot
				</td>
				<td data-desc="Spring Framework는 XML이나 Java 기반의 설정으로 유연하게 구성할 수 있으며, 전통적인 프로젝트에 많이 사용됩니다.">
				    Spring Framework
				</td>
			</tr>
			<tr>
				<td data-desc="DataSource는 JDBC, JPA, MyBatis 등에서 공통적으로 사용하는 DB 연결 정보의 기반이며,
스프링이 ORM이나 데이터 처리 기술들이 실제로 DB에 접근할 수 있도록 연결을 책임지는 역할을 합니다.">
                    DataSource
                </td>
				<td data-desc="JPA(Java Persistence API)는 자바 ORM 표준 기술로, 객체 지향적으로 데이터베이스를 다룰 수 있습니다. 코드가 간결하고 유지보수가 쉽습니다.">
				    JPA
				</td>
				<td data-desc="MyBatis는 SQL을 직접 작성하여 사용하는 데이터 매핑 프레임워크로, 복잡한 쿼리 처리나 성능 최적화에 유리합니다.">
				    MyBatis
				</td>
			</tr>
			<tr>
				<td data-desc="아키텍처는 시스템의 구성, 동작 원리, 요소 간 관계, 외부 환경과의 관계 등을 정의하는 설계 또는 청사진을 의미">
                    Architecture
                </td>
				<td data-desc="MVC(Model-View-Controller)는 역할을 분리하여 유지보수가 용이하고, 테스트와 확장이 쉬운 웹 애플리케이션 구조입니다.">
				    MVC
				</td>
				<td data-desc="STS(Spring Tool Suite)도 전형적인 MVC 패턴을 지원하며, 다양한 스프링 모듈과 연계해 개발 효율을 높입니다.">
				    MVC
				</td>
			</tr>
			<tr>
				<td data-desc="컴파일, 패키징, 의존성 관리, 테스트 자동화 , 배포 자동화, 플러그인 관리등을 담당합니다.">
                    buildTool
                </td>
				<td data-desc="Gradle은 Groovy 또는 Kotlin DSL을 사용하여 선언적 빌드 구성이 가능하며, 빌드 속도가 빠르고 의존성 관리가 유연합니다.
(build.gradle)">
				    Gradle
				</td>
				<td data-desc="Maven은 표준화된 디렉토리 구조와 XML 설정 파일을 기반으로 하며, 널리 쓰이는 안정적인 빌드 도구입니다.
(POM.XML)">
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
			$('#modalDesc').text(desc);
			const modal = new bootstrap.Modal(document.getElementById('detailModal'));
			modal.show();
		});
	});
</script>
</body>
</html>
