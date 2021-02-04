<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../css/admin/index.css">
<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../js/admin/index.js"></script>
<script>
	if("${msg1}"){
		alert("로그아웃에 실패했습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div id="container">
		<jsp:include page="aside.jsp" />
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">사이트맵</h3>
				</div>
				<div class="siteMap">
					<ul>
						<li class="mapTitle">
							<div class="cap">시설관리</div>
							<ul>
								<li><a href="facility/list">시설조회</a></li>
								<li><a href="facility/write">시설등록</a></li>
								<li><a href="review/list">시설후기 관리</a></li>
							</ul>
						</li>
						<li class="mapTitle">
							<div class="cap">아동관리</div>
							<ul>
								<li><a href="applicationMember/list">신청 아동 관리</a></li>
								<li><a href="benefitMember/list">수혜자 아동 관리</a></li>
							</ul>
						</li>
						<li class="mapTitle">
							<div class="cap">커뮤니티관리</div>
							<ul>
								<li><a href="notice/list">공지사항 관리</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>