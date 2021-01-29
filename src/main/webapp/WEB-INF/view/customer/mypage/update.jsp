<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
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
		alert("회원정보 수정이 실패하였습니다.");	
	} 
</script>
</head>
<body>
	<jsp:include page="../c_header.jsp" />
	
	<div id="m_container">
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">나의 정보 수정</h3>
				</div>
				<form name="updateForm" action="memberUpdateProc.do" method="post">
					<div class="tbl-list form">
	                    <table>
	                    	<colgroup>
								<col class="w210">
								<col class="w875">
							</colgroup>
	                        <tbody>
	                            <tr>
	                                <th>아이디</th>
	                                <td>
	                                    <span class="input-btn type1">
	                                        <input type="text" class="inbox" name="did" id="did" value="${vo.did }" readonly="readonly">
	                                    </span>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>이름</th>
	                                <td>
	                                    <span class="input-btn type1">
	                                        <input type="text" class="inbox" name="dname" id="dname" value="${vo.dname }">
	                                    </span>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>연락처</th>
	                                <td class="input-num type1 input-btn">
	                                	<c:forTokens items="${vo.dphone }" delims="-" var="phone" varStatus="s">
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
	                                    <input type="tel" class="inbox" name="dphone1" id="dphone1" value="${phone1 }">
	                                    <span>-</span>
	                                    <input type="tel" class="inbox" name="dphone2" id="dphone2" value="${phone2 }">
	                                    <span>-</span>
	                                    <input type="tel" class="inbox" name="dphone3" id="dphone3" value="${phone3 }">
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>이메일</th>
	                                <td class="input-num type2 input-email">
	                                	<c:forTokens items="${vo.demail }" delims="@" var="email" varStatus="s">
	                                		<c:if test="${s.count==1 }">
	                                			<c:set var="email1" value="${email }"></c:set>
	                                		</c:if>
	                                		<c:if test="${s.count==2 }">
	                                			<c:set var="email2" value="${email }"></c:set>
	                                		</c:if>
	                                    </c:forTokens>
	                                    <input type="text" id="demail1" name="demail1" class="inbox" value="${email1 }">
	                                    <span>@</span>
	                                    <input type="text" id="demail2" name="demail2" class="inbox" disabled="" value="${email2 }">
	                                    <p class="email-select">
	                                        <select name="demail3" id="demail3">
	                                            <option value="${email2 }">${email2 }</option>
	                                            <option value="">이메일 선택</option>
	                                            <option value="naver.com">naver.com</option>
	                                            <option value="hanmail.net">hanmail.net</option>
	                                            <option value="hotmail.com">hotmail.com</option>
	                                            <option value="gmail.com">gmail.com</option>
	                                            <option value="korea.kr">korea.kr</option>
	                                            <option value="nate.com">nate.com</option>
	                                            <option value="yahoo.co.kr">yahoo.co.kr</option>
	                                            <option value="paran.com">paran.com</option>
	                                            <option value="empas.com">empas.com</option>
	                                        </select>
	                                    </p>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>주소</th>
	                                <td class="addr">
	                                    <span class="input-btn type2">
	                                        <input type="text" class="inbox" id="darea" name="darea" readonly="readonly" value="${vo.darea }">
	                                        <button class="graybtn" type="button" id="searchAddr" onclick="goPopup()">주소검색</button>
	                                    </span>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>자녀현황</th>
	                                <td class="input-child type1">
	                                	<div class="ctitle">
	                                		<span>이름</span><span>생년월일</span><span>성별</span>
	                                	</div>
	                                	<c:forTokens items="${vo.dchildren  }" delims="," var="children" varStatus="s1">
	                                		<c:if test="${s1.count == 1 }">
												<c:forTokens items="${children }" delims="/" var="child" varStatus="s2">
													<c:if test="${s2.count == 1 }">
														<c:set var="child_name1" value="${child }"></c:set>
													</c:if>
													<c:if test="${s2.count == 2 }">
														<c:forTokens items="${child }" delims="." var="child1_date" varStatus="s3">
															<c:if test="${s3.count == 1 }">
																<c:set var="child_year1" value="${child1_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 2 }">
																<c:set var="child_month1" value="${child1_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 2 }">
																<c:set var="child_day1" value="${child1_date }"></c:set>
															</c:if>
														</c:forTokens>
													</c:if>
													<c:if test="${s2.count == 3 }">
														<c:set var="child_gender1" value="${child }"></c:set>
													</c:if>
												</c:forTokens>
			                                	<div class="child-info ch1">
				                                    <input type="text" class="inbox" name="cname" id="cname" value="${child_name1 }">
				                                    
													<select name="cyear" id="cyear" title="년도" class="custom-select"><option value="${child_year1 }">${child_year1 }년</option></select>
													<select name="cmonth" id="cmonth" title="월" class="custom-select"><option value="${child_month1 }">${child_month1 }월</option></select>
													<select name="cday" id="cday" title="일" class="custom-select"><option value="${child_day1 }">${child_day1 }일</option></select>
													
													<c:choose>
														<c:when test="${child_gender1 == '남자' }">
						                                    <input type="radio" name="cgender" id="cgender" value="남자" checked="checked"><span>남자</span>
						                                    <input type="radio" name="cgender" id="cgender" value="여자"><span>여자</span>
														</c:when>
														<c:when test="${child_gender1 == '여자' }">
						                                    <input type="radio" name="cgender" id="cgender" value="남자"><span>남자</span>
						                                    <input type="radio" name="cgender" id="cgender" value="여자" checked="checked"><span>여자</span>
														</c:when>
													</c:choose>
			                                	</div>
	                                		</c:if>
	                                		<c:if test="${s1.count == 2 }">
	                                			<c:forTokens items="${children }" delims="/" var="child" varStatus="s2">
													<c:if test="${s2.count == 1 }">
														<c:set var="child_name2" value="${child }"></c:set>
													</c:if>
													<c:if test="${s2.count == 2 }">
														<c:forTokens items="${child }" delims="." var="child2_date" varStatus="s3">
															<c:if test="${s3.count == 1 }">
																<c:set var="child_year2" value="${child2_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 2 }">
																<c:set var="child_month2" value="${child2_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 2 }">
																<c:set var="child_day2" value="${child2_date }"></c:set>
															</c:if>
														</c:forTokens>
													</c:if>
													<c:if test="${s2.count == 3 }">
														<c:set var="child_gender2" value="${child }"></c:set>
													</c:if>
												</c:forTokens>
												<div class="child-info ch2" style="display: block;">
				                                    <input type="text" class="inbox" name="cname2" id="cname2" value="${child_name2 }">
				                                    
													<select name="cyear2" id="cyear2" title="년도" class="custom-select"><option value="${child_year2 }">${child_year2 }년</option></select>
													<select name="cmonth2" id="cmonth2" title="월" class="custom-select"><option value="${child_month2 }">${child_month2}월</option></select>
													<select name="cday2" id="cday2" title="일" class="custom-select"><option value="${child_day2 }">${child_day2 }일</option></select>
													
													<c:choose>
														<c:when test="${child_gender2 == '남자' }">
						                                    <input type="radio" name="cgender2" id="cgender2" value="남자" checked="checked"><span>남자</span>
						                                    <input type="radio" name="cgender2" id="cgender2" value="여자"><span>여자</span>
														</c:when>
														<c:when test="${child_gender2 == '여자' }">
						                                    <input type="radio" name="cgender2" id="cgender2" value="남자"><span>남자</span>
						                                    <input type="radio" name="cgender2" id="cgender2" value="여자" checked="checked"><span>여자</span>
														</c:when>
													</c:choose>
			                                	</div>
	                                		</c:if>
	                                		<c:if test="${s1.count == 3 }">
	                                			<c:forTokens items="${children }" delims="/" var="child" varStatus="s2">
													<c:if test="${s2.count == 1 }">
														<c:set var="child_name3" value="${child }"></c:set>
													</c:if>
													<c:if test="${s2.count == 2 }">
														<c:forTokens items="${child }" delims="." var="child3_date" varStatus="s3">
															<c:if test="${s3.count == 1 }">
																<c:set var="child_year3" value="${child3_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 2 }">
																<c:set var="child_month3" value="${child3_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 3 }">
																<c:set var="child_day3" value="${child3_date }"></c:set>
															</c:if>
														</c:forTokens>
													</c:if>
													<c:if test="${s2.count == 3 }">
														<c:set var="child_gender3" value="${child }"></c:set>
													</c:if>
												</c:forTokens>
												<div class="child-info ch3" style="display: block;">
				                                    <input type="text" class="inbox" name="cname3" id="cname3" value="${child_name3 }">
				                                    
													<select name="cyear3" id="cyear3" title="년도" class="custom-select"><option value="${child_year3 }">${child_year3 }년</option></select>
													<select name="cmonth3" id="cmonth3" title="월" class="custom-select"><option value="${child_month3 }">${child_month3 }월</option></select>
													<select name="cday3" id="cday3" title="일" class="custom-select"><option value="${child_day3 }">${child_day3 }일</option></select>
													
													<c:choose>
														<c:when test="${child_gender3 == '남자' }">
						                                    <input type="radio" name="cgender3" id="cgender3" value="남자" checked="checked"><span>남자</span>
						                                    <input type="radio" name="cgender3" id="cgender3" value="여자"><span>여자</span>
														</c:when>
														<c:when test="${child_gender3 == '여자' }">
						                                    <input type="radio" name="cgender3" id="cgender3" value="남자"><span>남자</span>
						                                    <input type="radio" name="cgender3" id="cgender3" value="여자" checked="checked"><span>여자</span>
														</c:when>
													</c:choose>
			                                	</div>
	                                		</c:if>
	                                		<c:if test="${s1.count == 4 }">
	                                			<c:forTokens items="${children }" delims="/" var="child" varStatus="s2">
													<c:if test="${s2.count == 1 }">
														<c:set var="child_name4" value="${child }"></c:set>
													</c:if>
													<c:if test="${s2.count == 2 }">
														<c:forTokens items="${child }" delims="." var="child4_date" varStatus="s3">
															<c:if test="${s3.count == 1 }">
																<c:set var="child_year4" value="${child4_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 2 }">
																<c:set var="child_month4" value="${child4_date }"></c:set>
															</c:if>
															<c:if test="${s3.count == 3 }">
																<c:set var="child_day4" value="${child4_date }"></c:set>
															</c:if>
														</c:forTokens>
													</c:if>
													<c:if test="${s2.count == 3 }">
														<c:set var="child_gender4" value="${child }"></c:set>
													</c:if>
												</c:forTokens>
												<div class="child-info ch4" style="display: block;">
				                                    <input type="text" class="inbox" name="cname4" id="cname4" value="${child_name4 }">
				                                    
													<select name="cyear4" id="cyear4" title="년도" class="custom-select"><option value="${child_year4 }">${child_year4 }년</option></select>
													<select name="cmonth4" id="cmonth4" title="월" class="custom-select"><option value="${child_month4 }">${child_month4 }월</option></select>
													<select name="cday4" id="cday4" title="일" class="custom-select"><option value="${child_day4 }">${child_day4 }일</option></select>
													
													<c:choose>
														<c:when test="${child_gender3 == '남자' }">
						                                    <input type="radio" name="cgender4" id="cgender4" value="남자" checked="checked"><span>남자</span>
						                                    <input type="radio" name="cgender4" id="cgender4" value="여자"><span>여자</span>
														</c:when>
														<c:when test="${child_gender3 == '여자' }">
						                                    <input type="radio" name="cgender4" id="cgender4" value="남자"><span>남자</span>
						                                    <input type="radio" name="cgender4" id="cgender4" value="여자" checked="checked"><span>여자</span>
														</c:when>
													</c:choose>
			                                	</div>
	                                		</c:if>
										</c:forTokens>
										
	                                	<div style="display: none" id="cnt">${fn:length(vo.dchildren)}</div>
	                                	
                                		<c:if test="${fn:length(vo.dchildren) < 20}">
                                		<div class="child-info ch2" style="display: none;">
		                                    <input type="text" class="inbox" name="cname2" id="cname2">
		                                    
											<select name="cyear2" id="cyear2" title="년도" class="custom-select"></select>
											<select name="cmonth2" id="cmonth2" title="월" class="custom-select"></select>
											<select name="cday2" id="cday2" title="일" class="custom-select"></select>
											
		                                    <input type="radio" name="cgender2" id="cgender2" value="남자"><span>남자</span>
		                                    <input type="radio" name="cgender2" id="cgender2" value="여자"><span>여자</span>
	                                	</div>
	                                	<div class="child-info ch3" style="display: none;">
		                                    <input type="text" class="inbox" name="cname3" id="cname3">
		                                    
											<select name="cyear3" id="cyear3" title="년도" class="custom-select"></select>
											<select name="cmonth3" id="cmonth3" title="월" class="custom-select"></select>
											<select name="cday3" id="cday3" title="일" class="custom-select"></select>
											
		                                    <input type="radio" name="cgender3" id="cgender3" value="남자"><span>남자</span>
		                                    <input type="radio" name="cgender3" id="cgender3" value="여자"><span>여자</span>			                                	
	                                	</div>
	                                	<div class="child-info ch4" style="display: none;">
		                                    <input type="text" class="inbox" name="cname4" id="cname4">
		                                    
											<select name="cyear4" id="cyear4" title="년도" class="custom-select"></select>
											<select name="cmonth4" id="cmonth4" title="월" class="custom-select"></select>
											<select name="cday4" id="cday4" title="일" class="custom-select"></select>
											
		                                    <input type="radio" name="cgender4" id="cgender4" value="남자"><span>남자</span>
		                                    <input type="radio" name="cgender4" id="cgender4" value="여자"><span>여자</span>			                                	
	                                	</div>
	                                    <div class="child-plus">
	                                    	<button type="button" class="graybtn" id="childPlus">추가하기</button>
	                                    </div>
                                		</c:if>
                                		<c:if test="${fn:length(vo.dchildren) > 21 && fn:length(vo.dchildren) < 40}">
	                                	<div class="child-info ch3" style="display: none;">
		                                    <input type="text" class="inbox" name="cname3" id="cname3">
		                                    
											<select name="cyear3" id="cyear3" title="년도" class="custom-select"></select>
											<select name="cmonth3" id="cmonth3" title="월" class="custom-select"></select>
											<select name="cday3" id="cday3" title="일" class="custom-select"></select>
											
		                                    <input type="radio" name="cgender3" id="cgender3" value="남자"><span>남자</span>
		                                    <input type="radio" name="cgender3" id="cgender3" value="여자"><span>여자</span>			                                	
	                                	</div>
	                                	<div class="child-info ch4" style="display: none;">
		                                    <input type="text" class="inbox" name="cname4" id="cname4">
		                                    
											<select name="cyear4" id="cyear4" title="년도" class="custom-select"></select>
											<select name="cmonth4" id="cmonth4" title="월" class="custom-select"></select>
											<select name="cday4" id="cday4" title="일" class="custom-select"></select>
											
		                                    <input type="radio" name="cgender4" id="cgender4" value="남자"><span>남자</span>
		                                    <input type="radio" name="cgender4" id="cgender4" value="여자"><span>여자</span>			                                	
	                                	</div>
	                                    <div class="child-plus">
	                                    	<button type="button" class="graybtn" id="childPlus">추가하기</button>
	                                    </div>
                                		</c:if>
                                		<c:if test="${fn:length(vo.dchildren) > 41 && fn:length(vo.dchildren) < 60}">
	                                	<div class="child-info ch4" style="display: none;">
		                                    <input type="text" class="inbox" name="cname4" id="cname4">
		                                    
											<select name="cyear4" id="cyear4" title="년도" class="custom-select"></select>
											<select name="cmonth4" id="cmonth4" title="월" class="custom-select"></select>
											<select name="cday4" id="cday4" title="일" class="custom-select"></select>
											
		                                    <input type="radio" name="cgender4" id="cgender4" value="남자"><span>남자</span>
		                                    <input type="radio" name="cgender4" id="cgender4" value="여자"><span>여자</span>			                                	
	                                	</div>
	                                    <div class="child-plus">
	                                    	<button type="button" class="graybtn" id="childPlus">추가하기</button>
	                                    </div>
                                		</c:if>
                                		<c:if test="${fn:length(vo.dchildren) > 61 && fn:length(vo.dchildren) < 80}">
                                		</c:if>
	                                </td>
	                            </tr>                                    
	                        </tbody>
	                    </table>
	                </div>
	                <div class="join_btn">
						<button type="button" class="ibtn" id="btnUpdate">수정하기</button>
						<button type="reset" class="ibtn">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../c_footer.jsp" />
</body>
</html>