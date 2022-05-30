<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.githrd.festival.bbs.Bbs" %> 
<%@ page import="com.githrd.festival.bbs.BbsDAO" %>
<%@ page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8"); %>


<jsp:useBean id="bbs" class="com.githrd.festival.bbs.Bbs" scope="page" />
<jsp:setProperty name="bbs" property="bbsTitle" />
<jsp:setProperty name="bbs" property="bbsContent" />
<jsp:setProperty name="bbs" property="rating" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
<title>축제를 즐기다</title>
</head>
<body>


	<%
 	String userID = null;
	
 if(session.getAttribute("userID") != null) {
	 userID = (String) session.getAttribute("userID");
 }
 if(userID == null) {
	 PrintWriter script = response.getWriter();
	 script.println("<script>");
	 script.println("alert('로그인을 하세요.')");
	 script.println("location.href = '/festival/test/member/login.fes'");
	 script.println("</script>");
 } else {
	 
	 
		if (bbs.getBbsTitle() == null || bbs.getBbsContent() == null || bbs.getRating() == 0) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력이 안된 사항이 있습니다.')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent(), bbs.getRating());
				if (result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('글쓰기에 실패했습니다.')");
					script.println("history.back()");
					script.println("</script>");
				} else { //성공
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = '/festival/test/review/reviewlist.fes'");
					script.println("</script>");
				}
			}
	 
 }

	%>
	
	
	
	
	
	
</body>
</html>
