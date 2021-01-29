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
		alert("회원탈퇴가 실패되었습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="m_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">회원 탈퇴</h3>
				</div>
				<form name="memberDeleteForm" action="memberDeleteProc.do" method="POST" class="memberDeleteForm">
                    <table class="tb_exit">
                        <tbody>
	                        <tr>
	                            <th>아이디</th>
	                            <td>${did }</td>
	                        </tr>
	                    </tbody>
                    </table>
                    <button type="submit" class="ibtn">탈퇴 신청</button>
                </form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>