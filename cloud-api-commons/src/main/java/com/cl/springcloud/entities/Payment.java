package com.cl.springcloud.entities;

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
public class Payment implements Serializable{
    private Long id;
    private String serial;

    public Payment() {
    }

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
