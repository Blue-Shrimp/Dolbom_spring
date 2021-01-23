<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">돌봄 시설조회</h3>
				</div>
				<div class="unified-search">
					<form id="detailSearchForm">
						<div class="search-box search-input">
							<div class="search-sort">
								<div class="sch-rgt search-full" id="location">
									<select name="sido" id="sido" class="org_s">
									</select>
									<select name="gugun" id="gugun" class="org_s">
									</select>
									<input type="text" id="searchKeyword" placeholder="시설명을 입력해주세요">
									<span class="ibtn form navy" id="lifecycleAreaSearchBtn">
										<button type="button" id="btnSearch">검색</button>
									</span>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="facilityList">
					<table>
						<colgroup>
							<col class="w55">
							<col class="w80">
							<col class="w250">
							<col class="w400">
							<col class="w140">							
							<col class="w80">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">모집상태</th>
								<th scope="col">시설명</th>
								<th scope="col">주소</th>
								<th scope="col">모집현황</th>
								<th scope="col">평점</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>10</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>9</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>8</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>7</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>6</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>5</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>4</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>3</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>2</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
							<tr>
								<td>1</td>
								<td>신청가능</td>
								<td><a href="">서울시립수서청소년센터 (꿈나래)</a></td>
								<td>서울특별시 강남구 광평로 144 (수서동) 서울시립수서청소년센터</td>
								<td>현원 38명 / 정원 40명</td>
								<td>★ 4.8</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="pagingNav" class="paging">
					<div class="paging">
						<a href="" class="linkFirstPrevPage" style="visibility:hidden; background: url(../../images/btn_firstPrev.png) no-repeat 50% 50%;"></a>
						<a href="" class="linkPrevPage" style="visibility:hidden; background: url(../../images/btn_prev.png) no-repeat 50% 50%;"></a>
						<strong>1</strong>
						<a href="">2</a>
						<a href="">3</a>
						<a href="">4</a>
						<a href="">5</a>
						<a href="">6</a>
						<a href="">7</a>
						<a href="">8</a>
						<a href="">9</a>
						<a href="">10</a>
						<a href="" class="linkNextPage" style="background: url(../../images/btn_next.png) no-repeat 50% 50%;"></a>
						<a href="" class="linkLastNextPage" style="background: url(../../images/btn_lastNext.png) no-repeat 50% 50%;"></a>
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>