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

$(document).ready(function(){
	$("#btnLogin").click(function(){
		
		if(!ruleCheck($("#did"))){
			return false;
		}else if($("#dpass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#dpass").focus();
			return false;
		}else{
			loginForm.submit();
		}		
	});
});