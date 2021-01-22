<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="../css/find.css">
<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../js/find.js"></script>
<script>
	if("${msg}"){
		alert("가입된 아이디가 없습니다.");	
	}
</script>
</head>
<body>
	<div class="wrap">
		<div class="find">
			<div class="find-content">
				<h1><img src="../images/logo_remove_bg.png"></h1>
				<div class="title">
			        <h1>아이디 찾기</h1>
			    </div>
			    <div class="contentsWrap">
			    	<div class="contents">
			    		<form name="findIdForm" action="findId_proc.do" method="post" class="find">
			    			<div class="tbl-list form">
			                    <table>
			                        <tbody>
			                            <tr>
			                                <th>성명</th>
			                                <td>
			                                    <span class="input-btn type1">
			                                        <input type="text" class="inbox" name="dname" id="dname">
			                                    </span>
			                                </td>
			                            </tr>
			                            <tr>
			                                <th>휴대전화번호</th>
			                                <td class="input-num type1 input-btn">
			                                    <input type="tel" class="inbox" name="dphone1" id="dphone1">
			                                    <span>-</span>
			                                    <input type="tel" class="inbox" name="dphone2" id="dphone2">
			                                    <span>-</span>
			                                    <input type="tel" class="inbox" name="dphone3" id="dphone3">
			                                </td>
			                            </tr>
									</tbody>
								</table>
							</div>
							<div class="find_btn">
								<button type="button" class="btn_style" id="btnFindId">아이디 찾기</button>
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