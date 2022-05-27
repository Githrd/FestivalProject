/**
 * 	이 클래스는 로그인 기능을 처리 후 결과에 따라 뷰를 반환해주는 클래스이다.
 * @author	이승연
 * @since	2022/05/24
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;
import com.githrd.festival.dao.*;

public class LoginProc implements FesInter{

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/festival/";
		if(req.getSession().getAttribute("SID") != null) {
			// 이미 로그인 한 상태
			return view;
		}
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLogin(id, pw);
		
		String name = mDao.getName(id);
		
		if(cnt == 1 && name != null) { //로그인 성공
			req.getSession().setAttribute("SID", id);
			req.getSession().setAttribute("NAME", name);
		} else { //로그인 실패
			view = "/festival/member/login.fes";
		}
		return view;
	}

}
