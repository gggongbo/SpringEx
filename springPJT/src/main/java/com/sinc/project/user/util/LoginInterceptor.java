package com.sinc.project.user.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	// User Controller에서 유저 로그인 작업이 다 끝나고 인터셉터 작동해야한다.
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		
		System.out.println("interceptor >>>>>>>>>>>>>>>> post");
		////로그인 후 세션 작업 할 시 필요하다. 컨트롤러에서 모델에 심은 데이터 model and view로 가져올 수 있음
		HttpSession session = request.getSession();
		ModelMap model = modelAndView.getModelMap();
		////유저에서 심은 모델이 인터셉터를 통해 전달이 된다.
		Object obj = model.get("user");
		/////////////////////////////////////
		String dest = checkDestination(request);
		String path = (dest != null) ? dest : "/";
		//////////////////Controller는 응답해서는 안됨
		
		if(obj != null) {
			System.out.println("Interceptor >>>> Success");
			session.setAttribute("loginUser", obj);
			response.sendRedirect(path);
		} else {
			response.sendRedirect("/user/loginForm.sinc");
		}
	}
	
	public String checkDestination(HttpServletRequest request) {
		///사용자가 가려고 하는 url 저장 위해서
		///화면 분기를 위한 작업
		System.out.println("interceptor >>>>>>>>>>>> save path");
		///////로그인 하기 전 페이지 AuthInterceptor에서 세션에 심을 수 있음
		HttpSession session = request.getSession();
		String savePath = (String)session.getAttribute("savePath");
		session.removeAttribute("savePath"); 
		///invalidate() -> 전체 세션 지움, remove는 특정 하나만 지움. 심어 놓은 경로 패스만 삭제
		System.out.println("login >>>>>>>>>>>>>> get Path : " + savePath);
		return savePath;
	}
}
