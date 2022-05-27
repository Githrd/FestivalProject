/**
 * 	이 클래스는 회원가입 기능을 처리하고 결과에 따라 뷰를 반환해주는 클래스이다.
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

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;
import com.githrd.festival.dao.*;
import com.githrd.festival.vo.*;

public class JoinProc implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/festival/";
		if(req.getSession().getAttribute("SID") != null) {
			return view;
		}
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String birth = req.getParameter("birth");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		String add = req.getParameter("add");
		String gen = req.getParameter("gen");
		
		MemberVO mVO = new MemberVO();
		mVO.setName(name);
		mVO.setId(id);
		mVO.setPw(pw);
		mVO.setBirth(birth);
		mVO.setTel(tel);
		mVO.setMail(mail);
		mVO.setAdd(add);
		mVO.setGen(gen);
		
		MemberDao mDao = new MemberDao();
		int cnt = mDao.addMember(mVO);
		
		if(cnt != 1) {
			view = "/festival/member/join.fes";
		} else {
			req.getSession().setAttribute("SID", id);
			req.getSession().setAttribute("NAME", name);
		}
		return view;
	}

}
