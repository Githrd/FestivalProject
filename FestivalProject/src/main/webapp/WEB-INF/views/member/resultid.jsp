<!-- 
/**
 *  아이디 찾기 결과 페이지
 * @author	이승연
 * @since	2022/05/24
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.24	-	jsp 제작
 * 								담당자 : 이승연
 *
 */
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
<link rel="stylesheet" type="text/css" href="/festival/resources/css/w3.css"/>
<link rel="stylesheet" type="text/css" href="/festival/resources/css/base.css"/>
<link rel="stylesheet" type="text/css" href="/festival/resources/css/tmddus.css"/>
<script type="text/javascript" src="/festival/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/festival/resources/js/base.js"></script>
<script type="text/javascript" src="/festival/resources/js/tmddus.js"></script>
</head>
<body>
<div class="w3-content w3-center w600">
		<a href="/festival/"><img src="/festival/resources/img/logo.png" class="blogo"></a>
			<form method="POST" action="" name="frm" id="frm"
				class="w3-col w3-margin-top w3-margin-bottom w3-padding w3-border">
				<div class="w3-border w3-center">
					<h2>아이디 찾기</h2>
					<h4>회원님의 아이디는 '${FID}' 입니다.</h4>
				</div>
			</form>
		<div class="w3-col">
			<div class="w3-half w3-light-gray w3-button" id="findpwbtn">비밀번호 찾기</div> 
			<div class="w3-half w3-dark-gray w3-button" id="loginbtn2">로그인하기</div> 
		</div>
	</div>
</body>
</html>