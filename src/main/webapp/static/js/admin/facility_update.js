$(document).ready(function(){
	 $("#btnUpdate").click(function(){
		 if($("#fpname").val() == ""){
			 alert("시설명을 입력하세요.");
			 $("#fpname").focus();
			 return false;
		 } else if($("#fname").val() == ""){
			 alert("대표자명을 입력하세요.");
			 $("#fname").focus();
			 return false;
		 } else if($("#fphone1").val() == ""){
			 alert("연락처를 입력하세요.");
			 $("#fphone1").focus();
			 return false;
		 } else if($("#fphone2").val() == ""){
			 alert("연락처를 입력하세요.");
			 $("#fphone2").focus();
			 return false;
		 } else if($("#fphone3").val() == ""){
			 alert("연락처를 입력하세요.");
			 $("#fphone3").focus();
			 return false;
		 } else if($("#flocation").val() == ""){
			 alert("주소를 입력하세요.");
			 $("#flocation").focus();
			 return false;
		 } else if($("#fstime").val() == ""){
			 alert("운영시간을 입력하세요.");
			 $("#fstime").focus();
			 return false;
		 } else if($("#fetime").val() == ""){
			 alert("운영시간을 입력하세요.");
			 $("#fetime").focus();
			 return false;
		 } else if($("input[name='fweek_list']:checked").length == 0){
			 alert("돌봄요일을 입력하세요.");
			 return false;
		 } else if($("#fprogram").val() == ""){
			 alert("프로그램을 입력하세요.");
			 $("#fprogram").focus();
			 return false;
		 } else {
			 facilityUpdateForm.submit();
		 }
	 });
	 
	 $("#file1").on('change',function(){
		if(window.FileReader){
			var fileName = $(this)[0].files[0].name;
			$("#fname1").text("").text(fileName);
		}
	});
	 $("#file2").on('change',function(){
		if(window.FileReader){
			var fileName = $(this)[0].files[0].name;
			$("#fname2").text("").text(fileName);
		}
	});
	 $("#file3").on('change',function(){
		if(window.FileReader){
			var fileName = $(this)[0].files[0].name;
			$("#fname3").text("").text(fileName);
		}
	});
	 $("#file4").on('change',function(){
		if(window.FileReader){
			var fileName = $(this)[0].files[0].name;
			$("#fname4").text("").text(fileName);
		}
	});
});
