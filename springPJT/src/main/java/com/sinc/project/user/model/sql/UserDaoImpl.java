package com.sinc.project.user.model.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.sinc.project.user.model.vo.UserVO;

@Repository("userD")
public class UserDaoImpl implements UserDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public UserVO loginRow(UserVO user) {
		System.out.println("user dao login");
		return sqlSession.selectOne("com.sinc.user.login", user);
		//// 네임스페이스.태그의 식별자, 전달하는 파라미터
	}

}
