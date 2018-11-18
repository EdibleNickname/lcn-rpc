package com.can.timer;

import com.can.mq.Demo;
import com.can.mq.Producer.DemoDirectProducer;
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
	private DemoDirectProducer demoProducer;

	@Scheduled(fixedRate = 10000)
	public void sendMsg() {

		Demo demo = new Demo();
		demo.setNum(1314);
		demo.setName("demoName");
		demoProducer.sendDirectMsg(demo);
	}

}
