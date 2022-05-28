/*
		마이페이지 기능 js (회원정보, 즐겨찾기 목록, 리뷰게시판)
		
								2022/05/29
								
							코드 작성자 : 김수경
*/


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
	});
	// 리뷰게시판
	$('#boardbtn').click(function() {
		$('#boardbtn').attr('href', '/festival/review/rboard.fes');
	});
	// 로고클릭
	$('#logo').click(function() {
		$('#logo').attr('href', '/festival/');
	});
	
	$('#wviewbtn').click(function(){
		$(location).attr('href', '/festival/mypage/myreviewwrite.fes');
	});
	
	// 내정보 클릭
	$('#myinfobtn').click(function() {
		$('#myinfobtn').attr('href', '/festival/mypage/myinfo.fes');
	});
	//즐겨찾기 목록 클릭
	$('#mybookmarkbtn').click(function() {
		$('#mybookmarkbtn').attr('href', '/festival/mypage/mybookmark.fes');
	});
	//내가 쓴 후기 클릭
	$('#myreviewbtn').click(function() {
		$('#myreviewbtn').attr('href', '/festival/mypage/myreview.fes');
	});
	
	
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

	/////////////리뷰게시판 글쓰기 버튼 기능//////////
	//등록 버튼 클릭
	$('#submit').click(function(){
		var title = $('#title').val();
		if(!title) {
			$('#title').focus();
			return;
		}
		var body = $('#body').val();
		if(!body){
			$('#body').focus();
			return;
		}
		
		var el = $('input[type="file"]');
		
		for(i = 0 ; i < $(el).length ; i++ ){
			var tmp = $(el).eq(i).val();
			if(!tmp){
				$(el).eq(i).prop('disabled', true);
			}
		}
		
		$('.upfile').last().prop('disabled', true);
		
		$('#frm').submit();
	});
	
	//목록 버튼 클릭
	$('#lbtn').click(function(){
		$('#lbtn').attr('href', '/festival/mypage/myreview.fes');
	});
	//초기화 버튼 클릭
	$('#reset').click(function(){
		document.frm.reset();
	});
	
	/////////////게시글 클릭 시 상세페이지//////////
	$('.brdList').click(function(){
		var sno = $(this).attr('id');
		
		$(document.frm.bno).val(sno);
		
		$('#frm').submit();
	});
	// 파일박스//
	$('#filebox').on('change', '.upfile', function(e){
		var txt = $(this).val();
		var len = $('.upfile').length;
		if(!txt && len > 1){
			$('#img' + $(this).attr('id').substring(4)).remove();
			$(this).remove();
			if($('.pic').length == 0){
				$('#previewbox').slideUp(100);
			}
		} else {
			$('#filebox').append('<input type="file" class="w3-input w3-border w3-margin-bottom upfile">');
			
			$('#previewbox').stop().slideUp(300, function(){
				
				var box = document.createElement('div');
				$(box).attr('class', 'inblock picbox');
				var img = document.createElement('img');
				$(img).attr('class', 'pic');
				var path = URL.createObjectURL(e.target.files[0]);
				$(img).attr('src', path);
				$(box).append($(img));
				$('#preview').append($(box));
				
				var cnt = $('.picbox').length;
				for(i = 1; i <= cnt ; i++ ){
					$('.picbox').eq(i-1).attr('id', 'img' + i);
				}
				$('#previewbox').stop().slideDown(300);
			});
		}
		len = $('.upfile').length;
		for(i = 1; i < len ; i++ ){
			$('.upfile').eq(i-1).attr('id', 'file' + i);
			$('.upfile').eq(i-1).attr('name', 'file' + i);
		}
	});
	
});
