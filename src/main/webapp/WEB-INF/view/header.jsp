<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<header>
		<div id="header" style="background: url(images/bg_header.gif) repeat-x left top;">
			<h1><a href="index"><img src="images/logo.PNG"></a></h1>
			<ul class="utileMenu2">
				<li>${svo.name }님 반갑습니다!</li>
				<li><a href="customer/mypage/detail">마이페이지</a></li>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
			<div class="gnb">
				<div>
					<ul id="gnbMenu" class="gnbMenu">
						<li><a href="customer/service/introduce">학생돌봄 사업소개</a>
						</li>
						<li><a href="customer/facility/list">시설조회</a>
						</li>
						<li><a href="customer/notice/list">참여마당</a>
						</li>
						<li><a href="customer/myapply/list">나의 신청 내역</a>
						</li>
					</ul>
				</div>				
			</div>
		</div>
	</header>
</body>