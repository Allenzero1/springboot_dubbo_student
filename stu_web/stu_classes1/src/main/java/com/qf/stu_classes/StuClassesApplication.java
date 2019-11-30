package com.qf.stu_classes;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
@DubboComponentScan("com.qf.serviceimpl")

public class StuClassesApplication{

    public static void main(String[] args) {
        SpringApplication.run(StuClassesApplication.class, args);
    }

}
