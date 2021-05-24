package ru.karinkicks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EurekaFeignClient {
    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClient.class, args);
    }

}
