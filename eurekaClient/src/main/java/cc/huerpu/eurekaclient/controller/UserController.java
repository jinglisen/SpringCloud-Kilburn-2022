package cc.huerpu.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUserById")
    public String getUserById() throws Exception{
        //Thread.sleep(10000);
        return "{id:1,name:Kelsen,age:23,sex: man}";
    }
}
