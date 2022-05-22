package com.githrd.festival.controller.info;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;

public class InfoForm implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view ="/info/finfo";
		return view;
	}

}
