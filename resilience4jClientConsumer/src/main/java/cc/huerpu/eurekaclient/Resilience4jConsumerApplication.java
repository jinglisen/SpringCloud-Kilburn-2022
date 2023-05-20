package cc.huerpu.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Resilience4jConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Resilience4jConsumerApplication.class, args);
    }

}
