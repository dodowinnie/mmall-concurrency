package com.branodn.mmall.example.mq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQServer {

    @RabbitListener(queues = QueueConstants.TEST)
    private void receive(String message){
        System.out.println("接受消息->: " + message);
    }
}
