package com.cl.springcloud.service;

import com.cl.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @Author l
 * @Date 2020/5/13 15:47
 */
@Service
public class PaymentServiceImpl implements  PaymentService{
    @Override
    public Payment getOnePayment() {
        Payment payment= new Payment( Long.parseLong("2"), "abc");
        return payment;
    }
}
