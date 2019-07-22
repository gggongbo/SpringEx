package com.sinc.project.user.model.sql;

import com.sinc.project.user.model.vo.UserVO;

///인터페이스에 어노테이션 걸지 말기.. 객체 생성이 안되므로. @어노테이션 <- 객체 생성 의미
public interface UserDao {
	public UserVO loginRow(UserVO user);
}
