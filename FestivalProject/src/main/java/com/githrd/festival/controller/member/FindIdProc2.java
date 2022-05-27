/**
 * 	이 클래스는 핸드폰번호로 아이디 찾기 기능을 처리하는 클래스이다.
 * @author	이승연
 * @since	2022/05/26
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.26	-	클래스제작
 * 								담당자 : 이승연
 *
 */
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
