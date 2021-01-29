<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템</title>
<link rel="stylesheet" href="css/login.css">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/login.js"></script>
<script>
	if("${msg1}"){
		alert("회원가입이 완료되었습니다.");	
	} else if("${msg2}"){
		alert("로그아웃 되었습니다.");	
	} else if("${msg3}"){
		alert("로그인이 필요한 서비스입니다.");	
	} else if("${msg4}"){
		alert("관리자만 이용할수 있습니다.");	
	} else if("${msg5}"){
		alert("회원탈퇴가 완료되었습니다.");	
	}
</script>
</head>
<body>
	<div class="wrap">
		<div class="login">
			<div class="login-content">
				<h1><img src="images/logo_remove_bg.png"></h1>
				<p class="login-alert-text"><strong style="background: url(images/alert_icon.png) 0 50% no-repeat;">꼭 확인하세요!</strong><br>회원가입하셔야 정상적인 서비스 이용이 가능합니다!</p>
				<div class="tab-cont">
					<div class="login-content-inner">
						<div class="left-section" style="background: url('images/bg_login_left_section.png') 0 0 no-repeat;">
							<h2>
								<strong>온라인 돌봄</strong><br>
								원스톱 서비스<br>
								신청 창구
							</h2>
							<p>서비스 이용을 위해서는 회원가입 후<br>로그인시 이용가능합니다.</p>
						</div>
						<div class="right-section">
							<p class="login-info-desc">
								<strong>온라인 돌봄 신청 서비스</strong><br><span>"청소년방과후아카데미"</span>
							</p>
							<div class="certificate-login">
								<form name="loginForm" action="login_proc.do" method="post" class="loginForm">
									<ul>
										<li>
											<input type="text" name="did" placeholder="아이디" id="did">
										</li>
										<li>
											<input type="password" name="dpass" placeholder="비밀번호" id="dpass">
										</li>
										<li>
											<c:if test="${msg == false }">
												<div style="color:#f00">아이디 혹은 비밀번호가 틀렸습니다!</div>
											</c:if>
										</li>
										<li>
											<button type="button" id="btnLogin">로그인</button>
										</li>
										<li>
											<a href="login/findId"><span>아이디 찾기</span></a>
											<a href="login/findPass"><span>비밀번호 찾기</span></a>
											<a href="join/join"><span>회원가입</span></a>
										</li>
									</ul>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>