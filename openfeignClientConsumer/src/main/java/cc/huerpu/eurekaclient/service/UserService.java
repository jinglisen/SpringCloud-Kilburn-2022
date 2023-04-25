package cc.huerpu.eurekaclient.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "EUREKACLIENT") //指定调用哪个微服务
public interface UserService {

    @RequestMapping("/getUserById")
    public String getUserById();



}
