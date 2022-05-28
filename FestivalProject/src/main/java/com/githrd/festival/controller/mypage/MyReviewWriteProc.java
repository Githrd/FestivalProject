package com.githrd.festival.controller.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import com.githrd.festival.controller.*;
import com.githrd.festival.dao.MyPageDao;
import com.githrd.festival.util.*;
import com.githrd.festival.vo.*;


public class MyReviewWriteProc implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/festival/MyPage/MyReview.blp";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/festival/member/login.blp";
		}
		

		
		FileUtil futil = new FileUtil(req, "/resources/upload");
		MultipartRequest multi = futil.getMulti();

		String title = multi.getParameter("title");
		String body = multi.getParameter("body");
		ArrayList<FileVO> list = futil.getList();
		
		MyPageVO bVO = new MyPageVO();
		bVO.setId(sid);
		bVO.setReview_title(title);
		bVO.setReview_body(body);
		bVO.setList(list);
		
		MyPageDao bDao = new MyPageDao();
		int cnt = bDao.insertBoardData(bVO);
		
		if(cnt == -1 || cnt != bVO.getList().size()) {
			view = "/festival/mypage/MyReviewWirte.fes?nowPage=" + multi.getParameter("nowPage");
		} else {
			view = "/festival/mypage/MyReview.fes";
		}
		
		return view;
	}

}