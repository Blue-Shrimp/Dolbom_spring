<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템</title>
<link rel="stylesheet" href="../../css/mypage.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/mypage.js"></script>
<script>
	if("${msg1}"){
		alert("비밀번호변경이 실패되었습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="m_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">비밀번호 변경</h3>
				</div>
				<form name="passEditForm" class="passEditForm" action="passEditProc.do" method="POST">
					<input type="hidden" id="did" name="did" value="${did }">
					<div class="main_box">
						<div class="input_box">
							<div class="left_box2">
								<b>·</b>&nbsp;새 비밀번호
							</div>
							<div class="right_box">
								<input type="password" id="dpass" name="dpass" class="pw_blank" placeholder="새 비밀번호">
							</div>
						</div>
						<div class="input_box">
							<div class="left_box2">
								<b>·</b>&nbsp;비밀번호 확인
							</div>
							<div class="right_box">
								<input type="password" id="passCheck" name="passCheck" class="pw_blank" placeholder="비밀번호 확인">
							</div>
						</div>
					</div>			
					<div class="main_box3">
						<input type="button" id="btnPassEdit" class="ibtn" value="변경">
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>