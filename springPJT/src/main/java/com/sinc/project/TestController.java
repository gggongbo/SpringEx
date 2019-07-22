package com.sinc.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.project.test.service.TestServiceImpl;

@Controller
//@RequestMapping("/bbs") /bbs/index.sinc 호출이 가능

public class TestController {
	
	@Resource(name="testS")
	private TestServiceImpl service;
	
	@RequestMapping("/dependency.sinc")
	public String dependency() {
		System.out.println("test dependency");
		System.out.println(service.sayEcho("맛점하시구요~~"));
		return "home"; ///파일의 이름만 명세
	}
	
	
	@RequestMapping("/index.sinc")
	public String main(Model model) {
		System.out.println("test main");
		return "home"; ///파일의 이름만 명세
	}
	
//	@RequestMapping("/test/a.sinc")
//	public void doA() {
//		System.out.println("test main");
//	}
	
//	@RequestMapping("/a.sinc")
//	public String doA() {
//		System.out.println("test main");
//		
//		return "/test/a";
//	}
//	
//	@RequestMapping("/b.sinc")
//	public ModelAndView doB() {
//		System.out.println("test main");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home");
//		mv.addObject("msg", "Hi, model and view");
//		return mv;
//	}
}
