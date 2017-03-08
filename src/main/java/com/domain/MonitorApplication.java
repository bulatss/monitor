package com.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Bulat Saifutdinov on 2/27/2017.
 * This is server-side application read log file and counts info/warning/error.
 */
@SpringBootApplication
@ComponentScan({ "com.domain" })
public class MonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(new Object[] { MonitorApplication.class }, args);
    }
}