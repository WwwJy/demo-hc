package com.demo.io.client.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.demo.io.api.domain.IMessage;
import com.demo.io.api.service.MessageDataService;
import com.demo.io.client.mapper.TbMessageMapper;
import com.demo.io.client.model.TbMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@Component
public class IMessageImpl implements MessageDataService {

    @Autowired
    TbMessageMapper tbMessageMapper;

    private ExecutorService executorService = new ThreadPoolExecutor(5, 10,
            30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1024), // 使用有界队列，避免OOM
            new ThreadPoolExecutor.DiscardPolicy());

    @Override
    public Long sendMessage(IMessage m) {
        executorService.submit(new Thread(() -> {
            TbMessage msg = JSON.parseObject(JSON.toJSONString(m),TbMessage.class);
            tbMessageMapper.insert(msg);
        }));
        return m.getMessageId();
    }

}
