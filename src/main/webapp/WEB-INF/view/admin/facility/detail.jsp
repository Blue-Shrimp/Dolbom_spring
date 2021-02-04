<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/facility.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/facility.js"></script>
<script>
	if("${msg1}"){
		alert("시설 삭제가 실패되었습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="../a_header.jsp" />
		
		<div id="f_container">
			<jsp:include page="../a_aside.jsp" />
			
			<div class="main">
				<div class="contents">
					<div class="subHeader">
						<h3 id="srcTopTitle">시설 상세정보</h3>
					</div>
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
									<td class="w300">
										★${score }
									</td>
								</tr>
								<tr>
									<th scope="row">대표자</th>
									<td colspan="3">${detail.fname }</td>
								</tr>
								<tr>
									<th scope="row">주소</th>
									<td colspan="3">${detail.flocation }</td>
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
									<th scope="row">프로그램</th>
									<td colspan="3">${detail.fprogram }</td>
								</tr>
								</c:if>
								<c:if test="${!empty detail.fsimg}">
								<tr>
									<th scope="row">시설사진</th>
									<td colspan="3">
										<c:forTokens items="${detail.fsimg  }" delims="," var="item">
										    <img src="../../images/${item }">
										</c:forTokens>
									</td>
								</tr>
								</c:if>
							</tbody>
						</table>
					</div>
					<div class="rightBtn">
						<a href="update?fid=${fid }"><button type="button" class="nBtn" id="btnUpdate">수정</button></a>
						<a href="deleteProc.do?fid=${fid }"><button type="button" class="nBtn" id="btnDelete">삭제</button></a>
						<a href="list"><button type="button" class="nBtn">목록</button></a>
					</div>
				</div>
			</div>
		</div>
	
	<jsp:include page="../a_footer.jsp" />
</body>
</html>