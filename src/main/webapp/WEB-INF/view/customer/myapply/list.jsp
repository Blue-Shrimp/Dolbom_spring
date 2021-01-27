<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
								<th scope="col">리뷰관리</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>A_1</td>
								<td>2021-01-01</td>
								<td><a href="detail?aid=${n.fid }">청소년센터</a></td>
								<td>16:00 ~ 20:00 / 월,화,수,목,금</td>
								<td>접수</td>
								<td><button class="navyBtn" type="button" id="writeReivew">후기작성</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>