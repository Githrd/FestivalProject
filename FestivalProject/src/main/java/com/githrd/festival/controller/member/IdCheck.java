package com.githrd.festival.controller.member;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.FesInter;
import com.githrd.festival.dao.*;

public class IdCheck implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		
		String id = req.getParameter("id");
		MemberDao mDao = new MemberDao();
		
		int cnt = mDao.idCheck(id);
		
		buff.append("{");
		buff.append("\"result\" : \"");
		if (cnt == 0) {
			buff.append("OK");
		} else {
			buff.append("NO");
		}
		buff.append("\"");
		buff.append("}");
		
		return buff.toString();
	}

}
