package com.github.meeteor13.security.configuration;

import com.github.meeteor13.security.converter.KeyCloakGrantedAuthoritiesConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
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
@ConditionalOnBean({
    ExtendedOAuth2ResourceServerProperties.class,
    OAuth2ResourceServerProperties.class
})
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@RequiredArgsConstructor
class ReactiveSecurityConfiguration {

    private final ExtendedOAuth2ResourceServerProperties properties;

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
        return new ReactiveJwtAuthenticationConverterAdapter(new KeyCloakGrantedAuthoritiesConverter(properties.getResourceId()));
    }
}
