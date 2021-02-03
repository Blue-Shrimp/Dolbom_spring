<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/notice.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/notice.js"></script>
<script>
	if("${msg1}"){
		alert("글 작성이 실패되었습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="../a_header.jsp" />
	
	<div id="n_container">
		<jsp:include page="../a_aside.jsp" />
		
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">공지사항 작성</h3>
				</div>
				<form name="noticeWriteForm" action="writeProc.do" method="post" enctype="multipart/form-data" >
			        <table class="board_view">
			            <colgroup>
			                <col width="15%" >
			                <col width="*" >
			            </colgroup>
			            <tbody>
			                <tr>
			                    <th scope="row">제목</th>
			                    <td><input type="text" id="btitle" name="btitle" class="wdp_90" /></td>
			                </tr>
			                <tr>
			                    <th scope="row">내용</th>
			                    <td><textarea cols="95" rows="20" id="bcontent" name="bcontent"></textarea></td>
			                </tr>
			            </tbody>
			        </table>
			        <div class="rightArea">
				        <font id="bcontent_count">0</font>/300
			        </div>
			        <input type="file" name="file1">
			        <div class="rightArea">
				        <button type="button" class="ibtn" id="writeSubmitBtn">등록</button>
				        <a href="list"><button type="button" class="ibtn">목록</button></a>
			        </div>
			    </form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../a_footer.jsp" />
</body>
</html>