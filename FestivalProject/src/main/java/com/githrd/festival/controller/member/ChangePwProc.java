/**
 * 	이 클래스는 회원가입 기능을 처리하고 결과에 따라 뷰를 반환해주는 클래스이다.
 * @author	이승연
 * @since	2022/05/27
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.27	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;
import com.githrd.festival.dao.*;

public class ChangePwProc implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/festival/member/login.fes";
		
		String id = (String) req.getSession().getAttribute("FID");
		String pw = req.getParameter("fpw");
		MemberDao mDao = new MemberDao();
		int cnt = mDao.changePw(id, pw);
		
		System.out.println("fid = " + id);
		System.out.println("cnt = " + cnt);
		if (cnt == 1) {
			System.out.println("비밀번호 변경 성공");
		} else {
			System.out.println("비밀번호 변경 실패");
			return "/festival/member/resultpw.fes";
		}		
		return view;
	}

}
