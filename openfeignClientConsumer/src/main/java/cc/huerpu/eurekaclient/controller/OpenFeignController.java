package cc.huerpu.eurekaclient.controller;

import cc.huerpu.eurekaclient.service.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OpenFeignController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getUserById")
    public String getUserById(){

        String res = userService.getUserById();
        return "OpenFeignController:" + res;

    }


}
