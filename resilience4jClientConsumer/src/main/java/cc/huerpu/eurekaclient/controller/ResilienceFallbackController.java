package cc.huerpu.eurekaclient.controller;

import cc.huerpu.eurekaclient.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ResilienceFallbackController implements UserService {

    public String getUserById(){
        return "ResilienceFallbackController: call interface error....circuitbreaker open";
    }
}
