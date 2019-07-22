package com.sinc.project.aop.core;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("serviceTarget")
public class SincServiceImpl implements SincService {

	@Override
	public String sayEcho(String msg) throws Exception {
		System.out.println("core sayEcho()");
		if (true) {
			System.out.println("예외" + msg);
			throw new Exception();
			
		}
		return msg;
	}

}
