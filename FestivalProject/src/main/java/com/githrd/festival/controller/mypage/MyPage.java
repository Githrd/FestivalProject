package com.githrd.festival.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.festival.controller.FesInter;
/*마이페이지 폼보기 컨트롤러

2022/05/29

코드 작성자 : 김수경

*/
public class MyPage implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/mypage/mypage";
		return view;
	}

}
