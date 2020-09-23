package com.cl.springcloud.service.impl;

import com.cl.springcloud.service.IMessageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author l
 * @Date 2020/7/6 18:07
 */
@EnableBinding(Source.class)    //绑定为消息源
public class MessageProvider implements IMessageProvider{
    Logger logger= LoggerFactory.getLogger(this.getClass());


    @Qualifier("nullChannel")
    @Resource
    private MessageChannel messageChannel;

    @Override
    public String send1() {
        String serial = UUID.randomUUID().toString();
        boolean isSend = messageChannel.send(MessageBuilder.withPayload(serial).build());
        logger.info("发送消息："+serial+" "+isSend);
        return serial;
    }
}
