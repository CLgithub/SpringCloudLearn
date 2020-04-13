package com.cl.springcloud.entities;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

/**
 *
 *
 create table payment(
 id BIGINT(20) NOT null auto_increment comment 'ID',
 serial varchar(200) default '',
 primary key (id)
 ) engine=InnoDB auto_increment=1 default charset=utf8

 * @Author l
 * @Date 2020/4/13 23:04
 */
@Data
@AllArgsConstructor // 自动提供全参构造方法
@NoArgsConstructor
public class Payment implements Serializable{
    private Long id;
    private String serial;
}
