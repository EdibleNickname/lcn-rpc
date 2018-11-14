package com.can.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.can.provider.DemoProvider;

/**
 * @description:
 * @author: LCN
 * @date: 2018-11-14 14:22
 */

@Service
public class DemoProviderImpl implements DemoProvider {

	@Override
	public String sayHello() {
		System.out.println("请求中....");
		return "请求成功";
	}
}
