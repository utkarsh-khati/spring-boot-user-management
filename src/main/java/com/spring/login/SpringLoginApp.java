package com.spring.login;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.login")
public class SpringLoginApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringLoginApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
