<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템</title>
<link rel="stylesheet" href="../../css/notice.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/notice.js"></script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="n_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">공지사항</h3>
				</div>
				<div class="aTypeDetailArea">
					<div class="detailTitle">
						<h4>
							<span>${detail.btitle }</span>
						</h4>
						<dl>
							<dt><img src="../../images/icon_user.png" alt="작성자"></dt>
							<dd><span>${detail.bcharge }</span></dd>
							<dt><img src="../../images/icon_time.png" alt="작성일"></dt>
							<dd><span>${detail.bdate }</span></dd>							
						</dl>
					</div>
					<c:if test="${detail.bfile != null }">
					<div class="detailAddFile">
						<div>
							<ul>
								<li>
									<a href="fileDown?FILE_NAME=${detail.bsfile }"  class="fileDown" style="background: url(../../images/ico_file.png) no-repeat left 50%">${detail.bfile }</a>
								</li>
							</ul>
						</div>
					</div>
					</c:if>
					<div class="detailView">
						<div id="CONTENTS">
							<p>${detail.bcontent }</p>
						</div>
					</div>
					<div class="btnArea2">
						<a href="list"><button type="button" class="btnWhite">목록</button></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>