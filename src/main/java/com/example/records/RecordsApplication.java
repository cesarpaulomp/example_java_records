package com.example.records;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.records.adapter")
public class RecordsApplication {

  public static void main(String[] args) {
    SpringApplication.run(RecordsApplication.class, args);
  }
}
