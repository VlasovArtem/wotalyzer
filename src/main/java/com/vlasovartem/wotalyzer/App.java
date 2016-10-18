package com.vlasovartem.wotalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    }
}
