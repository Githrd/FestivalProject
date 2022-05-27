package com.githrd.festival.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.githrd.festival.controller.FesInter;
import com.githrd.festival.dao.MemberDao;

public class FindPwProc implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/resultpw";
		
		String id = req.getParameter("fid");
		int cnt = 0;
		if(id == "") {
			return "/festival/member/findpw.fes";
		}
		MemberDao mDao = new MemberDao();
		
		cnt = mDao.getIdbyPw(id);
		if(cnt != 1) {
			return "/festival/member/findpw.fes";
		} else {
			req.getSession().setAttribute("FPW", id);
		}
		return view;
	}

}
