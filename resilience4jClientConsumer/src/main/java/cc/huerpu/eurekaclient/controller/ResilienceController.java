package cc.huerpu.eurekaclient.controller;

import cc.huerpu.eurekaclient.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResilienceController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserById")
    @CircuitBreaker(name = "hepResilience4j")
    public String getUserById(){
        String res = userService.getUserById();
        return "ResilienceController:" + res;
    }
}
