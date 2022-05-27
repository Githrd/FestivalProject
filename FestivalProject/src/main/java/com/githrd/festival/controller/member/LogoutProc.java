/**
 * 	이 클래스는 로그아웃을 처리해주는 기능이다.
 * @author	이승연
 * @since	2022/05/24
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.festival.controller.FesInter;

public class LogoutProc implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/festival/";
		req.setAttribute("isRedirect", true);
		
		req.getSession().removeAttribute("SID");
		return view;
	}

}
