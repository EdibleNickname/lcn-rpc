package com.can.configuration.mq;

import com.can.configuration.mq.Mode.RabbitMsgMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @description: rabbitMq配置
 * @author: LCN
 * @date: 2018-11-16 14:18
 */

@Slf4j
@Configuration
public class RabbitMqConfig {

	@Resource
	private ConnectionFactory connectionFactory;

	@Bean
	public RabbitTemplate rabbitTemplate() {

		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		MqMsgCallBackListener listener = new MqMsgCallBackListener();

		// 消息发布确认，只有消息达到了Exchange，会进行确认响应
		template.setConfirmCallback(listener);

		template.setMandatory(true);
		template.setReturnCallback(listener);
		return template;
	}

	/**
	 * Direct 模式
	 * @return
	 */
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(RabbitMsgMode.Exchange.DIRECT_EXCHANGE);
	}

	@Bean
	public Queue directQueue() {
		//队列持久
		return new Queue(RabbitMsgMode.Queue.DIRECT_QUEUE, true);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(directQueue()).to(directExchange()).with(RabbitMsgMode.RoutingKey.DIRECT_ROUTINGKEY);
	}

}
