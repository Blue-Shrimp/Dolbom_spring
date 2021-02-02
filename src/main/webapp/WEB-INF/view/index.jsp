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
							<c:forEach items="${n_list }" var="n">
							<li>
								<a href="customer/notice/detail?bid=${n.bid }">
									<strong>${n.btitle }</strong>
									<span>${n.bdate }</span>
								</a>
							</li>
							</c:forEach>
						</ul>
						<a href="customer/notice/list" class="moreBtnBoard" style="background: url(images/icon_more_plus.png) no-repeat 13px 9px;">더보기</a>
					</div>
				</div>
				<div class="facilityBanner">
					<div class="mainNotice">
						<h2>평점 높은 시설</h2>
						<ul>
							<c:forEach items="${f_list }" var="f">
							<li>
								<a href="customer/facility/detail?fid=${f.fid }">
									<strong>${f.rno }. ${f.fpname }</strong>
									<span>★${f.fservice }</span>
								</a>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>  
