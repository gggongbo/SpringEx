package com.sinc.project.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinc.project.test.model.dao.DaoImpl;

@Service("testS") 
//어노테이션으로 의존성을 주입할 수 있음. 아니면 root_context.xml에서 주입 가능
public class TestServiceImpl {
	
	@Autowired
	private DaoImpl dao;
	
//	public TestServiceImpl() {
//		
//	}
//	
//	public TestServiceImpl(DaoImpl dao) {
//		this.dao = dao;
//	}
	
//	public void setDao(DaoImpl dao) {
//		this.dao = dao;
//	} ////setter injection, property injection이라고 부를 수 있다
	
	public String sayEcho(String msg) {
		System.out.println("service sayEcho~~");
		dao.sampleRow();
		return msg;
	}

}
