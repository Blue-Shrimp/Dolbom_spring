<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
		alert("글 수정이 실패되었습니다.");	
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
					<h3 id="srcTopTitle">공지사항 수정</h3>
				</div>
				<form name="noticeUpdateForm" action="updateProc.do" method="post" enctype="multipart/form-data" >
					<input type="hidden" name="bid" value="${vo.bid }">
			        <table class="board_view">
			            <colgroup>
			                <col width="15%" >
			                <col width="*" >
			            </colgroup>
			            <tbody>
			                <tr>
			                    <th scope="row">제목</th>
			                    <td><input type="text" id="btitle" name="btitle" class="wdp_90" value="${vo.btitle }" /></td>
			                </tr>
			                <tr>
			                    <th scope="row">내용</th>
			                    <td><textarea cols="95" rows="20" id="bcontent" name="bcontent">${vo.bcontent }</textarea></td>
			                </tr>
			            </tbody>
			        </table>
			        <div class="rightArea">
				        <font id="bcontent_count">${vo.bcontent.length() }</font>/300
			        </div>
			        <c:choose>
						<c:when test="${vo.bfile ne null}">
							<input type="file" name="file1"><span id="fname">${vo.bfile}</span>
						</c:when>
						<c:otherwise>
							<input type="file" name="file1"><span id="fname">선택된 파일 없음</span>
						</c:otherwise>
					</c:choose>
			        <div class="rightArea">
				        <button type="button" class="ibtn" id="updateSubmitBtn">수정완료</button>
				        <a href="list"><button type="button" class="ibtn">목록</button></a>
			        </div>
			    </form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../a_footer.jsp" />
</body>
</html>