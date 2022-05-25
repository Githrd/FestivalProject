$(document).ready(function() {
	// 로그인
	$('#loginbtn').click(function() {
		$('#loginbtn').attr('href', '/festival/member/login.fes');
	});
	// 회원가입
	$('#joinbtn').click(function() {
		$('#joinbtn').attr('href', '/festival/member/join.fes');
	});
	// 축제정보
	$('#infobtn').click(function() {
		$('#infobtn').attr('href', '/festival/info/finfo.fes');
	})
	// 리뷰게시판
	$('#boardbtn').click(function() {
		$('#boardbtn').attr('href', '/festival/review/rboard.fes');
	});
	// 로고클릭
	$('#logo').click(function() {
		$('#logo').attr('href', '/festival/');
	});
	// 내정보 클릭
	$('#myinfobtn').click(function() {
		$('#myinfobtn').attr('href', '/festival/mypage/myinfo.fes');
	})
	//즐겨찾기 목록 클릭
	$('#mybookmarkbtn').click(function() {
		$('#mybookmarkbtn').attr('href', '/festival/mypage/mybookmark.fes');
	})
	//내가 쓴 후기 클릭
	$('#myreviewbtn').click(function() {
		$('#myreviewbtn').attr('href', '/festival/mypage/myreview.fes');
	})
	//////////////////////////마이페이지 버튼///////////////////
	//로그아웃 버튼
	$('#miobtn').click(function(){
		$('#miobtn').attr('href', '/festival/');
	});
	//게시글 클릭		
	$('.brdList').click(function(){
		var sno = $(this).attr('id');
		
		$(document.frm.bno).val(sno);
		
		$('#frm').submit();
	});
	//글작성 버튼 클릭
	$('#wbtn').click(function(){
		$('#wbtn').attr('href', '/festival/mypage/myreviewwrite.fes');
	});
	/////////////리뷰게시판 글쓰기 버튼 기능//////////
	//등록 버튼 클릭
	$('#submit').click(function(){
		$('#pageFrm').attr('action', '/festival/mypage/myreview.fes');
		$('#pageFrm').submit();
	});
	//목록 버튼 클릭
	$('#lbtn').click(function(){
		$('#lbtn').attr('href', '/festival/mypage/myreview.fes');
	});
	//초기화 버튼 클릭
	$('#reset').click(function(){
		document.frm.reset();
	});

});