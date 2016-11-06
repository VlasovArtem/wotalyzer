package com.vlasovartem.wotalyzer;

import com.vlasovartem.wotalyzer.entity.wn8.AccountWN8;
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
        showData(18876188, 5369);
        showData(28094, 4786);
        showData(5330893, 4170);
        showData(1378749, 3735);
        showData(486353, 3729);
        showData(2418977, 3065);
        showData(231588, 2606);
    }

    private static void showData(int accountId, int currentWN8) {
        AccountWN8 accountWN8 = service.getAccountWN8(accountId);
        System.out.println(accountWN8.getWn8() + " Actual " + currentWN8 + ". Diff: " + (accountWN8.getWn8() - currentWN8) + " " + (((double) currentWN8 / (double) accountWN8.getWn8() / 0.01) - 100) + "%");
    }
}
