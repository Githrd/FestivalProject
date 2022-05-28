package com.githrd.festival.controller.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.festival.controller.FesInter;
import com.githrd.festival.dao.MyPageDao;
import com.githrd.festival.vo.MyPageVO;
import com.githrd.festival.vo.MemberVO;

public class GetReviewList implements FesInter {
	/*리뷰 게시글 리뷰리스트 가져오기 컨트롤러

	2022/05/29

	코드 작성자 : 김수경

	*/
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/mypage/myreviewwrite";
		/*String sid = (String) req.getSession().getAttribute("SID");
		
		if(sid == null) {
			return "/festival/member/login.fes";
		}*/
		MyPageDao mpDao = new MyPageDao();
		ArrayList<MyPageVO> mVO = mpDao.getReviewList();
		
		System.out.println(mVO);
		
		req.setAttribute("DATA", mVO);
		
		return view;
	}

}
