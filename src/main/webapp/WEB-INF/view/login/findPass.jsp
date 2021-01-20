<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="shortcut icon" type="image/png" href="../images/favicon.png">
<link rel="stylesheet" href="../css/find.css">
<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../js/find.js"></script>
<script>
	if("${msg}"){
		alert("정보가 잘못되었습니다.");	
	}
</script>
</head>
<body>
	<div class="wrap">
		<div class="find">
			<div class="find-content">
				<h1><img src="../images/24.png" alt="정부24"></h1>
				<div class="title">
			        <h1>비밀번호 찾기</h1>
			    </div>
			    <div class="contentsWrap">
			    	<div class="contents">
			    		<form name="findPassForm" action="findPass_proc.do" method="post" class="find">
			    			<div class="tbl-list form">
			                    <table>
			                        <tbody>
			                        	<tr>
			                                <th>아이디</th>
			                                <td>
			                                    <span class="input-btn type1">
			                                        <input type="text" class="inbox" name="did" id="did">
			                                    </span>
			                                </td>
			                            </tr>
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
								<button type="button" class="btn_style" id="btnFindPass">비밀번호 찾기</button>
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