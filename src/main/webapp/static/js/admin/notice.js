$(document).ready(function(){
	$("#writeSubmitBtn").click(function(){
		if($("#btitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#btitle").focus();
			return false;
		}else if($("#bcontent").val() == ""){
			alert("내용을 입력해주세요");
			$("#bcontent").focus();
			return false;
		} else {
			noticeWriteForm.submit();
		}
	});
	
	//파일선택
	$("input[type=file]").on('change',function(){
		if(window.FileReader){
			var fileName = $(this)[0].files[0].name;
			$("#fname").text("").text(fileName);
		}
	});
	
	$("#updateSubmitBtn").click(function(){
		if($("#btitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#btitle").focus();
			return false;
		}else if($("#bcontent").val() == ""){
			alert("내용을 입력해주세요");
			$("#bcontent").focus();
			return false;
		} else {
			noticeUpdateForm.submit();
		}
	});
	
	var oldValIntro;
	$("#btitle").on("propertychange change keyup paste input", function() {
		var currentVal = $(this).val();
		if(currentVal == oldValIntro) {
			return;
		}
		
		if($(this).val().length>30){
			alert('제목은 30자 이하로 써주세요');
			$('#btitle').val("");
			$('#btitle').focus();
			return;
		}
	});
	
	var oldValIntro2;
	$("#bcontent").on("propertychange change keyup paste input", function() {
		var currentVal = $(this).val();
		if(currentVal == oldValIntro2) {
			return;
		}
		
		if($(this).val().length>300){
			alert('내용은 300자 이하로 써주세요');
			$('#bcontent').val("");
			$('#bcontent').focus();
			return;
		}
		$('#bcontent_count').text($(this).val().length);
		oldValIntro = currentVal;
	});
});