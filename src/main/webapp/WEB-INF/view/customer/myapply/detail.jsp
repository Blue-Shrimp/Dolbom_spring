<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템</title>
<link rel="stylesheet" href="../../css/myapply.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/myapply.js"></script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="a_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">돌봄 신청 상세정보</h3>
				</div>
				<div class="applySubTitle">
					신청인 정보
				</div>
				<div class="applyDetail">
					<table>
						<colgroup>
							<col class="w210">
							<col class="w830">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">신청일시</th>
								<td colspan="3">${vo.adate }</td>
							</tr>
							<tr>
								<th scope="row" class="w210">접수번호</th>
								<td class="w415">${aid }</td>
								<th scope="row" class="w210">신청인</th>
								<td class="w415">${vo.dname }</td>
							</tr>
							<tr>
								<th scope="row">시설명</th>
								<td colspan="3">${vo.fpname }</td>
							</tr>
							<tr>
								<th scope="row" class="w210">돌봄시간</th>
								<td class="w415">${vo.fstime } ~ ${vo.fetime }</td>
								<th scope="row" class="w210">처리상태</th>
								<c:choose>
									<c:when test="${vo.astatus == 0 }">
										<td>접수</td>
									</c:when>
									<c:when test="${vo.astatus == 1 }">
										<td>승인</td>
									</c:when>
									<c:when test="${vo.astatus == 2 }">
										<td>취소</td>
									</c:when>
								</c:choose>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="applySubTitle">
					수혜자 정보
				</div>
				<div class="applyList">
					<table>
						<colgroup>
							<col class="w300">
							<col class="w300">
							<col class="w300">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">성명</th>
								<th scope="col">생년월일</th>
								<th scope="col">성별</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forTokens items="${vo.aperson }" delims="/" var="child">
								<td>${child }</td>
								</c:forTokens>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_apply">
					<c:if test="${vo.astatus == 0 }">
					<a href="applyDelete_proc.do?aid=${aid }"><button type="button" class="ibtn" id="btnCancel">신청취소</button></a>
					</c:if>
					<a href="list"><button type="button" class="btnWhite" id="btnList">목록</button></a>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>