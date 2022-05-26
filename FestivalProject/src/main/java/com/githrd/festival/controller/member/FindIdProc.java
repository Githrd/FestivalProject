package com.githrd.festival.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;
import com.githrd.festival.dao.*;

public class FindIdProc implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/festival/member/resultid.fes";
		
		String id = null;
		String mail = null;
				
		mail = req.getParameter("mail");
		if(mail == "") {
			return "/festival/member/findid.fes";
		}
		MemberDao mDao = new MemberDao();

		id = mDao.getIdbyMail(mail);
		if(id == null) {
			return "/festival/member/findid.fes";
		} else {
			System.out.println("id = " + id);
			req.getSession().setAttribute("FID", id);
		}
		
		return view;
	}

}
