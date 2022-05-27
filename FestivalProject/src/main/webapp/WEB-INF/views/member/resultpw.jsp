<!-- 
/**
 *  비밀번호 찾기 결과 페이지
 * @author	이승연
 * @since	2022/05/24
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.24	-	jsp 제작
 * 								담당자 : 이승연
 *
 */
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 바꾸기</title>
<link rel="stylesheet" type="text/css" href="/festival/resources/css/w3.css"/>
<link rel="stylesheet" type="text/css" href="/festival/resources/css/base.css"/>
<link rel="stylesheet" type="text/css" href="/festival/resources/css/tmddus.css"/>
<script type="text/javascript" src="/festival/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/festival/resources/js/base.js"></script>
<script type="text/javascript" src="/festival/resources/js/tmddus.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
<div class="w3-content w3-center w600">
		<a href="/festival/"><img src="/festival/resources/img/logo.png" class="blogo"></a>
		<form method="POST" action="" name="frm" id="frm"
			class="w3-col w3-margin-top w3-margin-bottom w3-padding w3-border">
			<div class="w3-border w3-center">
				<h2>비밀번호 바꾸기</h2>
				<h4>비밀번호를 새로 입력해주세요</h4>
				<input type="text" placeholder="비밀번호" id="fpw" name="fpw"><br>
				<input type="text" placeholder="비밀번호 확인" id="fpwck" name="fpwck"><br>
				<div class="w3-button" id = "findbtn4">바꾸기</div>
			</div>
		</form>
</div>


</body>
</html>