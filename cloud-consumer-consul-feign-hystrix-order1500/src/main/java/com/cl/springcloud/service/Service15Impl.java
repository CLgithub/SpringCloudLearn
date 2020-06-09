package com.cl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author l
 * @Date 2020/5/22 15:51
 */
@Component
public class Service15Impl implements Service15{

    @Override
    public String getPort1() {
        return "调用端--被调用端直接异常";
    }

    @Override
    public String getPort2() {
        return "调用端--被调用端响应超时";
    }

    @Override
    public String getPort3(Integer id) {
        return "调用端--Service15Impl_getPort2_异常处理";
    }

    @Override
    public String getPort4() {
        return "调用端--服务降级";
    }


}
