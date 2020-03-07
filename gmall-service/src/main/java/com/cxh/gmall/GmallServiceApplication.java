package com.cxh.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.cxh.gmall.gmallservice.mapper")
public class GmallServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallServiceApplication.class, args);
    }

}
