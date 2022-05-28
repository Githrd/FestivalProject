package com.githrd.festival.controller.mypage;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;
import com.githrd.festival.dao.*;
import com.githrd.festival.vo.*;
/*리뷰 게시글 상세정보 보기 컨트롤러

2022/05/29

코드 작성자 : 김수경

*/
public class MyReviewDetail implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/boardDetail";
		
		String spage = req.getParameter("nowPage");
		String sno = req.getParameter("bno");
		int bno = 0;
		if(sno != null) {
			bno = Integer.parseInt(sno);
		}
		
		MyPageDao bDao = new MyPageDao();
		MyPageVO bVO = bDao.getBoardDetail(bno);
		
		// 클릭수 업데이트...
		
		req.setAttribute("DATA", bVO);
		req.setAttribute("LIST", bVO.getList());
		req.setAttribute("NOWPAGE", spage);
		
		return view;
	}

}