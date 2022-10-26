package com.currentbp.test.spring.singleton;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.currentbp.test.spring.singleton"})
public class MySingletonMain {
    public static void main(String[] args) {
        SpringApplication.run(MySingletonMain.class, args);
    }
}
