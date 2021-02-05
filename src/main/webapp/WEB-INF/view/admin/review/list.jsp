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
	if("${msg1}"){
		alert("후기 숨기기가 완료되었습니다.");	
	} else if("${msg3}"){
		alert("후기 숨기기가 취소되었습니다.");	
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
					<h3 id="srcTopTitle">시설후기 관리</h3>
				</div>
				<form id="srchForm" name="srchForm" action="list" method="post">
					<div class="subSearchArea">
						<fieldset>
							<span class="srchIn">
								<input type="text" id="keyword" name="keyword" placeholder="작성자 또는 내용을 입력하세요.">
								<button type="submit" class="btnSearch" style="background: url(../../images/btn_srch.png) no-repeat 50% 50%"><span>검색</span></button>
							</span>
						</fieldset>
					</div>
			    </form>
			    <div class="aTypeListTbl mr_b30">
					<table>
						<colgroup>
							<col class="w80">
							<col class="w250">
							<col class="w300">
							<col class="w80">
							<col class="w115">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">작성자</th>
								<th scope="col">시설명</th>
								<th scope="col">리뷰내용</th>
								<th scope="col">숨김여부</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="n" items="${list}">
							<tr>
								<td>${n.dname }</td>
								<td class="subject">${n.fpname }</td>
								<td class="subject">
									<a href="detail?rid=${n.rid }">${n.rcontent }</a>
								</td>
								<c:choose>
									<c:when test="${n.rstatus == 0 }">
									<td>o</td>
									</c:when>
									<c:when test="${n.rstatus == 1 }">
									<td>x</td>
									</c:when>
								</c:choose>
								<td>${n.rdate }</td>
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