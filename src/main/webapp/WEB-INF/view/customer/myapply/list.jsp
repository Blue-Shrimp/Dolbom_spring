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
<script>
	if("${msg1}"){
		alert("신청이 완료되었습니다.");	
	} else if("${msg2}"){
		alert("후기 작성이 완료되었습니다.")
	} else if("${msg3}"){
		alert("후기 작성이 실패하였습니다.")
	} else if("${msg4}"){
		alert("후기가 삭제되었습니다.")
	} else if("${msg5}"){
		alert("후기 삭제에 실패하였습니다.")
	} else if("${msg6}"){
		alert("후기가 수정되었습니다.")
	} else if("${msg7}"){
		alert("후기 수정에 실패하였습니다.")
	}
</script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="a_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">나의 돌봄 신청 내역</h3>
				</div>
				<div class="applyList">
					<table>
						<colgroup>
							<col class="w80">
							<col class="w100">
							<col class="w350">
							<col class="w300">							
							<col class="w80">
							<col class="w100">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">신청번호</th>
								<th scope="col">신청일시</th>
								<th scope="col">신청시설</th>
								<th scope="col">돌봄시간</th>
								<th scope="col">신청상태</th>
								<th scope="col">후기관리</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${!empty list }">
									<c:forEach var="a" items="${list }">
									<tr>
										<td>${a.aid }</td>
										<td>${a.adate }</td>
										<td><a href="detail?aid=${a.aid }">${a.fpname }</a></td>
										<td>${a.fstime } ~ ${a.fetime } / ${a.fweek }</td>
										<c:choose>
											<c:when test="${a.astatus == 0 }">
												<td>접수</td>
											</c:when>
											<c:when test="${a.astatus == 1 }">
												<td>승인</td>
											</c:when>
											<c:when test="${a.astatus == 2 }">
												<td>취소</td>
											</c:when>
										</c:choose>
										<c:choose>
											<c:when test="${a.astatus == 0 }">
												<td>-</td>
											</c:when>
											<c:when test="${a.astatus == 1 }">
												<c:if test="${!empty a.rid }">
													<td><button class="navyBtn" type="button" id="readReivew" onclick="readReview(this,'${a.rid }')">내가 쓴 후기</button></td>
												</c:if>
												<c:if test="${empty a.rid }">
													<td><button class="navyBtn" type="button" id="writeReivew" onclick="writeReview(this,'${a.fid }')">후기작성</button></td>
												</c:if>
											</c:when>
											<c:when test="${a.astatus == 2 }">
												<td>-</td>
											</c:when>
										</c:choose>
									</tr>
									</c:forEach>
								</c:when>
								<c:when test="${empty list }">
									<tr>
										<td colspan="6">신청하신 내역이 없습니다.</td>
									</tr>
								</c:when>
							</c:choose>
						</tbody>
					</table>
				</div>
				<!-- 후기입력 -->
				<div class="_formStyle-layer-wrap" id="osCareReview" style="display: none;">
					<div class="_formStyle-layer">
						<div class="_formStyle-layer-inner">
							<strong class="_formStyle-layer-title">이용후기 작성</strong>
							<div class="os-care-review-group">
								<div class="os-care-review">
									<div class="os-care-review-title">
										<strong>이용후기</strong>
										<div class="os-rating">
											<div class="os-rating-medium" style="background: url(../../images/bg_rating_medium.png) 0px 0px no-repeat">
												<div class="os-rating-medium-inner" style="background: url(../../images/bg_rating_medium_inner.png) 0px 0px no-repeat">
													<ul class="os-rating-select">
														<li><button type="button" class="os-rating-btn" id="score1">1점주기</button></li>
														<li><button type="button" class="os-rating-btn" id="score2">2점주기</button></li>
														<li><button type="button" class="os-rating-btn" id="score3">3점주기</button></li>
														<li><button type="button" class="os-rating-btn" id="score4">4점주기</button></li>
														<li><button type="button" class="os-rating-btn" id="score5">5점주기</button></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="os-care-review-write">
										<form name="reviewWriteForm" action="reviewInsert_proc.do" method="post" id="reviewWriteForm">
											<input type="hidden" id="fid" name="fid" value="">
											<input type="hidden" id="did" name="did" value="${did }">
											<input type="hidden" id=rservice name="rservice" value="">
											<input type="text" id="rcontent" name="rcontent" placeholder="내용을 입력해주세요" class="reviewText">
											<button type="button" id="btnSaveReview">등록</button>
										</form>
									</div>
								</div>
								<button type="button" id="writeReviewClose" class="_formStyle-layer-close" style="background: url(../../images/ico_button_close.png) 50% 50% no-repeat;">이용후기 레이어 닫기</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 후기입력 -->
				<!-- 내가 쓴 후기 -->
				<c:forEach var="r" items="${review_list }">
				<div class="_formStyle-layer-wrap" id="${r.rid }" style="display: none;">
					<div class="_formStyle-layer">
						<div class="_formStyle-layer-inner">
							<strong class="_formStyle-layer-title">내가 쓴 후기</strong>
							<div class="os-care-review-group">
								<div class="os-care-review-cont-wrap">
									<!-- 리뷰 보여주기 폼 -->
									<div class="os-care-review-cont review_show" style="word-break: break-all;">	
										<div class="os-care-review-console">		
											<strong class="os-care-register">${r.dname } (${r.did })</strong>
											<div class="os-rating">			
												<div class="os-rating-small" style="background: url(../../images/bg_rating_small.png) 0 0 no-repeat">
													<c:choose>
															<c:when test="${r.rservice == 1 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 20%"></div>
															</c:when>
															<c:when test="${r.rservice == 2 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 40%"></div>
															</c:when>
															<c:when test="${r.rservice == 3 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 60%"></div>
															</c:when>
															<c:when test="${r.rservice == 4 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 80%"></div>
															</c:when>
															<c:when test="${r.rservice == 5 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 100%"></div>
															</c:when>
														</c:choose>
												</div>
											</div>		
										</div>	
										${r.rcontent }	
										<span class="os-care-report-date">${r.rdate }</span>
										<div class="wrapBtn">
											<button type="button" class="navyBtn" id="reviewUpdate" onclick="updateForm(this,'${r.rid }')">수정</button>
											<a href="reviewDelete_proc.do?rid=${r.rid }"><button type="button" class="navyBtn" id="reviewDelete">삭제</button></a>
										</div>
									</div>
									<!-- 리뷰 보여주기 폼 -->
									<!-- 리뷰 수정 폼 -->
									<div class="os-care-review-cont review_update" style="display:none; word-break: break-all;">	
										<div class="os-care-review-console">		
											<strong class="os-care-register">${r.dname } (${r.did })</strong>
											<div class="os-rating">			
												<div class="os-rating-medium" style="background: url(../../images/bg_rating_medium.png) 0px 0px no-repeat">
													<div class="os-rating-medium-inner" style="background: url(../../images/bg_rating_medium_inner.png) 0px 0px no-repeat">
														<ul class="os-rating-select">
															<li><button type="button" class="os-rating-btn" id="u_score1" onclick="score1(this,'${r.rid}')">1점주기</button></li>
															<li><button type="button" class="os-rating-btn" id="u_score2" onclick="score2(this,'${r.rid}')">2점주기</button></li>
															<li><button type="button" class="os-rating-btn" id="u_score3" onclick="score3(this,'${r.rid}')">3점주기</button></li>
															<li><button type="button" class="os-rating-btn" id="u_score4" onclick="score4(this,'${r.rid}')">4점주기</button></li>
															<li><button type="button" class="os-rating-btn" id="u_score5" onclick="score5(this,'${r.rid}')">5점주기</button></li>
														</ul>
													</div>
												</div>
											</div>		
										</div>	
										<div class="os-care-review-write">
											<form name="reviewUpdateForm_${r.rid }" action="reviewUpdate_proc.do" method="post" id="reviewUpdateForm_${r.rid }">
												<input type="hidden" id="rid" name="rid" value="${r.rid }">
												<input type="hidden" id=rservice name="rservice" value="">
												<input type="text" id="rcontent" name="rcontent" placeholder="내용을 입력해주세요" class="reviewText">
												<button type="button" id="btnUpdateReview" onclick="updateReview(this,'${r.rid}')">수정하기</button>
											</form>
										</div>
									</div>
									<!-- 리뷰 수정 폼 -->
								</div>
								<button onclick="readReviewClose(this,'${r.rid }')" type="button" id="readReviewClose" class="_formStyle-layer-close" style="background: url(../../images/ico_button_close.png) 50% 50% no-repeat;">이용후기 레이어 닫기</button>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				<!-- 내가 쓴 후기 -->
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>