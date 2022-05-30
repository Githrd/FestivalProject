<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<%--
			회원정보 보기 뷰
					
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
       <script type="text/javascript" src="/festival/resources/js/jquery-3.6.0.min.js"></script>
       <script type="text/javascript" src="/festival/resources/js/mypage.js"></script>
       <script type="text/javascript" src="/festival/resources/js/myinfo.js"></script>
       <style type="text/css">   
     	.logo {
     		margin: 0px;
     		padding: 0px;
     	}
	.avtimg {
		width: 100px;
		height: 100px;
	}
     	</style>
	
</head>
<body>
    <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand logo" href="#page-top"><img src="/festival/resources/img/logo.png" style="width:170px; height:auto"></a>
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
       		<div class="container" style="margin-top: 100px">
   		          <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0 e">
						<li class="nav-item w3-third w3-right"><a class="nav-link" href="" id="myinfobtn">내 정보</a></li>
                        <li class="nav-item w3-third w3-right"><a class="nav-link" href="" id="mybookmarkbtn">즐겨찾기 목록</a></li>	
                        <li class="nav-item w3-third w3-right"><a class="nav-link" href="" id="myreviewbtn">내가 쓴 후기</a></li>
                  </ul>
                  </div>
                  
 <div class="container">
                  
	<div class="row login_box" style="margin-top: 150px; margin-bottom: 500px;">
	    <div class="col-md-12 col-xs-12" align="center">
			<h5>환영합니다</h5>
            <div class="outter"><img src="/festival/resources/img/img_avatar4.png<%-- ${DATA.username} --%>" class="image-circle avtimg"/></div>   
				<h4><span class="">아이디 : </span><span class="w3-rest w3-center" id="name">${DATA.id}</span></h4>
	    </div>
        <div class="col-md-6 col-xs-6 follow line" align="center">
<h4><span class="">작성한 리뷰 수</span>
	<br>
	<span class="" id="mno"><%-- ${DATA.revcount}--%>데이터</span></h4>
        </div>
        <div class="col-md-6 col-xs-6 follow line" align="center">
<h4><span class="">즐겨찾기 수</span>
	<br>
	<span class="" id="mno"><%-- ${DATA.bmcount}--%>데이터</span></h4>
        </div>
        
        <div class="col-md-12 col-xs-12 login_control">
                

                <div class="control">
                     <div class="label">이름</div>
                    <input type="text" class="form-control" value="${DATA.name}"/>
                </div>
                <div class="control">
                     <div class="label">생년월일</div>
                    <input type="text" class="form-control" value="${DATA.birth}"/>
                </div>
                <div class="control">
                     <div class="label">가입일</div>
                    <input type="text" class="form-control" value="${DATA.jdate}"/>
                </div>
                                <div class="control">
                    <div class="label">이메일</div>
                    <input type="text" class="form-control" value="${DATA.mail}"/>
                </div>
                                <div class="control">
                    <div class="label">주소</div>
                    <input type="text" class="form-control" value="${DATA.add}"/>
                </div>
                                <div class="control">
                    <div class="label">폰번호</div>
                    <input type="text" class="form-control" value="${DATA.tel}"/>
                </div>
			<div class="container">
			<div class="btn" id="miobtn">로그아웃</div>
			<div class="btn" id="miebtn">내정보 수정</div>
			</div>
                
        </div>
        
        
            
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