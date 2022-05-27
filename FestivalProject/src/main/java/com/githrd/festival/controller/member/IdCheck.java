/**
 * 	이 클래스는 회원가입시 아이디 중복체크 기능 처리후 결과를 반환해주는 클래스이다.
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
