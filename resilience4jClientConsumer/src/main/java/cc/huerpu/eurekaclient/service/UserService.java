package cc.huerpu.eurekaclient.service;


import cc.huerpu.eurekaclient.controller.ResilienceFallbackController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "EUREKACLIENT",fallback = ResilienceFallbackController.class) //指定调用哪个微服务
public interface UserService {

    @RequestMapping("/getUserById")
    public String getUserById();



}
