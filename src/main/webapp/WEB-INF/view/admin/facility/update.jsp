<%@page import="com.dolbom.vo.FacilityVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	FacilityVO vo = (FacilityVO)request.getAttribute("vo");
	String fweek = vo.getFweek();
	String[] weeks = fweek.split(",");

	boolean mon = false;
	boolean tue = false;
	boolean wed = false;
	boolean thu = false;
	boolean fri = false;
	boolean sat = false;
	boolean sun = false;
	for(String week : weeks){
		if(week.equals("월")){
			mon = true;
		} else if(week.equals("화")){
			tue = true;
		} else if(week.equals("수")){
			wed = true;
		} else if(week.equals("목")){
			thu = true;
		} else if(week.equals("금")){
			fri = true;
		} else if(week.equals("토")){
			sat = true;
		} else if(week.equals("일")){
			sun = true;
		}
	}
	
	if(vo.getFimg() != null){
		String fimg = vo.getFimg();
		String[] imgs = fimg.split(",");
		request.setAttribute("imgs", imgs);
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/facility.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/admin/facility_update.js"></script>
<script>
	if("${msg1}"){
		alert("시설 정보수정이 실패되었습니다.");	
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
						<h3 id="srcTopTitle">시설 정보 수정</h3>
					</div>
					<form name="facilityUpdateForm" action="updateProc.do" method="post" enctype="multipart/form-data">
						<input type="hidden" name="fid" value="${vo.fid }">
						<input type="hidden" name="fsido" id="fsido" value="${vo.fsido }">
						<input type="hidden" name="fgugun" id="fgugun" value="${vo.fgugun }">
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
		                                        <input type="text" class="inbox" name="fpname" id="fpname" value="${vo.fpname }">
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>대표자</th>
		                                <td>
		                                    <span class="input-btn type1">
		                                        <input type="text" class="inbox" name="fname" id="fname" value="${vo.fname }">
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>연락처</th>
		                                <td class="input-num type1 input-btn">
		                                	<c:forTokens items="${vo.fphone }" delims="-" var="phone" varStatus="s">
		                                		<c:if test="${s.count==1 }">
		                                			<c:set var="phone1" value="${phone }"></c:set>
		                                		</c:if>
		                                		<c:if test="${s.count==2 }">
		                                			<c:set var="phone2" value="${phone }"></c:set>
		                                		</c:if>
		                                		<c:if test="${s.count==3 }">
		                                			<c:set var="phone3" value="${phone }"></c:set>
		                                		</c:if>
		                                    </c:forTokens>
		                                	
		                                    <input type="tel" class="inbox" name="fphone1" id="fphone1" value="${phone1 }">
		                                    <span>-</span>
		                                    <input type="tel" class="inbox" name="fphone2" id="fphone2" value="${phone2 }">
		                                    <span>-</span>
		                                    <input type="tel" class="inbox" name="fphone3" id="fphone3" value="${phone3 }">
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>주소</th>
		                                <td class="addr">
		                                    <span class="input-btn type2">
		                                        <input type="text" class="inbox" id="flocation" name="flocation" readonly="readonly"  value="${vo.flocation }">
		                                        <button class="graybtn" type="button" id="searchAddr" onclick="goPopup()">주소검색</button>
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>정원</th>
		                                <td class="input-num type1 input-btn">
		                                    <span class="input-btn type2">
		                                        <input type="number" min="1" max="100" value="${vo.fpeople }" class="inbox" id="fpeople" name="fpeople">
		                                    </span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>운영시간</th>
		                                <td class="input-num type2 input-email">
		                                    <input type="time" id="fstime" name="fstime" value="${vo.fstime }">
		                                    <span>~</span>
		                                    <input type="time" id="fetime" name="fetime" value="${vo.fetime }">
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>돌봄요일</th>
		                                <td class="input-num type2 input-email">
		                                    <input type="checkbox" name="fweek_list" value="월" <%= mon?"checked":"" %>><span class="week">월</span>			
											<input type="checkbox" name="fweek_list" value="화" <%= tue?"checked":"" %>><span class="week">화</span>			
											<input type="checkbox" name="fweek_list" value="수" <%= wed?"checked":"" %>><span class="week">수</span>				
											<input type="checkbox" name="fweek_list" value="목" <%= thu?"checked":"" %>><span class="week">목</span> 				
											<input type="checkbox" name="fweek_list" value="금" <%= fri?"checked":"" %>><span class="week">금</span>		
											<input type="checkbox" name="fweek_list" value="토" <%= sat?"checked":"" %>><span class="week">토</span>				
											<input type="checkbox" name="fweek_list" value="일" <%= sun?"checked":"" %>><span class="week">일</span>
		                                </td>
		                            </tr>
		                            <tr>
		                                <th><span class="red">*</span>프로그램</th>
		                                <td>
		                                    <span class="input-btn type1">
		                                        <input type="text" class="inbox" name="fprogram" id="fprogram" value="${vo.fprogram }">
		                                    </span>
		                                </td>
		                            </tr>
		                            <%-- <tr>
		                                <th>시설사진<br>(최대 4개)</th>
		                                <td>
		                                    <span class="fileGp">
			                                	<c:choose>
			                                		<c:when test="${vo.fimg ne null}">
			                                			<c:if test="${fn:length(imgs) == 1 }">
				                                			<c:forTokens items="${vo.fimg }" delims="," var="img" varStatus="f">
				                                			<div>${f.count }. <input type="file" id="file${f.count }" name="file${f.count }" accept="image/*"><span class="fname" id="fname${f.count }">${img}</span></div>
				                                			</c:forTokens>
				                                			<div>2. <input type="file" id="file2" name="file2" accept="image/*"></div>
					                                        <div>3. <input type="file" id="file3" name="file3" accept="image/*"></div>
					                                        <div>4. <input type="file" id="file4" name="file4" accept="image/*"></div>
			                                			</c:if>
			                                			<c:if test="${fn:length(imgs) == 2 }">
				                                			<c:forTokens items="${vo.fimg }" delims="," var="img" varStatus="f">
				                                			<div>${f.count }. <input type="file" id="file${f.count }" name="file${f.count }" accept="image/*"><span class="fname" id="fname${f.count }">${img}</span></div>
				                                			</c:forTokens>
					                                        <div>3. <input type="file" id="file3" name="file3" accept="image/*"></div>
					                                        <div>4. <input type="file" id="file4" name="file4" accept="image/*"></div>
			                                			</c:if>
			                                			<c:if test="${fn:length(imgs) == 3 }">
				                                			<c:forTokens items="${vo.fimg }" delims="," var="img" varStatus="f">
				                                			<div>${f.count }. <input type="file" id="file${f.count }" name="file${f.count }" accept="image/*"><span class="fname" id="fname${f.count }">${img}</span></div>
				                                			</c:forTokens>
					                                        <div>4. <input type="file" id="file4" name="file4" accept="image/*"></div>
			                                			</c:if>
			                                			<c:if test="${fn:length(imgs) == 4 }">
				                                			<c:forTokens items="${vo.fimg }" delims="," var="img" varStatus="f">
				                                			<div>${f.count }. <input type="file" id="file${f.count }" name="file${f.count }" accept="image/*"><span class="fname" id="fname${f.count }">${img}</span></div>
				                                			</c:forTokens>
			                                			</c:if>
			                                		</c:when>
			                                		<c:otherwise>
				                                		<div>1. <input type="file" id="file1" name="file1" accept="image/*"></div>
				                                        <div>2. <input type="file" id="file2" name="file2" accept="image/*"></div>
				                                        <div>3. <input type="file" id="file3" name="file3" accept="image/*"></div>
				                                        <div>4. <input type="file" id="file4" name="file4" accept="image/*"></div>
			                                		</c:otherwise>
			                                	</c:choose>
		                                    </span>
		                                </td>
		                            </tr> --%>
		                        </tbody>
		                    </table>
		                </div>
		                <div class="rightBtn">
							<button type="button" class="nBtn" id="btnUpdate">수정하기</button>
							<button type="reset" class="nBtn">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
	<jsp:include page="../a_footer.jsp" />
</body>
</html>