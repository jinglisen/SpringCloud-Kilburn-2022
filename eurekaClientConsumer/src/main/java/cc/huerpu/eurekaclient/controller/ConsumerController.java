package cc.huerpu.eurekaclient.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate  restTemplate;
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    //获得eurekaClient的url
    @RequestMapping("/eurekaClientServiceUrl")
    private String eurekaClientServiceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("eurekaClient", false);
        return instance.getHomePageUrl();
    }

    @RequestMapping("/consumerEurekaClient")
    public String consumerEurekaClient(){
        String eurekaClientURL = eurekaClientServiceUrl()+ "getUserById";
        System.out.println(eurekaClientURL);
        String res = restTemplate.getForObject(eurekaClientURL ,String.class);
        return "consumerEurekaClient:" + res;
    }

    @RequestMapping("/eurekaClient-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("eurekaClient");
    }

}
