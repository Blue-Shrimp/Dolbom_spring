<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="shortcut icon" type="../image/png" href="../images/favicon.png">
<link rel="stylesheet" href="../css/find.css">
<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../js/find.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="find">
			<div class="find-content">
				<h1><img src="../images/24.png" alt="정부24"></h1>
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
			                                <th>아이디</th>
			                                <td>
			                               		<span class="input-btn type1">
			                                        <input type="text" class="inbox" value="${id }" disabled="disabled">
			                                    </span>
			                                </td>
			                            </tr>
									</tbody>
								</table>
							</div>
							<div class="find_btn">
								<a href="findPass" class="btn_style">비밀번호 찾기</a>
								<a href="../login" class="btn_style">로그인</a>
							</div>
						</form>
					</div>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>