package com.sinc.project.user.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sinc.project.user.model.sql.UserDao;
import com.sinc.project.user.model.vo.UserVO;

@Service("userS")
//컨테이너가 서비스 객체를 생성하여 관리할 수 있도록 어노테이션 꼭 지정해줘야함!!! 의존성 주입
//서비스의 이름은 중복되서는 안된다
public class UserServiceImpl implements UserService {
	
	@Resource(name="userD")
	private UserDao dao;
	
	@Override
	public UserVO loginService(UserVO user) {
		System.out.println("user service login");
		return dao.loginRow(user);
	}

}
