$(document).ready(function(){
	$(document).on("click","#f_manage", function(){
		$("#f_manage").css('background','url(../../images/minus.png) no-repeat 130px 37px');
		$("#f_sub").css('display','block');
		$("#f_manage").attr('id','f_manageOn');
	});
	$(document).on("click","#f_manageOn", function(){
		$("#f_manageOn").css('background','url(../../images/icon_more_plus.png) no-repeat 130px 37px');
		$("#f_sub").css('display','none');
		$("#f_manageOn").attr('id','f_manage');
	});
	
	$(document).on("click","#c_manage", function(){
		$("#c_manage").css('background','url(../../images/minus.png) no-repeat 130px 37px');
		$("#c_sub").css('display','block');
		$("#c_manage").attr('id','c_manageOn');
	});
	$(document).on("click","#c_manageOn", function(){
		$("#c_manageOn").css('background','url(../../images/icon_more_plus.png) no-repeat 130px 37px');
		$("#c_sub").css('display','none');
		$("#c_manageOn").attr('id','c_manage');
	});
	
	$(document).on("click","#n_manage", function(){
		$("#n_manage").css('background','url(../../images/minus.png) no-repeat 130px 37px');
		$("#n_sub").css('display','block');
		$("#n_manage").attr('id','n_manageOn');
	});
	$(document).on("click","#n_manageOn", function(){
		$("#n_manageOn").css('background','url(../../images/icon_more_plus.png) no-repeat 130px 37px');
		$("#n_sub").css('display','none');
		$("#n_manageOn").attr('id','n_manage');
	});
	
	$(".aside_title").click(function(){
		location.href = '/admin/index';
	});
});