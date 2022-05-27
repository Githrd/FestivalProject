package com.githrd.festival.controller.info;

import com.githrd.festival.controller.FesInter;
import com.githrd.festival.dao.FinfoDao;
import com.githrd.festival.util.PageUtil;
import com.githrd.festival.vo.FestivalVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

public class InfoForm implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view ="/info/finfo";
		int nowPage = 1;
		if (req.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}

		FinfoDao fDao = new FinfoDao();
		int resultCnt = fDao.calCount();

		PageUtil pag = new PageUtil(nowPage, resultCnt, 5, 5);
		ArrayList<FestivalVO> list = fDao.schFestInfo(pag);


		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", pag);

		return view;
//
	}

}
