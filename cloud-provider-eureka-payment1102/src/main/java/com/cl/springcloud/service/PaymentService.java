package com.cl.springcloud.service;

import com.cl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author l
 * @Date 2020/4/13 23:30
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
