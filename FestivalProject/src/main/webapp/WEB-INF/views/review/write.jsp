<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale"="1">
<link rel="stylesheet" type="text/css" href="/festival/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/festival/resources/css/custom.css">
<title>축제를 즐기다</title>

<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
		
		}
		
		
		
	
.star-rating {
  border:solid 1px #ccc;
  display:flex;
  flex-direction: row-reverse;
  font-size:1.5em;
  justify-content:space-around;
  padding:0 .2em;
  text-align:center;
  width:5em;
}

.star-rating input {
  display:none;
}

.star-rating label {
  color:#ccc;
  cursor:pointer;
}

.star-rating :checked ~ label {
  color:#f90;
}

.star-rating label:hover,
.star-rating label:hover ~ label {
  color:#fc0;
}

/* explanation */

article {
  background-color:#ffe;
  box-shadow:0 0 1em 1px rgba(0,0,0,.25);
  color:#006;
  font-family:cursive;
  font-style:italic;
  margin:4em;
  max-width:30em;
  padding:2em;
}
		
		
		
		
		
		
		
</style>

</head>
<body>

	<%
		String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	%>
	
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/festival/test/testmain.fes">축제를 즐기다</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/festival/test/testmain.fes">처음으로</a></li>
				<li><a href="#">오늘의 축제</a></li>
				<li><a href="#">축제 정보</a></li>
				<li><a href="/festival/test/review/reviewlist.fes">축제후기</a></li>
			</ul>
			<%
				if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/festival/test/member/login.fes">로그인</a></li>
						<li><a href="/festival/test/member/join.fes">회원가입</a></li>
					</ul></li>
			</ul>
			<%
				} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">내 정보</a></li>
						<li><a href="/festival/test/member/logoutAction.fes">로그아웃</a></li>
					</ul></li>
			</ul>
			<%
				}
			%>

		</div>
	</nav>
	<div class="container">
		<div class="row">

			<form method="post" action="/festival/test/review/writeAction.fes">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
								글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
							</tr>
							
							<tr><td>별점
						
					<div class="star-rating">
 						<input type="radio" id="5-stars" name="rating" value="5" />
  						<label for="5-stars" class="star">&#9733;</label>
  						<input type="radio" id="4-stars" name="rating" value="4" />
 						<label for="4-stars" class="star">&#9733;</label>
 						<input type="radio" id="3-stars" name="rating" value="3" />
 						<label for="3-stars" class="star">&#9733;</label>
 						<input type="radio" id="2-stars" name="rating" value="2" />
 						<label for="2-stars" class="star">&#9733;</label>
						<input type="radio" id="1-star" name="rating" value="1" />
						<label for="1-star" class="star">&#9733;</label>
					</div>
			
							</td></tr>
							
							<tr>
							<td><textarea class="form-control"
									placeholder="글 내용" name="bbsContent" maxlength="2048"
									style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
			</form>
		</div>
	</div>
	<script src="/festival/resources/js/jquery-3.6.0.min.js"></script>
	<script src="/festival/resources/js/bootstrap.js"></script>
</body>
</html>