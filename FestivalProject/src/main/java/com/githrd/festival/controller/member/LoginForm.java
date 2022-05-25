package com.githrd.festival.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;

public class LoginForm implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/login";
		if(req.getSession().getAttribute("SID") != null) {
			// 이미 로그인 한 상태
			return "/main";
		}
		return view;
	}

}
