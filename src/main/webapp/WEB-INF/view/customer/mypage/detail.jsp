<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
		alert("비밀번호변경이 완료되었습니다.");	
	} else if("${msg2}"){
		alert("회원정보가 수정되었습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="m_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">마이페이지</h3>
				</div>
				<div class="mypageDetail">
					<table>
						<colgroup>
							<col class="w210">
							<col class="w875">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">이름</th>
								<td colspan="3">${vo.dname }</td>
							</tr>
							<tr>
								<th scope="row">아이디</th>
								<td colspan="3">${vo.did }</td>
							</tr>
							<tr>
								<th scope="row">비밀번호</th>
								<td colspan="3">
									<a href="passEdit"><button type="button" class="ibtn">비밀번호 변경</button></a>
								</td>
							</tr>
							<tr>
								<th scope="row">이메일주소</th>
								<td colspan="3">${vo.demail }</td>
							</tr>
							<tr>
								<th scope="row">전화번호</th>
								<td colspan="3">${vo.dphone }</td>
							</tr>
							<tr>
								<th scope="row">주소</th>
								<td colspan="3">${vo.darea }</td>
							</tr>
							<tr>
								<th scope="row">자녀현황</th>
								<td colspan="3">
									<div class="childTable">
										<table>
											<colgroup>
												<col class="w250">
												<col class="w250">
												<col class="w250">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">성명</th>
													<th scope="col">생년월일</th>
													<th scope="col">성별</th>
												</tr>
											</thead>
											<tbody>
												<c:forTokens items="${vo.dchildren  }" delims="," var="children">
												<tr>
													<c:forTokens items="${children }" delims="/" var="child">
													<td>${child }</td>
													</c:forTokens>
												</tr>
												</c:forTokens>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="memberDelte">
					<a href="delete">회원탈퇴</a>
				</div>
				<div class="btn_apply">
					<a href="update"><button type="button" class="ibtn" id="btnUpdateForm">수정</button></a>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>