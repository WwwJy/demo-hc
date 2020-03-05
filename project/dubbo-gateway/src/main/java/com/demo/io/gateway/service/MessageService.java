package com.demo.io.gateway.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.io.api.domain.IMessage;
import com.demo.io.api.service.MessageDataService;
import com.demo.io.gateway.utils.UniqueNoUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class MessageService {

    @Reference
    MessageDataService messageDataService;

    public Long sendMessage(){
        UniqueNoUtil snow = UniqueNoUtil.getSingleton();
        IMessage m = new IMessage();
        m.setMessageId(snow.nextId());
        m.setContent("测试内容测试内容测试内容");
        m.setFromUser(UUID.randomUUID().toString());
        m.setToUser(UUID.randomUUID().toString());
        m.setSendTime(new Date());
        m.setRemark("");
        return messageDataService.sendMessage(m);
    }
}
