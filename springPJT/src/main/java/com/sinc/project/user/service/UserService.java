package com.sinc.project.user.service;

import com.sinc.project.user.model.vo.UserVO;

public interface UserService {

	public UserVO loginService(UserVO user);
	//로그인된 사용자의 정보가 계속 남아야함.
	//모델이 아니라 세션에 객체 담아야함. 그러므로 리턴타입도 지정.
}
