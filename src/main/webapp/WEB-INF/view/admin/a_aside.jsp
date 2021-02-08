<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../../css/admin/aside.css">
<script src="../../js/admin/a_aside.js"></script>
<body>
	<aside class="admin_main">
		<div class="aside_title">
			학생 돌봄 서비스 업무처리 창구
		</div>
		<ul>
			<li class="subTitle" id="f_manage" style="background: url(../../images/icon_more_plus.png) no-repeat 130px 37px">시설관리
				<div class="sub" id="f_sub" style="display: none">
					<ul>
						<li><a href="../facility/list">시설조회</a></li>
						<li><a href="../facility/write">시설등록</a></li>
						<li><a href="../review/list">시설후기 관리</a></li>
					</ul>
				</div>
			</li>
			<li class="subTitle" id="c_manage" style="background: url(../../images/icon_more_plus.png) no-repeat 130px 37px">아동관리
				<div class="sub" id="c_sub" style="display: none">
					<ul>
						<li><a href="../applicationMember/list">신청 아동 관리</a></li>
						<li><a href="../benefitMember/list">수혜자 아동 관리</a></li>
					</ul>
				</div>
			</li>
			<li class="subTitle" id="n_manage" style="background: url(../../images/icon_more_plus.png) no-repeat 130px 37px">커뮤니티관리
				<div class="sub" id="n_sub" style="display: none">
					<ul>
						<li><a href="../notice/list">공지사항 관리</a></li>
					</ul>
				</div>
			</li>
		</ul>
	</aside>
</body>
