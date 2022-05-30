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

	<script src="/festival/resources/js/jquery-3.6.0.min.js"></script>
	<script src="/festival/resources/js/bootstrap.js"></script>

<title>축제를 즐기다1</title>
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
  	int bbsID = 0;
  	if (request.getParameter("bbsID") != null) {
  		bbsID = Integer.parseInt(request.getParameter("bbsID"));
  	}
  	if (bbsID == 0) {
  		PrintWriter script = response.getWriter();
  		script.println("<script>");
  		script.println("alert('유효하지 않는 글입니다.')");
  		script.println("location.href = '/festival/test/review/reviewlist.fes'");
  		script.println("history.back()");
  		script.println("</script>");
  	}
  	Bbs bbs = new BbsDAO().getBbs(bbsID);

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
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">게시판
							글보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">글제목</td>
						<td colspan="2"><%= bbs.getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%= bbs.getUserID() %></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%= bbs.getBbsDate().substring(0, 11) + bbs.getBbsDate().substring(11, 13) + "시" + bbs.getBbsDate().substring(14, 16) + "분 " %></td>
					</tr>
					
					
					<tr>
					<td>별점</td>
						<td colspan="2">
						<input type="text" id="ratings" style="display:none" value="<%= bbs.getRating() %>점" >
	
<div class="star-rating">
  <input type="radio" id="5-star" name="rating" value="5" />
  <label for="5-stars" class="star">&#9733;</label>
  <input type="radio" id="4-star" name="rating" value="4" />
  <label for="4-stars" class="star">&#9733;</label>
  <input type="radio" id="3-star" name="rating" value="3" />
  <label for="3-stars" class="star">&#9733;</label>
  <input type="radio" id="2-star" name="rating" value="2" />
  <label for="2-stars" class="star">&#9733;</label>
  <input type="radio" id="1-star" name="rating" value="1" />
  <label for="1-star" class="star">&#9733;</label>
</div>
						<script>
						$("input:radio[id='<%= bbs.getRating() %>-star']").prop("checked", true); 
						</script>
						
						</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height: 200px; text-align: left;"><%= bbs.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
					
					
					
					<!--  사진넣기 -->
					
					<tr>
						<td>첨부사진</td>
<td>
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					목포 - 항구축제<img src="/festival/resources/img/1.jpg">
				</div>
				<div class="item">
					영월 - 동강축제<img src="/festival/resources/img/2.jpg">
				</div>
				<div class="item">
					대구 - 치맥페스티벌<img src="/festival/resources/img/3.jpg">
				</div>
				<div class="item">
					포항 - 국제불빛축제<img src="/festival/resources/img/4.jpg">
				</div>
				<div class="item">
					무주 - 반딧불이축제<img src="/festival/resources/img/5.jpg">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> 
			</a>
		</div>
	</div>
	</td>
					</tr>
					
					
					<tr><td></td>
					<td>
					<iframe width="560" height="315" src="https://www.youtube.com/embed/yoRe4tiAC5c" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					</td></tr>

					
					
					
					
					
				</tbody>
			</table>
			<a href="/festival/test/review/reviewlist.fes" class="btn btn-primary">목록</a>
			<%
				if (userID != null && userID.equals(bbs.getUserID())) {
			%>
					
			
			
			<a href="/festival/test/review/update.fes?bbsID=<%= bbsID %>" class="btn btn-primary">수정</a>
			<a onclick="return confirm('정말로 삭제하시겠습니까?')"
				href="/festival/test/review/deleteAction.fes?bbsID=<%= bbsID %>" class="btn btn-primary">삭제</a>
			<%
				}
			%>
		</div>
	</div>

</body>
</html>