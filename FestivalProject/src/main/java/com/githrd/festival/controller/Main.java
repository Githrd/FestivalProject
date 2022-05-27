/**
 * 	이 클래스는 메인화면 페이지를 반환해주는 클래스이다.
 * @author	이승연
 * @since	2022/05/26
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.22	-	클래스제작
 * 								담당자 : 이승연
 * 
 * 				2022.05.25 	-	축제 정보, 축제 후기 DB 처리 후 출력
 * 								담당자 : 이승연
 * 
 * 				2022.05.26	-	후기가 없을 경우(예외 처리)
 * 								담당자 : 이승연
 *
 */
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
		req.setAttribute("INFO", Info);
		
		ReviewDao rDao = new ReviewDao();
		ArrayList<ReviewVO> Rinfo = rDao.getAvgScore();
		System.out.println(Rinfo);

		if(Rinfo.isEmpty() == true) {
			return view;
		}
		ArrayList<ReviewVO> Review1 = rDao.getMainReview(Rinfo.get(0).getFno());
		ArrayList<ReviewVO> Review2 = rDao.getMainReview(Rinfo.get(1).getFno());
		
		req.setAttribute("RINFO", Rinfo);
		req.setAttribute("REVIEW1", Review1);
		req.setAttribute("REVIEW2", Review2);
		
		return view;
	}

}
