package com.sinc.project.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sinc.project.user.model.vo.UserVO;
import com.sinc.project.user.service.UserService;

@Controller
@RequestMapping("/user")
//@SessionAttributes({"loginUser"})
////메소드 안 모델의 scope가 session으로 변경
public class UserCtrl {
	
	@Resource(name="userS")
	private UserService service;
	
	@RequestMapping("/loginForm.sinc")
	//user/loginForm있었다면 void 사용 가능
	public String loginForm() {
		return "/user/login";
	}
	
	@RequestMapping(value="/login.sinc", method = RequestMethod.POST)
	public void login(UserVO user, Model model) {
		////매개변수의 유연성 -> 매개변수에 넣으면 세션 객체 하나를 관리할 수 있게됨
		System.out.println("user ctrl login");
		UserVO result = service.loginService(user);
		
		if(result != null) {
			System.out.println("model 생성");
			model.addAttribute("user", result);
		} else {
			
		}
		//return"redirect:/index.sinc" ; id, pwd를 받아서 바로 홈페이지로 보내줌
	}
	//웹에서 세션을 관리하는 기법
	@RequestMapping("/logout.sinc")
	public String logout(HttpSession session) {
		System.out.println("user ctrl logout");
		session.invalidate();
		return "redirect:/index.sinc";
	}
	
//프레임워크 기반에서 세션을 관리하는 기법
//	@RequestMapping("/logout.sinc")
//	public String logout(SessionStatus status) {
//		System.out.println("user ctrl logout");
//		status.setComplete();
//		return "redirect:/index.sinc";
//	}
//////////////////////////////////////////////////////////	
//	@RequestMapping(value="/login.sinc", method = RequestMethod.POST)
//	public String login(UserVO user, HttpSession session) {
//		////매개변수의 유연성 -> 매개변수에 넣으면 세션 객체 하나를 관리할 수 있게됨
//		System.out.println("user ctrl login");
//		UserVO result = service.loginService(user);
//		
//		if(result != null) {
//			return "redirect:/index.sinc";
//		} else {
//			
//		}
//		
//		return null;
//		//return"redirect:/index.sinc" ; id, pwd를 받아서 바로 홈페이지로 보내줌
//	}
	
//	@RequestMapping(value="/login.sinc", method = RequestMethod.POST)
//	public String login(@RequestParam(name="id", required=true) String id,
//						@RequestParam(name="pwd", required=true) String pwd) {
//		map.put("id", id); map.put("pwd", pwd);
//		service.xxx(map);
//		return "redirect:/index.sinc";
//	}
	
}
