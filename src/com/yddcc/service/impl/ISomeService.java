package com.yddcc.service.impl;

import com.yddcc.service.BaseService;

public class ISomeService implements BaseService {

	public String doSome() {
		return "Hello mike";//增强效果，doSome方法返回值都是大写
	}

	@Override
	public String doAny() {
		return "hello yddcc";
	}
}
