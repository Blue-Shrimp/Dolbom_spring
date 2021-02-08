<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/benefit.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/benefit.js"></script>
<script>
	if("${msg1}"){
		alert("아동 상태 변경이 실패되었습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="../a_header.jsp" />
	
	<div id="a_container">
		<jsp:include page="../a_aside.jsp" />
		
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">수혜자 아동 상세정보</h3>
				</div>
				<div class="applySubTitle">신청정보</div>
				<form name="benefitDetailForm" action="benefit_update.do" method="post">
					<input type="hidden" name="aid" id="aid" value="${aid }">
					<div class="applyDetail" style="margin-bottom: 20px;">
						<table>
							<colgroup>
								<col class="w210">
								<col class="w830">
							</colgroup>
							<tbody>
								<tr>
									<th scope="row">처리상태</th>
									<td colspan="3">
										<select name="astatus" id="astatus" class="detail_status">
											<c:choose>
												<c:when test="${detail.astatus == 1 }">
												<option value="1" selected="selected">입소</option>
												<option value="3">퇴소</option>
												</c:when>
												<c:when test="${detail.astatus == 3 }">
												<option value="1">입소</option>
												<option value="3" selected="selected">퇴소</option>
												</c:when>
											</c:choose>
										</select>
									</td>
								</tr>
								<tr>
									<th class="w210">돌봄시설</th>
									<td class="w830" colspan="3">${detail.fpname }</td>
								</tr>
								<tr>
									<th class="w210">돌봄시간</th>
									<td class="w415">${detail.fstime } ~ ${detail.fetime }</td>
									<th class="w210">돌봄요일</th>
									<td class="w415">${detail.fweek }</td>
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
									<c:forTokens items="${detail.aperson  }" delims="/" var="child">
									<td>${child }</td>
									</c:forTokens>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="rightBtn">
						<button type="submit" class="nBtn" id="btnBenefitUpdate">저장</button>
						<a href="list"><button type="button" class="nBtn">목록</button></a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../a_footer.jsp" />
</body>
</html>