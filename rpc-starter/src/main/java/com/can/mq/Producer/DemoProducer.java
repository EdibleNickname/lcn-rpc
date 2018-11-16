package com.can.mq.Producer;

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
public class DemoProducer {

	public static final String EXCHANGE_A = "my-mq-exchange_A";
	public static final String EXCHANGE_B = "my-mq-exchange_B";
	public static final String EXCHANGE_C = "my-mq-exchange_C";

	public static final String QUEUE_A = "QUEUE_A";
	public static final String QUEUE_B = "QUEUE_B";
	public static final String QUEUE_C = "QUEUE_C";

	public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
	public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
	public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

	@Resource
	private RabbitTemplate rabbitTemplate;

	private int i;

	public void sendMsg(String content) {
		i++;
		content += i;
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(EXCHANGE_A, ROUTINGKEY_A, content, correlationId);
	}

}
