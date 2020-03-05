package com.demo.io.api.service;

import com.demo.io.api.domain.IMessage;

public interface MessageDataService {

    Long sendMessage(IMessage m);
}
