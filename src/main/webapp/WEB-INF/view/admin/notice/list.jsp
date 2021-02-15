<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/notice.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/notice.js"></script>
<script>
	if("${msg1}"){
		alert("글 작성이 완료되었습니다.");	
	} else if("${msg2}"){
		alert("글 수정이 완료되었습니다.");	
	} else if("${msg3}"){
		alert("글 삭제가 완료되었습니다.");	
	} 
</script>
</head>
<body>

	<jsp:include page="../a_header.jsp" />
	
	<div id="n_container">
		<jsp:include page="../a_aside.jsp" />
		
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">공지사항</h3>
				</div>
				<form id="srchForm" name="srchForm" action="list" method="post">
					<div class="subSearchArea">
						<fieldset>
							<span class="srchIn">
								<input type="text" id="keyword" name="keyword" placeholder="검색어를 입력하세요.">
								<button type="submit" class="btnSearch" style="background: url(../../images/btn_srch.png) no-repeat 50% 50%"><span>검색</span></button>
							</span>
						</fieldset>
					</div>
			    </form>
			    <div class="aTypeListTbl mr_b30">
					<table>
						<colgroup>
							<col class="w80">
							<col class="w300">
							<col class="w80">
							<col class="w115">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="n" items="${list}">
							<tr>
								<td>${n.rno }</td>
								<td class="subject">
									<a href="detail?bid=${n.bid }">${n.btitle }</a>
								</td>
								<td>${n.bcharge }</td>
								<td>${n.bdate }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="write">
					<a href="write"><button type="button" class="ibtn">글쓰기</button></a>
				</div>
				<div id="pagingNav" class="paging">		
					<c:if test="${paging.startPage != 1 }">
						<a href="list?keyword=${keyword }&nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}" class="linkPrevPage" style="background: url(../../images/btn_prev.png) no-repeat 50% 50%;"></a>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b>${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a href="list?keyword=${keyword }&nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a href="list?keyword=${keyword }&nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}" class="linkNextPage" style="background: url(../../images/btn_next.png) no-repeat 50% 50%;"></a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../a_footer.jsp" />

</body>
</html>