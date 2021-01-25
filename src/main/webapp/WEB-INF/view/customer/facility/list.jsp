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
					<h3 id="srcTopTitle">돌봄 시설조회</h3>
				</div>
				<div class="unified-search">
					<form id="detailSearchForm" name="detailSearchForm" method="post" action="list">
						<div class="search-box search-input">
							<div class="search-sort">
								<div class="sch-rgt search-full" id="location">
									<select name="sido" id="sido" class="org_s">
									</select>
									<select name="gugun" id="gugun" class="org_s">
									</select>
									<input type="text" name="keyword" id="keyword" value="${keyword }" placeholder="시설명을 입력해주세요">
									<span class="ibtn form navy" id="lifecycleAreaSearchBtn">
										<button type="submit" id="btnSearch">검색</button>
									</span>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="facilityList">
					<table>
						<colgroup>
							<col class="w40">
							<col class="w300">
							<col class="w400">
							<col class="w140">							
							<col class="w80">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">시설명</th>
								<th scope="col">주소</th>
								<th scope="col">모집현황</th>
								<th scope="col">평점</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="n" items="${list}">
							<tr>
								<td>${n.rno }</td>
								<td><a href="detail?fid=${n.fid }">${n.fpname }</a></td>
								<td>${n.flocation }</td>
								<td>현원 ${n.fcnt }명 / 정원 ${n.fpeople }명</td>
								<td>★ ${n.fservice }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="pagingNav" class="paging">		
					<c:if test="${paging.startPage != 1 }">
						<a href="list?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}" class="linkPrevPage" style="background: url(../../images/btn_prev.png) no-repeat 50% 50%;"></a>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b>${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a href="list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a href="list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}" class="linkNextPage" style="background: url(../../images/btn_next.png) no-repeat 50% 50%;"></a>
					</c:if>
				</div>
			</div>
		</div>
	</div>	
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>