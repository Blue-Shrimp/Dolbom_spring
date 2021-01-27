<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
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
					<h3 id="srcTopTitle">돌봄 시설 신청</h3>
				</div>
				<div class="applySubTitle">
					신청인 정보
				</div>
				<form name="facilityApplyForm" action="apply_proc.do" method="post">
					<div class="facilityDetail" style="margin-bottom: 20px;">
						<table>
							<colgroup>
								<col class="w210">
								<col class="w830">
							</colgroup>
							<tbody>
								<tr>
									<th scope="row">신청인</th>
									<td colspan="3">${member.dname }</td>
								</tr>
								<tr>
									<th scope="row">신청인 연락처</th>
									<td colspan="3">${member.dphone }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="applySubTitle">
						수혜 아동 선택
					</div>
					<div class="facilityList fapplication">
						<table>
							<colgroup>
								<col class="w100">
								<col class="w300">
								<col class="w300">
								<col class="w300">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">선택</th>
									<th scope="col">성명</th>
									<th scope="col">생년월일</th>
									<th scope="col">성별</th>
								</tr>
							</thead>
							<tbody>
								<c:forTokens items="${member.dchildren  }" delims="," var="children">
								<tr>
									<td><input type="radio" name="child" value="" class="click"></td>
									<c:forTokens items="${children }" delims="/" var="child">
									<td>${child }</td>
									</c:forTokens>
								</tr>
								</c:forTokens>
							</tbody>
						</table>
					</div>
					<div class="applySubTitle">
						시설 정보
					</div>
					<div class="facilityDetail">
						<table>
							<colgroup>
								<col class="w210">
								<col class="w830">
							</colgroup>
							<tbody>
								<tr>
									<th scope="row">시설명</th>
									<td colspan="3">${facility.fpname }</td>
								</tr>
								<tr>
									<th scope="row">주소</th>
									<td colspan="3">${facility.flocation }</td>
								</tr>
								<tr>
									<th scope="row">시간/요일</th>
									<td colspan="3">${facility.fstime } ~ ${facility.fetime } / ${facility.fweek }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="btn_apply">
						<input type="hidden" id="aperson" name="aperson" value="">
						<input type="hidden" name="fid" id="fid" value="${fid }">
						<input type="hidden" name="did" id="did" value="${did }">
						<button type="button" class="ibtn" id="btnApplication">신청하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>