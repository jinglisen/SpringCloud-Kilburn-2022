package cc.huerpu.eurekaserver.security;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class EurekaConfigFromApollo {
    private static final Logger logger = LoggerFactory.getLogger(EurekaConfigFromApollo.class);
    @ApolloConfig
    private Config config;
    private static final String EUREKA_CLIENT_SERVICE_URL_DEFAULT_ZONE_KEY = "eureka.client.serviceUrl.defaultZone";
    @Autowired
    private org.springframework.cloud.netflix.eureka.EurekaClientConfigBean eurekaClientConfigBean;

    @PostConstruct
    public void init() {
        updateEurekaServiceUrl();
    }

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        ConfigChange change = changeEvent.getChange(EUREKA_CLIENT_SERVICE_URL_DEFAULT_ZONE_KEY);
        if (change!= null) {
            updateEurekaServiceUrl();
        }
    }

    private void updateEurekaServiceUrl() {
        String eurekaServiceUrl = config.getProperty(EUREKA_CLIENT_SERVICE_URL_DEFAULT_ZONE_KEY, "");
        if (!StringUtils.isEmpty(eurekaServiceUrl)) {
            Map<String, String> defaultZoneUrls = new HashMap<>();
            defaultZoneUrls.put("defaultZone", eurekaServiceUrl);
            eurekaClientConfigBean.setServiceUrl(defaultZoneUrls);
            logger.trace("eurekaServiceUrl:" + eurekaServiceUrl);
        } else {
            logger.error("Failed to get the value of 'eureka.client.serviceUrl.defaultZone' from Apollo configuration.");
        }
    }
}