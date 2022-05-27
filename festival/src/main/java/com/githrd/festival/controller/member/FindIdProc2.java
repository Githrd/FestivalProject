package com.githrd.festival.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;
import com.githrd.festival.dao.*;

public class FindIdProc2 implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/festival/member/resultid.fes";
		
		String id = null;
		String tel = null;
		
		tel = req.getParameter("tel");	
		if(tel == "") {
			return "/festival/member/findid.fes";
		}
	
		MemberDao mDao = new MemberDao();

		id = mDao.getIdbyTel(tel);
		if(id == null) {
			return "/festival/member/findid.fes";
		} else {
			req.getSession().setAttribute("FID", id);
		}
		return view;
	}

}
