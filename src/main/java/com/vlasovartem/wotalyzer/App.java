package com.vlasovartem.wotalyzer;

import com.vlasovartem.wotalyzer.service.wn8.AccountWN8Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {

    static AccountWN8Service service;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        service = context.getBean(AccountWN8Service.class);
    }

}
