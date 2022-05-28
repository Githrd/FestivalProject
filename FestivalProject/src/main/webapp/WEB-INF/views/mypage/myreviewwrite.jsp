<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<%--
		리뷰 게시글 작성 뷰
		
								2022/05/29
								
							코드 작성자 : 김수경
 --%>
       <meta charset="utf-8" />
       <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
       <meta name="description" content="" />
       <meta name="author" content="" />
       <title>마이페이지</title>
       <!-- Favicon-->
       <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
       <!-- Font Awesome icons (free version)-->
       <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
       <!-- Google fonts-->
       <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
       <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
       <!-- Core theme CSS (includes Bootstrap)-->
       <link rel="stylesheet" type="text/css" href="/festival/resources/css/styles.css"/>
       <link rel="stylesheet" type="text/css" href="/festival/resources/css/w3.css"/>
       <link rel="stylesheet" type="text/css" href="/festival/resources/css/mypage.css"/>
       <script type="text/javascript" src="/festival/resources/js/jquery-3.6.0.min.js"></script>
       <script type="text/javascript" src="/festival/resources/js/mypage.js"></script>
       <style type="text/css">   


     	</style>
	
</head>
<body>
    <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand logo" href="/festival/"><img src="/festival/resources/img/logo.png" style="width:170px; height:auto"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
	<c:if test="${empty SID}">
                        <li class="nav-item"><a class="nav-link" href="" id="loginbtn">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="" id="joinbtn">회원가입</a></li>
	</c:if>
	<c:if test="${not empty SID}">
						<li class="nav-item"><a class="nav-link" href="">${NAME} 님</a></li>
                        <li class="nav-item"><a class="nav-link" href="" id="logoutbtn">로그아웃</a></li>	
                        <li class="nav-item"><a class="nav-link" href="" id="mybtn">마이페이지</a></li>
    </c:if>
                        <li class="nav-item"><a class="nav-link" href="" id="infobtn">축제정보</a></li>
                        <li class="nav-item"><a class="nav-link" href="" id="boardbtn">리뷰게시판</a></li>
                    </ul>
                </div>
            </div>
        </nav>
       		<div class="container" style="margin-top: 100px;">
   		          <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0 e">
						<li class="nav-item w3-third w3-right"><a class="nav-link" href="" id="myinfobtn">내 정보</a></li>
                        <li class="nav-item w3-third w3-right"><a class="nav-link" href="" id="mybookmarkbtn">즐겨찾기 목록</a></li>	
                        <li class="nav-item w3-third w3-right"><a class="nav-link" href="" id="myreviewbtn">내가 쓴 후기</a></li>
                  </ul>
                  </div>
<div class="container">
        <div class="row">
            <form method="post" action="/festival/mypage/MyReviewWriteProc.fes" encType="multipart/form-data">
                <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                    <thead>
                        <tr>
                            <th colspan="2"
                                style="background-color: #eeeeee; text-allign: center;">게시판 글쓰기 양식</th>
 
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="글 제목"
                                id="title" name="title" maxlength="50">${data.review_title}</td>
                        </tr>
                        <tr>
 							<td><div class="w3-col revform-control w3-left-align">리뷰할 축제
 					<select id='selSearchOption' style="width: 70%; margin-legt: 5px;" >
<c:forEach var="data" items="${DATA}">

                        <option value=''>${data.fname}</option>
</c:forEach>
                    </select>
 							</div>
 							</td>
 					 <tr>
 		<td>
	<div class="w3-col m3 revform-control w3-left-align">별점주기
	</div>
	<div class="w3-col m8 star-rating">
		<input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
		<label for="5-stars" class="star pr-4">★</label>
		<input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
		<label for="4-stars" class="star">★</label>
		<input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
		<label for="3-stars" class="star">★</label>
		<input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
		<label for="2-stars" class="star">★</label>
		<input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
		<label for="1-star" class="star">★</label>
</div>
 		</td>
 	 <tr>
 	 	<td>
 	 					<div class="w3-col">
				<label class="w3-col m3 revform-control w3-left-align" style="margin-top: 4px;">파일 올리기</label>
				<div class="w3-col m8" id="filebox">
					<input type="file" class="w3-input upfile">
				</div>
			</div>
 	 	</td>
 		
 							
                        </tr>
                        <tr>
                            <td><textarea class="form-control" placeholder="글 내용"
                                    id="body" name="body" maxlength="2048" style="height: 400px;"></textarea></td>
 
                        </tr>
                    </tbody>
                </table>
                <input type="submit" class="btn btn-primary pull-right" id="lbtn" value="목록">
                <input type="submit" class="btn btn-primary pull-right" id="reset"value="초기화">
                <input type="submit" class="btn btn-primary pull-right" id="submit"value="글등록">
            </form>
        </div>
    </div>

       <!-- Bootstrap core JS-->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <!-- Core theme JS-->
   <script type="text/javascript" src="/festival/resources/js/scripts.js"></script>
   <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
   <!-- * *                               SB Forms JS                               * *-->
   <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
   <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
   <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    
</html>