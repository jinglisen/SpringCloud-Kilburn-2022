package cc.huerpu.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerHAApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerHAApplication.class, args);
    }

}
