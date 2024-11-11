package cc.huerpu.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@SpringBootApplication
@EnableDiscoveryClient
public class HepGatewayEntranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HepGatewayEntranceApplication.class, args);
    }


    /*@Bean(name = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                String hostName = Objects.requireNonNull(exchange.getRequest()
                        .getRemoteAddress()).getHostName();
                System.out.println("hostName:" + hostName);
                return Mono.just(hostName);
            }
        };
    }*/

    /*@Bean(name = "userIdResolver")
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("userId")));
    }*/

    @Bean(name = "apiKeyResolver")
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

}
