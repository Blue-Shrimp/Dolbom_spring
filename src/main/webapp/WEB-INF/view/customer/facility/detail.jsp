<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템</title>
<link rel="stylesheet" href="../../css/facility.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/facility.js"></script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="f_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">돌봄 시설 상세정보</h3>
				</div>
				<form name="facilityForm" method="post" action="application">
					<input type="hidden" name="fid" id="fid" value="${fid }">
					<input type="hidden" name="did" id="did" value="${did }">
					
					<div class="facilityDetail">
						<table>
							<colgroup>
								<col class="w210">
								<col class="w830">
							</colgroup>
							<tbody>
								<tr>
									<th scope="row" class="w210">시설명</th>
									<td class="w830">${detail.fpname }</td>
									<th scope="row" class="w210">평점</th>
									<td class="w300">★${detail.fservice }<button class="navyBtn" type="button" id="btnReview">이용후기</button></td>
								</tr>
								<tr>
									<th scope="row">대표자</th>
									<td colspan="3">${detail.fname }</td>
								</tr>
								<tr>
									<th scope="row">주소</th>
									<td colspan="3">${detail.flocation }<button class="navyBtn" type="button" id="btnLocation">지도보기</button></td>
								</tr>
								<tr>
									<th scope="row">연락처</th>
									<td colspan="3">${detail.fphone }</td>
								</tr>
								<tr>
									<th scope="row">돌봄시간</th>
									<td colspan="3">${detail.fstime } ~ ${detail.fetime } / ${detail.fweek }</td>
								</tr>
								<c:if test="${!empty detail.fprogram}">
								<tr>
									<th scope="row">돌봄프로그램</th>
									<td colspan="3">${detail.fprogram }</td>
								</tr>
								</c:if>
								<c:if test="${!empty detail.fsimg}">
								<tr>
									<th scope="row">시설사진</th>
									<td colspan="3">${detail.fsimg }</td>
								</tr>
								</c:if>
							</tbody>
						</table>
					</div>
					<div class="btn_apply">
						<button type="submit" class="ibtn" id="btnApply">신청하기</button>
						<div class="rightBtn">
							<a href="list" class="btnWhite" id="btnList">목록</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>