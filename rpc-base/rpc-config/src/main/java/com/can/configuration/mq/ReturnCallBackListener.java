package com.can.configuration.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @description:
 * @author: LCN
 * @date: 2018-11-16 19:01
 */
@Slf4j
public class ReturnCallBackListener implements RabbitTemplate.ReturnCallback {

	@Override
	public void returnedMessage(Message message, int i, String s, String s1, String s2) {
		log.info("returnedMessage在处理中");
	}

}
