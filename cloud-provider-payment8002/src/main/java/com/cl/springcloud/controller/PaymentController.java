package com.cl.springcloud.controller;

import com.cl.springcloud.entities.CommonResult;
import com.cl.springcloud.entities.Payment;
import com.cl.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author l
 * @Date 2020/4/13 23:35
 */
@RestController
public class PaymentController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")     //应该用put更合理
//    @PutMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        logger.info("create接收到数据"+payment);
        if(result > 0){
            return new CommonResult<>(200, "插入数据库成功", result);
        }else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);


        if(payment!=null){
            return new CommonResult<>(200, "查询数据库成功", payment);
        }else {
            return new CommonResult<>(444, "查询数据库失败", null);
        }
    }

    @GetMapping("test")
    public String test(){
        return "test8002";
    }

}
