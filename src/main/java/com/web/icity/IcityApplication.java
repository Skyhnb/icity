package com.web.icity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.web.icity.dao")
@SpringBootApplication
public class IcityApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcityApplication.class, args);
    }

}
