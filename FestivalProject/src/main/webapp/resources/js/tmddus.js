$(document).ready(function() {
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
});