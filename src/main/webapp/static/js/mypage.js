$(document).ready(function(){
	$("#btnPassEdit").click(function(){
		if(!passRuleCheck($("#dpass"))){
			$("#dpass").val("");
			$("#passCheck").val("");
			return false;
		}else {
			if($("#dpass").val() != "" && $("#passCheck").val() != ""){	
				if($("#dpass").val() == $("#passCheck").val()){
					passEditForm.submit(); 
				}else{
					alert(("패스워드가 다릅니다. 다시 입력해주세요"));
					$("#dpass").val("");
					$("#passCheck").val("");
					$("#dpass").focus();
					return false;				
				}		
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
	
	setDateBox();
	
	var cnt = Number($("#cnt").text());
	$("#childPlus").click(function(){
		if(cnt < 20){
			$(".ch2").css('display','block');
			cnt+=16;
			$("#cnt").text(cnt);
		} else if(cnt > 21 && cnt < 40){
			$(".ch3").css('display','block');
			cnt+=16;
			$("#cnt").text(cnt);
		} else if(cnt > 41 && cnt < 60){
			$(".ch4").css('display','block');
			cnt+=16;
			$("#cnt").text(cnt);
		} else if(cnt > 61 && cnt < 80){
			alert("최대 4명의 자녀까지 등록할 수 있습니다.");
		}
		
	});
	
	$("#childMinus").click(function(){
		if(cnt == 3){
			$(".ch4").css('display','none');
			cnt --;
		} else if(cnt == 2){
			$(".ch3").css('display','none');
			cnt --;
		} else if(cnt == 1){
			$(".ch2").css('display','none');
			cnt --;
		} else if(cnt == 0){
			alert("최소 1명의 자녀는 등록해야합니다.");;
		}
		
	});
	
	$("#btnUpdate").click(function(){
		if($("#dname").val() == ""){
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
		}else if($("#cname").val() == ""){
			alert("자녀의 이름을 입력해주세요");
			$("#cname").focus();
			return false;
		}else if($("#cyear").val() == ''){
			alert("자녀의 생년월일을 입력해주세요");
			$("#cyear").focus();
			return false;
		}else if($("#cmonth").val() == ''){
			alert("자녀의 생년월일을 입력해주세요");
			$("#cmonth").focus();
			return false;
		}else if($("#cday").val() == ''){
			alert("자녀의 생년월일을 입력해주세요");
			$("#cday").focus();
			return false;
		}else if($("input[name='cgender']:checked").length == 0){ 
			alert("자녀의 성별을 선택해 주세요");
			return false;
		}else {
			updateForm.submit();
		}
	});
});

function passRuleCheck(obj){
	var regExp = /^.*(?=^.{6,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
	if(obj.val() == ""){
		alert("비밀번호를 입력해주세요");
		obj.focus();
		return false;
	}else{
		if(regExp.test(obj.val())){
			return true;
		}else{
			alert("6~12자의 문자+숫자+특수문자로 입력해주세요");
			obj.focus();
			return false;
		}
	}	

}

function goPopup(){
	var pop = window.open("../../popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr){
	document.updateForm.darea.value = roadFullAddr;		
}

function setDateBox() {
	  var dt = new Date();
	  var year = "";
	  var com_year = dt.getFullYear();
	
	  $("#cyear").append("<option value=''>년도</option>");
	  $("#cyear2").append("<option value=''>년도</option>");
	  $("#cyear3").append("<option value=''>년도</option>");
	  $("#cyear4").append("<option value=''>년도</option>");
	
	  for (var y = (com_year - 50); y <= (com_year + 1); y++) {
	    $("#cyear").append("<option value='" + y + "'>" + y + " 년" + "</option>");
	  }
	  for (var y = (com_year - 50); y <= (com_year + 1); y++) {
	    $("#cyear2").append("<option value='" + y + "'>" + y + " 년" + "</option>");
	  }
	  for (var y = (com_year - 50); y <= (com_year + 1); y++) {
	    $("#cyear3").append("<option value='" + y + "'>" + y + " 년" + "</option>");
	  }
	  for (var y = (com_year - 50); y <= (com_year + 1); y++) {
	    $("#cyear4").append("<option value='" + y + "'>" + y + " 년" + "</option>");
	  }
	
	  var month;
	  $("#cmonth").append("<option value=''>월</option>");
	  for (var i = 1; i <= 12; i++) {
	    $("#cmonth").append("<option value='" + i + "'>" + i + " 월" + "</option>");
	  }
	  $("#cmonth2").append("<option value=''>월</option>");
	  for (var i = 1; i <= 12; i++) {
	    $("#cmonth2").append("<option value='" + i + "'>" + i + " 월" + "</option>");
	  }
	  $("#cmonth3").append("<option value=''>월</option>");
	  for (var i = 1; i <= 12; i++) {
	    $("#cmonth3").append("<option value='" + i + "'>" + i + " 월" + "</option>");
	  }
	  $("#cmonth4").append("<option value=''>월</option>");
	  for (var i = 1; i <= 12; i++) {
	    $("#cmonth4").append("<option value='" + i + "'>" + i + " 월" + "</option>");
	  }
	
	  var day;
	  $("#cday").append("<option value=''>일</option>");
	  for (var i = 1; i <= 31; i++) {
	    $("#cday").append("<option value='" + i + "'>" + i + " 일" + "</option>");
	  }
	  $("#cday2").append("<option value=''>일</option>");
	  for (var i = 1; i <= 31; i++) {
	    $("#cday2").append("<option value='" + i + "'>" + i + " 일" + "</option>");
	  }
	  $("#cday3").append("<option value=''>일</option>");
	  for (var i = 1; i <= 31; i++) {
	    $("#cday3").append("<option value='" + i + "'>" + i + " 일" + "</option>");
	  }
	  $("#cday4").append("<option value=''>일</option>");
	  for (var i = 1; i <= 31; i++) {
	    $("#cday4").append("<option value='" + i + "'>" + i + " 일" + "</option>");
	  }

	}