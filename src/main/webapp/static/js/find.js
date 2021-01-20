	$(document).ready(function(){
		$("#btnFindId").click(function(){
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
			}else {
				findIdForm.submit();
			}
		});
		
		$("#btnFindPass").click(function(){
			if($("#did").val() == ""){
				alert("아이디를 입력해주세요");
				$("#did").focus();
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
			}else {
				findPassForm.submit();
			}
		});
	});
	
