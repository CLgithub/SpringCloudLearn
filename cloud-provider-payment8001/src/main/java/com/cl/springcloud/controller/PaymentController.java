package com.cl.springcloud.controller;

import com.cl.springcloud.entities.CommonResult;
import com.cl.springcloud.entities.Payment;
import com.cl.springcloud.service.PaymentService;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author l
 * @Date 2020/4/13 23:35
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PutMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        Log.info("插入结果:"+result);

        if(result > 0){
            return new CommonResult(200, "插入数据库成功", result);
        }else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);

        Log.info("查询到的结果:"+payment);

        if(payment!=null){
            return new CommonResult(200, "查询数据库成功", payment);
        }else {
            return new CommonResult(444, "查询数据库失败", null);
        }
    }

}
