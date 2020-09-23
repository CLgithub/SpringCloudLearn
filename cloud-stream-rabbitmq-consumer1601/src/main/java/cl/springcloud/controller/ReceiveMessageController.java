package cl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author l
 * @Date 2020/6/22 15:11
 */
@RestController
@EnableBinding(Sink.class) //绑定为消息消费者
public class ReceiveMessageController {


//    @Value("${server.port}")
//    private String serverPort;

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void resceiveMsg(Message<String> message){
        String string=serverPort+"----"+message.getPayload();
        System.out.println("a:"+string);
    }


}
