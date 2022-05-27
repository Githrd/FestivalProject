/**
 * 	이 클래스는 아이디 찾기 페이지를 반환하는 클래스
 * @author	이승연
 * @since	2022/05/26
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.26	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.festival.controller.FesInter;

public class FindIdForm implements FesInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/findid";
		return view;
	}

}
