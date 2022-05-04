package com.zhang.jtbclearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@ComponentScan("com.zhang")
@SpringBootApplication
public class JtbclearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtbclearnApplication.class, args);
        System.out.println("按回车键退出....");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.exit(0);
    }

}
