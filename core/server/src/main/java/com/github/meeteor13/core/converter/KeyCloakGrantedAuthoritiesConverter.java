package com.github.meeteor13.core.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class KeyCloakGrantedAuthoritiesConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final String RESOURCE_ACCESS_CLAIMS = "resource_access";
    private static final String ROLES_KEY = "roles";
    private static final String SCOPE_AUTHORITY_PREFIX = "ROLE_";

    private final String resourceId;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        final List<GrantedAuthority> authorities = Optional
            .ofNullable(jwt.getClaimAsMap(RESOURCE_ACCESS_CLAIMS))
            .map(claim -> (Map<String, List<String>>) claim.get(resourceId))
            .map(resource -> resource.get(ROLES_KEY))
            .stream()
            .flatMap(List::stream)
            .map(authority -> SCOPE_AUTHORITY_PREFIX + authority.toUpperCase())
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
        return new JwtAuthenticationToken(jwt, authorities);
    }
}

