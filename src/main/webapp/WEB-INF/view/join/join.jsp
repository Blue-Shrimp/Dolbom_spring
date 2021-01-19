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
<script>
	$(document).ready(function(){
		var idCheck = 0;
		var passCheck = 0;
		
		$("#idCheck").click(function(){
			if(!ruleCheck($("#did"))){
				return false;
			}else{
				$.ajax({
					url:"idCheck.do?did="+$("#did").val(), 
					success:function(result){
						if(result == 1){
							$("#idcheck_result").text("이미 중복된 아이디가 존재합니다. 다시 입력해주세요")
							.css("color","red");
							$("#did").focus();
							return false;
						}else{
							$("#idcheck_result").text("사용가능한 아이디 입니다.")
							.css("color","blue");
							$("#dpass").focus();
							idCheck = 1;
							return true;
						}
					}
					
				});
			}			
		});
		
		$("#passCheck").focusout(function(){
			if($("#dpass").val() != "" && $("#passCheck").val() != ""){	
				if($("#dpass").val() == $("#passCheck").val()){					
					$("#msg").text("패스워드가 동일합니다").css("color","blue");
					$("#dname").focus();
					passCheck = 1;
					return true; 
				}else{
					$("#msg").text("패스워드가 다릅니다. 다시 입력해주세요").css("color","red");
					$("#dpass").val("");
					$("#passCheck").val("");
					$("#dpass").focus();
					passCheck = 0;
					return false;				
				}		
			}
		});
		
		$("#demail3").change(function(){
			if($("#demail3").val() != "이메일선택"){
				if($("#demail3").val() != "self"){
					$("#demail2").attr("disabled","");
					$("#demail2").val($("#demail3").val());				
				} else {
					$("#demail2").removeAttr("disabled");
					$("#demail2").val("");
					$("#demail2").focus();
					return false;
				}
			} else {
				$("#demail2").val("");			
			}
		});
		
		$("#btnJoin").click(function(){
			if(!ruleCheck($("#did"))){			
				return false;
			}else if($("#dpass").val() == ""){
				alert("패스워드를 입력해주세요");
				$("#dpass").focus();
				return false;
			}else if($("#passCheck").val() == ""){
				alert("패스워드 확인을 입력해주세요");
				$("#passCheck").focus();
				return false;
			}else if($("#dname").val() == ""){
				alert("이름을 입력해주세요");
				$("#dname").focus();
				return false;
			}else if($("#dphone1").val() == ""){
				alert("전화번호를 선택해주세요");
				$("#dphone1").focus();
				return false;
			}else if($("#dphone2").val() == ""){
				alert("전화번호를 입력해주세요");
				$("#dphone2").focus();
				return false;
			}else if($("#dphone3").val() == ""){
				alert("전화번호를 입력해주세요");
				$("#dphone3").focus();
				return false;
			}else if($("#demail1").val() == ""){
				alert("이메일을 입력해주세요");
				$("#demail1").focus();
				return false;
			}else if($("#demail2").val() == ""){
				alert("이메일을 입력해주세요");
				$("#demail2").focus();
				return false;
			}else if($("#darea").val() == ""){
				alert("주소를 입력해주세요");
				$("#darea").focus();
				return false;
			}else if($("#dchildren1").val() == ""){
				alert("자녀의 이름을 입력해주세요");
				$("#dchildren1").focus();
				return false;
			}else if($("#year").val() == ''){
				alert("자녀의 생년월일을 입력해주세요");
				$("#year").focus();
				return false;
			}else if($("#month").val() == ''){
				alert("자녀의 생년월일을 입력해주세요");
				$("#month").focus();
				return false;
			}else if($("#day").val() == ''){
				alert("자녀의 생년월일을 입력해주세요");
				$("#day").focus();
				return false;
			}else if($("input[name='dchildren3']:checked").length == 0){ 
				alert("자녀의 성별을 선택해 주세요");
				return false;
			}else if(idCheck == 0){ 
				alert("아이디 중복확인을 해주세요");
				return false;
			}else if(passCheck == 0){ 
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}else {
				joinForm.submit();
			}
		});
		
		setDateBox();
	});
	
	function ruleCheck(obj){
		var regExp = /^[a-z]+[a-z0-9]{4,19}$/g;
		
		if(obj.val() == ""){
			alert("아이디를 입력해주세요");
			obj.focus();
			return false;
		}else{
			if(regExp.test(obj.val())){
				return true;
			}else{
				alert("5~20자의 영소문자와 숫자 형식으로 입력해주세요");
				obj.focus();
				return false;
			}
		}	

	}
	
	function goPopup(){
		var pop = window.open("/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	
	function jusoCallBack(roadFullAddr){
		document.joinForm.darea.value = roadFullAddr;		
	}

	function setDateBox() {
	  var dt = new Date();
	  var year = "";
	  var com_year = dt.getFullYear();
	
	  $("#year").append("<option value=''>년도</option>");
	
	  for (var y = (com_year - 50); y <= (com_year + 1); y++) {
	    $("#year").append("<option value='" + y + "'>" + y + " 년" + "</option>");
	  }
	
	  var month;
	  $("#month").append("<option value=''>월</option>");
	  for (var i = 1; i <= 12; i++) {
	    $("#month").append("<option value='" + i + "'>" + i + " 월" + "</option>");
	  }
	
	  var day;
	  $("#day").append("<option value=''>일</option>");
	  for (var i = 1; i <= 31; i++) {
	    $("#day").append("<option value='" + i + "'>" + i + " 일" + "</option>");
	  }

	  }
</script>
</head>
<body>
	<div class="wrap">
		<div class="join">
			<div class="join-content">
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
			                                            <option value="self">직접입력</option>
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
			                                    <span class="red">*</span>자식현황
			                                </th>
			                                <td class="input-child type1">
			                                	<div class="ctitle">
			                                		<span>이름</span><span>생년월일</span><span>성별</span>
			                                	</div>
			                                	<div class="child-info">
				                                    <input type="text" class="inbox" name="dchildren1" id="dchildren1">
				                                    
													<select name="year" id="year" title="년도" class="custom-select"></select>
													<select name="month" id="month" title="월" class="custom-select"></select>
													<select name="day" id="day" title="일" class="custom-select"></select>
													
				                                    <input type="radio" name="dchildren3" id="dchildren3" value="남자"><span>남자</span>
				                                    <input type="radio" name="dchildren3" id="dchildren3" value="남자"><span>여자</span>			                                	
			                                	</div>
			                                    <div class="child-plus">
			                                    	<button type="button" class="ibtn" id="childPlus">추가하기</button>
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