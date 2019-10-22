package com.github.meeteor13.security.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(ExtendedOAuth2ResourceServerProperties.class)
@Import(ReactiveSecurityConfiguration.class)
public class ReactiveSecurityAutoConfiguration {

}
