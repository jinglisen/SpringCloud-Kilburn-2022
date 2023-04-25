package cc.huerpu.eurekaclient.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

public class FeignAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String uuid = UUID.randomUUID().toString();
        requestTemplate.header("Authorization",uuid);
    }
}

