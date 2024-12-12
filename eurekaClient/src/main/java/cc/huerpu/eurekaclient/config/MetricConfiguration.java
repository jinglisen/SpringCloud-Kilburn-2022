package cc.huerpu.eurekaclient.config;

import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfiguration {
    @Bean
    public MeterFilter customMeterFilter() {
        return MeterFilter.denyNameStartsWith("internal_");
    }
}