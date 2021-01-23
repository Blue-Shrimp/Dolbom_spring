<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/swiper-bundle.min.css">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/index.js"></script>
<script src="js/swiper-bundle.min.js"></script>
<script>
	if("${msg1}"){
		alert("로그아웃에 실패했습니다.");	
	} else if("${msg2}"){
		alert("관리자만 이용할수 있습니다.");	
	}
	
	$(document).ready(function(){
	    var swiper = new Swiper('.swiper-container', {
	    	spaceBetween: 30,
	        centeredSlides: true,
	        autoplay: {
	          delay: 4000,
	          disableOnInteraction: false,
	        },
	        pagination: {
	          el: '.swiper-pagination',
	          clickable: true,
	        },
	        navigation: {
	          nextEl: '.swiper-button-next',
	          prevEl: '.swiper-button-prev',
	        },
	    });
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<div class="main">
			<div class="visualSlide" style="background: url(images/bg_mainSlide01.png) center center no-repeat;">
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide" style="background-image: url('images/carousel_img3.jpg');"></div>
						<div class="swiper-slide" style="background-image: url('images/carousel_img1.jpg');"></div>
						<div class="swiper-slide" style="background-image: url('images/carousel_img2.jpg');"></div>
					</div>
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
					<div class="swiper-pagination"></div>
				</div>
			</div>
			<div class="theNewestArea">
				<div class="newestBoard">
					<div class="mainNotice">
						<h2>공지사항</h2>
						<ul>
							<li>
								<a href="">
									<strong>이용자 미납금(예치금 잔액)에 따른 신청서 작성 제한 안내(재공지)</strong>
									<span>2021-01-20</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>12/27(일)~12/30(수) 삼성카드 국민행복카드 결제 지연 안내 (1/5 처리완료)</strong>
									<span>2020-12-31</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>2021년 건강보험료 판정기준 확정에 따른 소득재판정 안내</strong>
									<span>2020-12-28</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>2020년 아이돌봄서비스 홈페이지 만족도 설문조사 실시 안내</strong>
									<span>2020-12-22</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>2020년 아이돌봄서비스 홈페이지 만족도 설문조사 실시 안내</strong>
									<span>2020-12-20</span>
								</a>
							</li>
						</ul>
						<a href="customer/notice/list" class="moreBtnBoard" style="background: url(images/icon_more_plus.png) no-repeat 13px 9px;">더보기</a>
					</div>
				</div>
				<div class="facilityBanner">
					<div class="mainNotice">
						<h2>평점 높은 시설</h2>
						<ul>
							<li>
								<a href="">
									<strong>1. 서울시립수서청소년센터 (꿈나래)</strong>
									<span>★5.0</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>2. 서울시립강동청소년센터 (두빛나래)</strong>
									<span>★4.8</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>3. 서울시립화곡청소년센터 (몽땅연필)</strong>
									<span>★4.8</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>4. 서울시립보라매청소년센터 (희망터)</strong>
									<span>★4.6</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>5. 마포구립망원청소년문화센터 (꿈터)</strong>
									<span>★4.3</span>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>  
