<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/review.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/review.js"></script>
<script>
	if("${msg2}"){
		alert("후기 숨기기가 실패되었습니다.");	
	} else if("${msg4}"){
		alert("후기 숨기기 취소가 실패되었습니다.");	
	} 
</script>
</head>
<body>
	<jsp:include page="../a_header.jsp" />
		
		<div id="r_container">
			<jsp:include page="../a_aside.jsp" />
			
			<div class="main">
				<div class="contents">
					<div class="subHeader">
						<h3 id="srcTopTitle">시설후기 관리 상세정보</h3>
					</div>
					<div class="reviewDetail">
						<table>
							<colgroup>
								<col class="w210">
								<col class="w830">
							</colgroup>
							<tbody>
								<tr>
									<th scope="row" class="w210">숨김여부</th>
									<c:choose>
										<c:when test="${detail.rstatus == 0 }">
										<td>o</td>
										</c:when>
										<c:when test="${detail.rstatus == 1 }">
										<td>x</td>
										</c:when>
									</c:choose>
									<th scope="row" class="w210">시설명</th>
									<td class="w415">${detail.fpname}</td>
								</tr>
								<tr>
									<th scope="row" class="w210">작성자</th>
									<td class="w415">${detail.dname }</td>
									<th scope="row" class="w210">작성일자</th>
									<td class="w415">${detail.rdate }</td>
								</tr>
								<tr style="height: 300px">
									<th scope="row" class="w210">리뷰내용</th>
									<td colspan="3">${detail.rcontent }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="rightBtn">
						<c:choose>
							<c:when test="${detail.rstatus == 0 }">
							<a href="hideCancelProc.do?rid=${rid }"><button type="button" class="nBtn" id="btnHide">숨기기취소</button></a>
							</c:when>
							<c:when test="${detail.rstatus == 1 }">
							<a href="hideProc.do?rid=${rid }"><button type="button" class="nBtn" id="btnHide">숨기기</button></a>
							</c:when>
						</c:choose>
						<a href="list"><button type="button" class="nBtn">목록</button></a>
					</div>
				</div>
			</div>
		</div>
		
	<jsp:include page="../a_footer.jsp" />
</body>
</html>