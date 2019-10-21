package com.github.meeteor13.core.configuration;

import com.github.meeteor13.core.converter.KeyCloakGrantedAuthoritiesConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@ConditionalOnProperty("spring.security.oauth2.resourceserver.resource-id")
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

    @Value("${spring.security.oauth2.resourceserver.resource-id}")
    private String resourceId;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .csrf().disable()
            .httpBasic().disable()
            .formLogin().disable();

        http.authorizeExchange()
            .matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .pathMatchers("/actuator/**").permitAll()
            .anyExchange().authenticated();

        http.oauth2ResourceServer()
            .jwt()
            .jwtAuthenticationConverter(keyCloakGrantedAuthoritiesConverter());

        return http.build();
    }

    @Bean
    public Converter<Jwt, Mono<AbstractAuthenticationToken>> keyCloakGrantedAuthoritiesConverter() {
        return new ReactiveJwtAuthenticationConverterAdapter(new KeyCloakGrantedAuthoritiesConverter(resourceId));
    }
}
