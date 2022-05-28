package com.githrd.festival.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.festival.controller.FesInter;
import com.githrd.festival.dao.MemberDao;
import com.githrd.festival.vo.MemberVO;
/*회원정보 폼보기 컨트롤러

2022/05/29

코드 작성자 : 김수경

*/
public class MyInfo implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/mypage/myinfo";
		String sid = (String) req.getSession().getAttribute("SID");
		
		// 데이터 조회하고
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getMnoInfo(sid);
		
//		System.out.println(mVO);
		
		// 데이터 심고
		req.setAttribute("DATA", mVO);
		
		return view;
	}

}
