<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.githrd.festival.bbs.Bbs" %> 
<%@ page import="com.githrd.festival.bbs.BbsDAO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale"="1">
<link rel="stylesheet" type="text/css" href="/festival/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/festival/resources/css/custom.css">
<title>축제를 즐기다</title>
<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
</style>
</head>
<body>
	<%
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			 pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
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
				<li><a href="/festival/test/testmain.fes">처음으로</a></li>
				<li><a href="#">오늘의 축제</a></li>
				<li><a href="#">축제 정보</a></li>
				<li class="active"><a href="/festival/test/review/reviewlist.fes">축제후기</a></li>
			</ul>
			<%
				if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/festival/test/member/login.fes">로그인</a></li>
						<li><a href="/festival/test/member/join.fes">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<% 		
				} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">내 정보</a></li>
						<li><a href="/festival/test/member/loginAction.fes">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%		
				}
			%>

		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<%
						BbsDAO bbsDAO = new BbsDAO();
						ArrayList<Bbs> list = bbsDAO.getList(pageNumber);
						for(int i=0; i<list.size(); i++) {
										
					%>
<tr>

					<td><%= list.get(i).getBbsID() %></td>
					<td><a href="/festival/test/review/reviewview.fes?bbsID=<%= list.get(i).getBbsID() %>"><%= list.get(i).getBbsTitle() %></a></td>
					<td><%= list.get(i).getUserID() %></td>
					<td>
					<%= 
							//list.get(i).getBbsDate().substring(0, 11)
					list.get(i).getBbsDate().substring(0, 11) + list.get(i).getBbsDate().substring(11, 13) + "시" + list.get(i).getBbsDate().substring(14, 16) + "분 " 
					%>
					</td>
				</tr>
				
					<%
						}
					%>
				
				
			
				</tbody>
			</table>
			
					
<!--  검색창 -->
<form action=/MVC2/MemberSelectController>
	<select name="ch1">
		<option value="custname">축제이름</option>
		<option value="address">축제내용</option>
	</select>
	<input type="text" name="ch2">
	<input type="submit" value="검색하기">
</form>
			
			
			<!-- 페이징 -->
					<%
			if (pageNumber != 1) {
		%>
			<a href="/festival/test/review/reviewlist.fes?pageNumber=<%=pageNumber - 1%>" class="btn btn-success btn-arrow-left">이전</a>
		<%
			} if (bbsDAO.nextPage(pageNumber + 1)) {
		%>
			<a href="/festival/test/review/reviewlist.fes?pageNumber=<%=pageNumber + 1%>" class="btn btn-success btn-arrow-left">다음</a>
		<%
			}
		%>


			
			
			
			<a href="/festival/test/review/write.fes" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>

	<script src="/festival/resources/js/jquery-3.6.0.min.js"></script>
	<script src="/festival/resources/js/bootstrap.js"></script>
</body>
</html>