/**
 * 	이 클래스는 비밀번호 찾기 기능을 처리하여 반환하는 클래스이다.
 * @author	이승연
 * @since	2022/05/26
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.26	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.githrd.festival.controller.FesInter;
import com.githrd.festival.dao.MemberDao;

public class FindPwProc implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/festival/member/resultpw.fes";
		
		String id = req.getParameter("fid");
		int cnt = 0;
		if(id == "") {
			return "/festival/member/findpw.fes";
		}
		MemberDao mDao = new MemberDao();
		System.out.println("id = " + id);
		cnt = mDao.getIdbyPw(id);
		System.out.println("cnt = " + cnt);
		if(cnt != 1) {
			return "/festival/member/findpw.fes";
		} else {
			req.getSession().setAttribute("FID", id);
		}
		return view;
	}

}
