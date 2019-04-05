package com.tiagomac.messaging;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {
	
	private JmsTemplate jms;
	private Destination orderQueue;

	@Autowired
	public JmsOrderMessagingService(JmsTemplate jms, Destination orderQueue) {
		this.jms = jms;
		this.orderQueue = orderQueue;
	}	

	@Override
	public void sendOrder(Order order) {
		jms.convertAndSend("tiagomac.order.queue", order);
//		jms.send(
//				orderQueue,
//				session -> session.createObjectMessage(order));
	}
}