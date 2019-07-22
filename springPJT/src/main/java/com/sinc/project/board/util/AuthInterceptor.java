package com.sinc.project.board.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Interceptor >>>>>>>>>>>>>>>>>>>>>>> auth");
		HttpSession session = request.getSession();
		String path = "/user/loginForm.sinc";
		if (session.getAttribute("loginUser") == null) {
			savePath(request);
			response.sendRedirect(path);
			return false;
		}
		return true; // 컨트롤러로 넘긴다는 의미. 인트로로 이동 시켜줌
	}

	public void savePath(HttpServletRequest request) {
		String uri         = request.getRequestURI(); /// URI만 뒤의 쿼리 스트링 가져올 수 없음
		String queryString = request.getQueryString(); /// get 방식 요청에서의 uri도 가져올 수 있다

		if (queryString == null || queryString.equals("null")) {
			queryString = "";
		} else {
			queryString = "?" + queryString;
		}
		
		request.getSession().setAttribute("savePath", uri + queryString);
		System.out.println("auth >>>>>>>>>>>>>>> savePath " + uri + queryString);
	}

}
