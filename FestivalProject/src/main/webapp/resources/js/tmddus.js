$(document).ready(function() {
	var idck = false;
	
	$('#lbtn').click(function() {
		var sid = $('#id').val();
		var spw = $('#pw').val();
		if(!sid) {
			$('#id').focus();
			return;
		}
		if(!spw) {
			$('#pw').focus();
			return;
		}
		$('#frm').attr('action', '/festival/member/loginProc.fes');
		$('#frm').submit();
	});
	$('#logoutbtn').click(function() {
		$(location).attr('href', '/festival/member/logoutProc.fes');
	});
	$('#backbtn').click(function() {
		window.history.back();
	});
	$('#jbtn').click(function() {
		var el = $('.lab');
		for(var i=0; i<el.length; i++) {
			if(!(el.eq(i).val())) {
				el.eq(i).focus();
				return;
			}
		}
		if(!($('input:radio[name=gen]').is(':checked'))) {
			alert('성별을 체크해주세요');
			return;
		}
		var namepat = /^{0, 10}$/;
		var idpat = /^[a-zA-Z0-9]{5,20}$/;
		var pwpat = /^[a-zA-Z0-9]{5,20}$/;
		
		var test = $('#birth').val();

		if(!idck) {
			alert('아이디 중복확인을 해주세요');
			return;
		}
		
		// 정규표현식 검사
		$('#frm').attr('action', '/festival/member/joinProc.fes');
		$('#frm').submit();
	});
	
	$('#rwritebtn').click(function() {
		$(location).attr('href', '/festival/review/rboardWrite.fes');
	});
	
	$('#reditbtn').click(function() {
		$(location).attr('href', '/festival/review/rboardEdit.fes');
	});
	
	$('#sbtn').click(function() {
		$(location).attr('href', '/festival/info/finfo.fes');
	});
	
	$('#id').keyup(function() {
		idck = false;
	});
	
	$('#idck').click(function() {
		var sid = $('#id').val();
		
		if(!sid) {
			$('#id').focus();
			return;
		}
		
		$.ajax({
			url: '/festival/member/idCheck.fes',
			type: 'post',
			dataType: 'json',
			data: {
				id: sid
			},
			success: function(data) {
				var result = data.result;
				
				if(result == 'OK') {
					idck = true;
					alert("사용 가능한 아이디입니다.");					
				} else {
					idck = false
					alert("사용 불가능한 아이디입니다.");
				}
			},
			error: function() {
				alert('### 통신 에러 ###');
			}
			
		});
	});
	
	$('#findbtn1').click(function() {
		$('#frm').attr('action', '/festival/member/findidProc.fes');
		$('#tel').prop('disabled', true);
		$('#frm').submit();
	});
		$('#findbtn2').click(function() {
		$('#frm').attr('action', '/festival/member/findidProc2.fes');
		$('#mail').prop('disabled', true);
		$('#frm').submit();
	});
	$('#findbrn3').click(function() {
		$('#frm').attr('action', '/festival/member/findpwProc.fes');
		$('#frm').submit();
	});
});