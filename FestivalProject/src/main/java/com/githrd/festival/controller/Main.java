package com.githrd.festival.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.festival.dao.*;
import com.githrd.festival.vo.*;

public class Main implements FesInter {
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view ="/main";
		
		FestivalDao fDao = new FestivalDao();
		ArrayList<FestivalVO> Info = fDao.getFestivalInfo();
		
		ReviewDao rDao = new ReviewDao();
		ArrayList<ReviewVO> Rinfo = rDao.getAvgScore();
				
		ArrayList<ReviewVO> Review1 = rDao.getMainReview(Rinfo.get(0).getFno());
		ArrayList<ReviewVO> Review2 = rDao.getMainReview(Rinfo.get(1).getFno());
		
		req.setAttribute("INFO", Info);
		req.setAttribute("RINFO", Rinfo);
		req.setAttribute("REVIEW1", Review1);
		req.setAttribute("REVIEW2", Review2);
		
		return view;
	}

}
