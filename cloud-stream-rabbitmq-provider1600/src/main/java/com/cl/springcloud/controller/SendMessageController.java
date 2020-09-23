package com.cl.springcloud.controller;

import com.cl.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author l
 * @Date 2020/6/16 15:56
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMsg")
    public String sendMessage(){
        return iMessageProvider.send1();
    }
}
