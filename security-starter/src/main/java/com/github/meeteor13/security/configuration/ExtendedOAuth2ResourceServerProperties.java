package com.github.meeteor13.security.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.security.oauth2.resourceserver")
@Data
public class ExtendedOAuth2ResourceServerProperties {
    private String resourceId;
}
