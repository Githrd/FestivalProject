package com.githrd.festival.controller.api;


import com.githrd.festival.controller.FesInter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  api ajax 통신을 통해 표로 확인하기위해 만들어놓은
 *  리스트 페이지입니다
 * @author 조희덕
 * @since  2022.05.23
 */

public class ApiForm implements FesInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/api/apiList";

        return view;
    }
}
