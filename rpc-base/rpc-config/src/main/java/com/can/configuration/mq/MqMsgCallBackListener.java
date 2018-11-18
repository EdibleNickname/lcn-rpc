package com.can.configuration.mq;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * @description: rabbitMq消息发送到exchange进行响应
 * @author: LCN
 * @date: 2018-11-18 12:34
 */

@Slf4j
public class MqMsgCallBackListener implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

	/**
	 * 消息发送到exchange时进行响应
	 * @param correlationData
	 * @param ack
	 * @param cause
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		if (ack) {
			log.info("消息--->{}成功到达Exchange", correlationData.getId());
			return;
		}

		log.warn("消息--->{}送往Exchange失败---->{}", correlationData.getId(), cause);
		return;
	}

	/**
	 * 消息发送到了Exchange, 但是找不到对应的队列
	 * @param message
	 * @param replyCode
	 * @param replyText
	 * @param exchange
	 * @param routingKey
	 */
	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		log.info("消息路由不到对应的队列");

		log.info("消息的主体message ---->{}", JSONObject.toJSONString(message));
		log.info("消息的响应码replyCode---->{}", replyCode);
		log.info("消息的描述replyText---->{}", replyText);
		log.info("消息使用的交换器exchange---->{}", exchange);
		log.info("消息使用的路由键routingKey---->{}", routingKey);
	}

}
