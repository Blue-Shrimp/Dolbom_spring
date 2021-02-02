<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/admin/index.css">
</head>
<body>
	<header>
		<div id="header" style="height:38px; background: url(../images/bg_header.gif) repeat-x left top;">
			<ul class="utileMenu2">
				<li>${svo.name }님 반갑습니다!</li>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
		</div>
	</header>
</body>