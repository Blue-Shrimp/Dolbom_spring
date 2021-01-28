$(document).ready(function(){
	 $("#writeReviewClose").click(function(){
		 $("#osCareReview").attr('class','_formStyle-layer-wrap');
		 $(".os-rating-medium-inner").css('width','0');
		 $("#rservice").val("");
		 $("#rcontent").val("");
		$("#osCareReview").css('display','none');
	 });
	 
	 $("#score1").click(function(){
		$(".os-rating-medium-inner").css('width','20%');
	});	 
	 $("#score2").click(function(){
			$(".os-rating-medium-inner").css('width','40%');
		});	
	 $("#score3").click(function(){
			$(".os-rating-medium-inner").css('width','60%');
		});	
	 $("#score4").click(function(){
			$(".os-rating-medium-inner").css('width','80%');
		});	
	 $("#score5").click(function(){
			$(".os-rating-medium-inner").css('width','100%');
		});
	 
	 var oldValIntro;
	 $("#rcontent").on("propertychange change keyup paste input", function() {
			var currentVal = $(this).val();
			if(currentVal == oldValIntro) {
				return;
			}
			
			if($(this).val().length>50){
				alert('후기는 50자 이하로 써주세요');
				$('#rcontent').val(oldValIntro).focus();
				return;
			}
		});
	 
});

function readReview(obj, rid){
	var $this = $(obj);
	
	$("#"+rid+"").css('display','block');
}

function readReviewClose(obj, rid){
	var $this = $(obj);
	
	$("#"+rid+"").find(".review_show").css('display','block');
	$("#"+rid+"").find(".review_update").css('display','none');
	$("#"+rid+"").find(".os-rating-medium-inner").css('width','0');
	$("#"+rid+"").find("#rservice").val("");
	$("#"+rid+"").find("#rcontent").val("");
	$("#"+rid+"").css('display','none');
}

function writeReview(obj, fid){
	var $this = $(obj);
	
	$("#osCareReview").addClass(fid);
	$("#osCareReview").css('display','block');
	$("#fid").val(fid);
	$("#btnSaveReview").attr('onclick',"saveReview('"+fid+"')");
}

function getScore(fid){
	return $("#osCareReview").find(".os-rating-medium-inner")[0].style.width.replace(/%/g,"") / 20;
}

function saveReview(fid){
	var score = getScore(fid);
	var content = $("#rcontent").val();
	
	if(score == 0){
		alert("별점을 선택 해주세요.");
		return false;
	} else if(content == ""){
		alert("내용을 입력 해주세요.");
		return false;
	} else {
		$("#reviewWriteForm").find("#rservice").val(score);
		reviewWriteForm.submit();
	}
}

function updateForm(obj, rid){
	$("#"+rid+"").find(".review_show").css('display','none');
	$("#"+rid+"").find(".review_update").css('display','block');
}

function score1(obj, rid){
	$("#"+rid+"").find(".os-rating-medium-inner").css('width','20%');
}
function score2(obj, rid){
	$("#"+rid+"").find(".os-rating-medium-inner").css('width','40%');
}
function score3(obj, rid){
	$("#"+rid+"").find(".os-rating-medium-inner").css('width','60%');
}
function score4(obj, rid){
	$("#"+rid+"").find(".os-rating-medium-inner").css('width','80%');
}
function score5(obj, rid){
	$("#"+rid+"").find(".os-rating-medium-inner").css('width','100%');
}

function getUpdateScore(rid){
	return $("#"+rid+"").find(".os-rating-medium-inner")[0].style.width.replace(/%/g,"") / 20;
}

function updateReview(obj, rid){
	var score = getUpdateScore(rid);
	var content = $("#"+rid+"").find("#rcontent").val();
	var form = document.getElementById("reviewUpdateForm_"+rid);
	
	if(score == 0){
		alert("별점을 선택 해주세요.");
		return false;
	} else if(content == ""){
		alert("내용을 입력 해주세요.");
		return false;
	} else {
		$("#"+rid+"").find("#rservice").val(score);
		form.submit();
	}
}
