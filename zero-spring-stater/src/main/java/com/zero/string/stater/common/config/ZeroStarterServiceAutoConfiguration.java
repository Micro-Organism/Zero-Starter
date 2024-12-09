package com.zero.string.stater.common.config;

import com.zero.string.stater.common.model.ZeroStarterProperties;
import com.zero.string.stater.service.ZeroStarterService;
import com.zero.string.stater.service.impl.ZeroStarterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ZeroStarterProperties.class)
@ConditionalOnClass(ZeroStarterService.class)
@ConditionalOnProperty(prefix = "zero", value = "enabled", matchIfMissing = true)
public class ZeroStarterServiceAutoConfiguration {

    private final ZeroStarterProperties properties;

    @Autowired
    public ZeroStarterServiceAutoConfiguration(ZeroStarterProperties properties) {
        this.properties = properties;
    }

    // if spring container do not config bean，auto config PersonService
    @Bean
    @ConditionalOnMissingBean(ZeroStarterService.class)
    public ZeroStarterService personService(){
        return new ZeroStarterServiceImpl(properties);
    }

}
