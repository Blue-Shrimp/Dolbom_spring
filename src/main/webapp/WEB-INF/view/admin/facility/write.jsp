<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/facility.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/facility.js"></script>
<script>
	if("${msg1}"){
		alert("시설 등록이 실패되었습니다.");	
	}
</script>
</head>
<body>
	<jsp:include page="../a_header.jsp" />
		
		<div id="f_container">
			<jsp:include page="../a_aside.jsp" />
			
			<div class="main">
				<div class="contents">
					<div class="subHeader">
						<h3 id="srcTopTitle">시설 등록</h3>
					</div>
					<form name="facilityInsertForm" action="insertProc.do" method="post" enctype="multipart/form-data">
						<input type="hidden" name="fsido" id="fsido">
						<input type="hidden" name="fgugun" id="fgugun">
						<div class="tbl-list form">
		                    <table>
		                    	<colgroup>
									<col class="w210">
									<col class="w875">
								</colgroup>
		                        <tbody>
		                            <tr>
		                                <th><span class="red">*</span>시설명</th>
		                                <td>
		                                    <span class="input-btn type1">
		                                        <input type="text" class="inbox" name="fpname" id="fpname">
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>대표자</th>
		                                <td>
		                                    <span class="input-btn type1">
		                                        <input type="text" class="inbox" name="fname" id="fname">
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>연락처</th>
		                                <td class="input-num type1 input-btn">
		                                    <input type="tel" class="inbox" name="fphone1" id="fphone1">
		                                    <span>-</span>
		                                    <input type="tel" class="inbox" name="fphone2" id="fphone2">
		                                    <span>-</span>
		                                    <input type="tel" class="inbox" name="fphone3" id="fphone3">
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>주소</th>
		                                <td class="addr">
		                                    <span class="input-btn type2">
		                                        <input type="text" class="inbox" id="flocation" name="flocation" readonly="readonly">
		                                        <button class="graybtn" type="button" id="searchAddr" onclick="goPopup()">주소검색</button>
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>정원</th>
		                                <td class="input-num type1 input-btn">
		                                    <span class="input-btn type2">
		                                        <input type="number" min="1" max="100" value="1" class="inbox" id="fpeople" name="fpeople">
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>운영시간</th>
		                                <td class="input-num type2 input-email">
		                                    <input type="time" id="fstime" name="fstime">
		                                    <span>~</span>
		                                    <input type="time" id="fetime" name="fetime">
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>돌봄요일</th>
		                                <td class="input-num type2 input-email">
		                                    <input type="checkbox" name="fweek_list" value="월"><span class="week">월</span>			
											<input type="checkbox" name="fweek_list" value="화"><span class="week">화</span>			
											<input type="checkbox" name="fweek_list" value="수"><span class="week">수</span>				
											<input type="checkbox" name="fweek_list" value="목"><span class="week">목</span> 				
											<input type="checkbox" name="fweek_list" value="금"><span class="week">금</span>		
											<input type="checkbox" name="fweek_list" value="토"><span class="week">토</span>				
											<input type="checkbox" name="fweek_list" value="일"><span class="week">일</span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>프로그램</th>
		                                <td>
		                                    <span class="input-btn type1">
		                                        <input type="text" class="inbox" name="fprogram" id="fprogram">
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th>시설사진<br>(최대 4개)</th>
		                                <td>
		                                    <span class="fileGp">
		                                        <div>1. <input type="file" id="file1" name="file1" accept="image/*"></div>
		                                        <div>2. <input type="file" id="file2" name="file2" accept="image/*"></div>
		                                        <div>3. <input type="file" id="file3" name="file3" accept="image/*"></div>
		                                        <div>4. <input type="file" id="file4" name="file4" accept="image/*"></div>
		                                    </span>
		                                </td>
		                            </tr>
		                        </tbody>
		                    </table>
		                </div>
		                <div class="rightBtn">
							<button type="button" class="nBtn" id="btnInsert">등록하기</button>
							<button type="reset" class="nBtn">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
	<jsp:include page="../a_footer.jsp" />
</body>
</html>