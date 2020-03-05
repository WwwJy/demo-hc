package com.demo.io.gateway.controller;

import com.demo.io.gateway.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Long getUserAddress() {
        return messageService.sendMessage();
    }
}
