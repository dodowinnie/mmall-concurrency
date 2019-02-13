package com.branodn.mmall.example.mq;

import com.branodn.mmall.example.mq.rabbitmq.RabbitMQClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private RabbitMQClient rabbitMQClient;

    @RequestMapping("/rabbit")
    public String send(String message){
        rabbitMQClient.send(message);
        return "SUCCESS";
    }

}
