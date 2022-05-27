package com.githrd.festival.dispatch;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.githrd.festival.controller.*;

/**
 * 	이 클래스는 .fes라는 확장자로 요청이 된 경우 
 * 	요청 내용을 분석하고 실행할 클래스를 선택해서 실행(디스패치)시켜줄 서블릿클래스이다.
 * @author	이승연
 * @since	2022/05/11
 * @version	v.1.0
 * @see
 * 			com.githrd.festival.controller.FesInter
 * 			com.githrd.festival.resources.fes.properties
 * 
 * 			작업이력 ]
 * 				2022.05.22	-	클래스제작
 * 								담당자 : 이승연
 *
 */

@WebServlet("*.fes")
public class FesDispatch extends HttpServlet {

	private HashMap<String, FesInter> map; 
	
	public void init(ServletConfig config) throws ServletException {
		Properties prop = new Properties();
		FileInputStream fin = null;
		try {
			String path = this.getClass().getResource("").getPath();
			path = path + "../resources/fes.properties";
			fin = new FileInputStream(path);
			
			prop.load(fin);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch(Exception e) {}
		}
				
		map = new HashMap<String, FesInter>();
		Enumeration en = prop.keys();
		while(en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String classPath = prop.getProperty(key);
			try {
				Class tmp = Class.forName(classPath);
				Object o = tmp.newInstance();
				map.put(key, (FesInter)o);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Boolean bool = false;
		req.setAttribute("isRedirect", bool);
		
		String full = req.getRequestURI();
		
		String domain = req.getContextPath();
 		String real = full.substring(domain.length());

 		FesInter fes = map.get(real);
 		
 		resp.setCharacterEncoding("UTF-8");

 		String view = fes.exec(req, resp);
 		
 		bool = (Boolean) req.getAttribute("isRedirect");
 		
 		if(bool == null) {
 			PrintWriter pw = resp.getWriter();
 			pw.print(view);
 		} else if(bool) {
 			resp.sendRedirect(view);
 		} else {
 			String prefix = "/WEB-INF/views";
 			String surrfix = ".jsp";
 			 			
 			RequestDispatcher rd = req.getRequestDispatcher(prefix + view + surrfix);
 			rd.forward(req, resp);
 		}
 		
	}

}
