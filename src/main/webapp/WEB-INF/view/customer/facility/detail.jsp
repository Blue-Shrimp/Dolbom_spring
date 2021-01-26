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
		<c:set var="addr" value="${detail.flocation }"></c:set>
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">돌봄 시설 상세정보</h3>
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
									★${detail.fservice }
									<button class="navyBtn" type="button" id="btnReview">이용후기</button>
								</td>
							</tr>
							<tr>
								<th scope="row">대표자</th>
								<td colspan="3">${detail.fname }</td>
							</tr>
							<tr>
								<th scope="row">주소</th>
								<td colspan="3">${detail.flocation }<button class="navyBtn" type="button" id="btnLocation" onclick="relayout()">지도보기</button></td>
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
								<td colspan="3">
									<c:forTokens items="${detail.fsimg  }" delims="," var="item">
									    <img src="../../images/facility/${item }">
									</c:forTokens>
								</td>
							</tr>
							</c:if>
						</tbody>
					</table>
				</div>
				<div class="btn_apply">
					<form name="facilityForm" method="post" action="application">
						<input type="hidden" name="fid" id="fid" value="${fid }">
						<button type="submit" class="ibtn" id="btnApply">신청하기</button>
						<div class="rightBtn">
							<a href="list" class="btnWhite" id="btnList">목록</a>
						</div>
					</form>
				</div>
				<!-- 후기 리스트 -->
				<div class="_formStyle-layer-wrap" id="osCareReview" style="display: none;">
					<div class="_formStyle-layer">
						<div class="_formStyle-layer-inner">
							<strong class="_formStyle-layer-title">${detail.fpname }</strong>
							<div class="os-care-review-group">
								<div class="os-care-review-average">
									<c:choose>
										<c:when test="${cnt == 0 }">
											<span class="os-care-review-total">총 <strong>0</strong>건의 후기가 있습니다.</span>
										</c:when>
										<c:when test="${cnt != 0 }">
											<span class="os-care-review-total">총 <strong>${cnt }</strong>건의 후기가 있습니다.</span>
										</c:when>
									</c:choose>
									
									<div class="os-rating">
										<c:choose>
											<c:when test="${score == 0.0 }">
												<span>
												<em>평점</em><strong>0</strong>
												</span>
											</c:when>
											<c:when test="${score != 0.0 }">
												<span>
												<em>평점</em><strong>${score }</strong>
												</span>
											</c:when>
										</c:choose>
									</div>
								</div>
									<div class="os-care-review-cont-wrap">
										<c:forEach var="review" items="${list }">
										<div class="os-care-review-cont" style="word-break: break-all;">	
											<div class="os-care-review-console">		
												<strong class="os-care-register">${review.dname } (${review.did })</strong>
												<div class="os-rating">			
													<div class="os-rating-small" style="background: url(../../images/bg_rating_small.png) 0 0 no-repeat">
														<c:choose>
															<c:when test="${review.rservice == 1 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 20%"></div>
															</c:when>
															<c:when test="${review.rservice == 2 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 40%"></div>
															</c:when>
															<c:when test="${review.rservice == 3 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 60%"></div>
															</c:when>
															<c:when test="${review.rservice == 4 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 80%"></div>
															</c:when>
															<c:when test="${review.rservice == 5 }">
																<div class="os-rating-small-inner" style="background:url(../../images/bg_rating_small_inner.png) 0 0 no-repeat; width: 100%"></div>
															</c:when>
														</c:choose>				
																		
													</div>
												</div>		
											</div>	
											${review.rcontent }	
											<span class="os-care-report-date">${review.rdate }</span>
										</div>
										</c:forEach>
									</div>
							</div>
							<button type="button" id="btnReviewClose" class="_formStyle-layer-close" style="background: url(../../images/ico_button_close.png) 50% 50% no-repeat;">이용후기 레이어 닫기</button>
						</div>
					</div>
				</div>
				<!-- 후기 리스트 -->
				<!-- 지도 -->
				<div class="_formStyle-layer-wrap" id="osCareMap" style="display: none;">
					<div class="_formStyle-layer os-care-layer-map">
						<div class="_formStyle-layer-inner">
							<strong class="_formStyle-layer-title oni" tabindex="0">
								<p class="pop_title">${detail.fpname }</p>
								( 주소 : ${detail.flocation }, 연락처 : ${detail.fphone } )
							</strong>
							<div class="_formStyle-layer-map" id="map"></div>
							<button id="btnLocationClose" type="button" class="_formStyle-layer-close" style="background: url(../../images/ico_button_close.png) 50% 50% no-repeat;">지도보기 레이어 닫기</button>
						</div>
					</div>
				</div>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7db8e5cb8ed2f3f491886892335ed048&libraries=services"></script>
				<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  
				
				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption);
				
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
				
				var x;
				var y;
				
				var addr = '<c:out value="${addr}"/>';
				
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(addr, function(result, status) {
				
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
				
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				        
				        x = result[0].x;
				        y = result[0].y;
				
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
				
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});    
				
				</script>
				<!-- 지도 -->
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>