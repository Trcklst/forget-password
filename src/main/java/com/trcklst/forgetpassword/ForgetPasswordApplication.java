package com.trcklst.forgetpassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ForgetPasswordApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForgetPasswordApplication.class, args);
    }

}
