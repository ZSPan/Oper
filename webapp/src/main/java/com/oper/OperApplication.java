package com.oper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yemingfeng
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = OperApplication.class)
public class OperApplication {

  public static void main(String[] args) {
    SpringApplication.run(OperApplication.class, args);
  }

}