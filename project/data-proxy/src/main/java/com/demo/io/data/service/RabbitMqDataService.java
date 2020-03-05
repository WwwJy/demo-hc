package com.demo.io.data.service;

import com.alibaba.fastjson.JSON;
import com.demo.io.data.mapper.TbMessageMapper;
import com.demo.io.data.model.TbMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqDataService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TbMessageMapper tbMessageMapper;

    @RabbitListener(queues = "test_message")
    public void processMessage(String content){
        log.info("content : {}",content);
        insert(content);
    }

    private void insert(String content){
        TbMessage message = JSON.parseObject(content,TbMessage.class);
        tbMessageMapper.insert(message);
    }
}
