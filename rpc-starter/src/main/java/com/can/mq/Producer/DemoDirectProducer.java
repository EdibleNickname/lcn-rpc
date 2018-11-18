package com.can.mq.Producer;

import com.can.configuration.mq.Mode.RabbitMsgMode;
import com.can.mq.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @description:
 * @author: LCN
 * @date: 2018-11-16 14:54
 */

@Slf4j
@Component
public class DemoDirectProducer {

	@Resource
	private RabbitTemplate rabbitTemplate;


	public void sendDirectMsg(Demo demo) {
		// 标识id
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

		rabbitTemplate.convertAndSend(RabbitMsgMode.Exchange.DIRECT_EXCHANGE,
				RabbitMsgMode.RoutingKey.DIRECT_ROUTINGKEY, demo, correlationId);
	}

}
