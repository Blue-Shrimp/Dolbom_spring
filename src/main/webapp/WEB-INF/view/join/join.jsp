<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../css/join.css">
<script src="../js/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
    integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
    crossorigin="anonymous"></script>
<script src="../js/join.js"></script>
<script>
	if("${msg}"){
		alert("회원가입에 실패했습니다.");	
	}
</script>
</head>
<body>
	<div class="wrap">
		<div class="join">
			<div class="join-content">
				<h1><img src="../images/24.png" alt="정부24"></h1>
				<div class="title">
			        <h1>회원가입</h1>
			    </div>
			    <div class="contentsWrap">
			    	<div class="contents">
			    		<form name="joinForm" action="join_proc.do" method="post" class="join">
			    			<div class="jtitle"><span class="red">*</span>표시 항목은 필수 입력 항목 입니다.</div>
			    			<div class="tbl-list form">
			                    <table>
			                        <tbody>
			                            <tr>
			                                <th>
			                                    <span class="red">*</span>아이디
			                                </th>
			                                <td>
			                                    <span class="input-btn type1">
			                                        <input type="text" class="inbox" name="did" id="did">
			                                        <button class="ibtn" type="button" id="idCheck">중복확인</button>
			                                    </span>
			                                    <span class="input-desc">(5~20자 까지 영문/숫자만 허용)</span>
			                                    <div id="idcheck_result"></div>
			                                </td>
			                            </tr>
			                            <tr>
			                                <th>
			                                    <span class="red">*</span>비밀번호
			                                </th>
			                                <td>
	                                     		<input type="password" class="inbox" name="dpass" id="dpass">
	                                        	<p class="input-desc">(6~12자까지 모든 문자+숫자+특수문자 : 영문 대소문자는 구별하여 입력해 주세요)<br>
																		- 사용불가능한 특수문자 예  : &lt;, &gt;, _, ", ' 
												</p>
			                                </td>
			                            </tr>
			                            <tr>
			                                <th>
			                                    <span class="red">*</span>비밀번호확인
			                                </th>
			                                <td>
		                                     	<input type="password" class="inbox" name="passCheck" id="passCheck">
		                                        <span class="input-desc">(비밀번호를 다시 한번 입력하세요)</span>
		                                        <div id="msg"></div>
			                                </td>
			                            </tr>
			                            <tr>
			                                <th>
			                                    <span class="red">*</span> 이름
			                                </th>
			                                <td>
			                                    <span class="input-btn type1">
			                                        <input type="text" class="inbox" name="dname" id="dname">
			                                    </span>
			                                </td>
			                            </tr>
			                            <tr>
			                                <th>
			                                    <span class="red">*</span>연락처
			                                </th>
			                                <td class="input-num type1 input-btn">
			                                    <input type="tel" class="inbox" name="dphone1" id="dphone1">
			                                    <span>-</span>
			                                    <input type="tel" class="inbox" name="dphone2" id="dphone2">
			                                    <span>-</span>
			                                    <input type="tel" class="inbox" name="dphone3" id="dphone3">
			                                </td>
			                            </tr>
			                            <tr>
			                                <th>
			                                    <span class="red">*</span>이메일
			                                </th>
			                                <td class="input-num type2 input-email">
			                                    <input type="text" id="demail1" name="demail1" class="inbox">
			                                    <span>@</span>
			                                    <input type="text" id="demail2" name="demail2" class="inbox" disabled="">
			                                    <p class="email-select">
			                                        <select name="demail3" id="demail3">
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
			                                <th>
			                                    <span class="red">*</span>주소
			                                </th>
			                                <td class="addr">
			                                    <span class="input-btn type2">
			                                        <input type="text" class="inbox" id="darea" name="darea" readonly="readonly">
			                                        <button class="ibtn" type="button" id="searchAddr" onclick="goPopup()">주소검색</button>
			                                    </span>
			                                </td>
			                            </tr>
			                            <tr>
			                                <th>
			                                    <span class="red">*</span>자녀현황
			                                </th>
			                                <td class="input-child type1">
			                                	<div class="ctitle">
			                                		<span>이름</span><span>생년월일</span><span>성별</span>
			                                	</div>
			                                	<div class="child-info ch1">
				                                    <input type="text" class="inbox" name="cname" id="cname">
				                                    
													<select name="cyear" id="cyear" title="년도" class="custom-select"></select>
													<select name="cmonth" id="cmonth" title="월" class="custom-select"></select>
													<select name="cday" id="cday" title="일" class="custom-select"></select>
													
				                                    <input type="radio" name="cgender" id="cgender" value="남자"><span>남자</span>
				                                    <input type="radio" name="cgender" id="cgender" value="여자"><span>여자</span>			                                	
			                                	</div>
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
			                                    	<button type="button" class="ibtn" id="childPlus">추가하기</button>
			                                    	<button type="button" class="ibtn" id="childMinus">제거하기</button>
			                                    </div>
			                                    
			                                </td>
			                            </tr>                                    
			                        </tbody>
			                    </table>
			                </div>
			                <div class="join_btn">
								<button type="button" class="btn_style" id="btnJoin">가입하기</button>
								<button type="reset" class="btn_style">취소</button>
							</div>
			    		</form>
			    	</div>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>