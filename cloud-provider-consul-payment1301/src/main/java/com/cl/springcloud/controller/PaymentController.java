package com.cl.springcloud.controller;

import com.cl.springcloud.entities.Payment;
import com.cl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.concurrent.TimeUnit;

/**
 * @Author l
 * @Date 2020/4/17 22:25
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getport")
    public String getPort() {
//        try {
//            System.out.println("延时。。。");
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return serverPort;
    }

    @GetMapping("/timoutTest/{ms}")
    public String timoutTest(@PathVariable("ms")int ms){
        // 暂停3秒
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "执行完成1";
    }


    @Resource
    PaymentService paymentService;

    @RequestMapping("/getOnePayment")
    public Payment getOnePayment(){
        return paymentService.getOnePayment();
    }


}
