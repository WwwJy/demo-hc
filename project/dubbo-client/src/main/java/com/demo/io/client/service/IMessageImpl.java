package com.demo.io.client.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.demo.io.api.domain.IMessage;
import com.demo.io.api.service.MessageDataService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
@Component
public class IMessageImpl implements MessageDataService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public Long sendMessage(IMessage m) {
        rabbitTemplate.convertAndSend("amq.direct","test_message", JSON.toJSONString(m));
        return m.getMessageId();
    }

}
