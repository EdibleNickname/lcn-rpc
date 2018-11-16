package com.can.timer;

import com.can.mq.Producer.DemoProducer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LCN
 * @date: 2018-11-15 10:37
 */

@Component
@EnableScheduling
public class DemoSchecha {

	@Resource
	private DemoProducer demoProducer;

	@Scheduled(fixedRate = 5000)
	public void sendMsg() {
		System.out.println("生产消息开始了......");
		String content = "消息客户端";
		demoProducer.sendMsg(content);
	}

}
