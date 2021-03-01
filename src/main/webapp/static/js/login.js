function ruleCheck(obj){
	if(obj.val() == ""){
		alert("아이디를 입력해주세요");
		obj.focus();
		return false;
	}else{
			return true;
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