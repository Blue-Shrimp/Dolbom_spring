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
		alert("아동 상태가 변경되었습니다.");	
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
					<h3 id="srcTopTitle">수혜자 아동 관리</h3>
				</div>
				<form id="detailSearchForm" name="detailSearchForm" method="post" action="list">
					<div class="search-box search-input">
						<div class="search-sort">
							<div class="sch-rgt search-full" id="location">
								<span class="schTitle">처리상태</span>
								<select name="status" id="status" class="org_s">
									<option value="">전체</option>
									<option value="1">입소</option>
									<option value="3">퇴소</option>
								</select>
								<span class="schTitle">시설명</span>
								<input type="text" class="facilityInput" name="facility" id="facility" value="" placeholder="시설명을 입력해주세요">
								<span class="schTitle">성명</span>
								<input type="text" class="nameInput" name="name" id="name" value="" placeholder="성명">
								<span class="ibtn form navy" id="lifecycleAreaSearchBtn">
									<button type="submit" id="btnSearch">검색</button>
								</span>
							</div>
						</div>
					</div>
				</form>
			    <div class="aTypeListTbl mr_b30">
					<table>
						<colgroup>
							<col class="w80">
							<col class="w115">
							<col class="w115">
							<col class="w80">
							<col class="w300">
							<col class="w80">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">아동</th>
								<th scope="col">생년월일</th>
								<th scope="col">성별</th>
								<th scope="col">시설명</th>
								<th scope="col">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="n" items="${list}">
							<tr>
								<td>${n.rno }</td>
								<c:forTokens items="${n.aperson  }" delims="/" var="child" varStatus="s">
								<c:if test="${s.count == 1}">
								<td><a href="detail?aid=${n.aid }">${child }</a></td>
								</c:if>
								<c:if test="${s.count == 2}">
								<td>${child }</td>
								</c:if>
								<c:if test="${s.count == 3}">
								<td>${child }</td>
								</c:if>
								</c:forTokens>
								<td class="subject">${n.fpname }</td>
								<c:choose>
									<c:when test="${n.astatus == 1 }">
									<td>입소</td>
									</c:when>
									<c:when test="${n.astatus == 3 }">
									<td>퇴소</td>
									</c:when>
								</c:choose>
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
	
	<jsp:include page="../a_footer.jsp" />
</body>
</html>