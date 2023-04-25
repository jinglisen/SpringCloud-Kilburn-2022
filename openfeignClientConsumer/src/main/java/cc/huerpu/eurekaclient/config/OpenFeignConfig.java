package cc.huerpu.eurekaclient.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class OpenFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        // OpenFeign的日志级别有四种分别为NONE、BASIC、HEADERS、FULL。这里输出日志级别FULL
        return Logger.Level.FULL;
    }
}

