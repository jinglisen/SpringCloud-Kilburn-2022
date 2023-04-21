package cc.huerpu.eurekaclient;

import cc.huerpu.eurekaclient.loadbalancer.CustomLoadBalancerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@LoadBalancerClients(defaultConfiguration = {CustomLoadBalancerConfiguration.class})
public class EurekaClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumerApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
