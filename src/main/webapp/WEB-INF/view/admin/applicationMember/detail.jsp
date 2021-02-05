<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/application.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/application.js"></script>
</head>
<body>
	<jsp:include page="../a_header.jsp" />
	
	<div id="a_container">
		<jsp:include page="../a_aside.jsp" />
		
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">신청 아동 상세 정보</h3>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../a_footer.jsp" />
</body>
</html>