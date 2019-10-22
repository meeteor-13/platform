package com.github.meeteor13.security.converter;

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
import java.util.stream.Stream;

@RequiredArgsConstructor
public class KeyCloakGrantedAuthoritiesConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final String RESOURCE_ACCESS_CLAIMS = "resource_access";
    private static final String ROLES_KEY = "roles";
    private static final String SCOPE_AUTHORITY_PREFIX = "ROLE_";

    private final String resourceId;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        final List<GrantedAuthority> authorities = extractRoles(jwt)
            .map(role -> SCOPE_AUTHORITY_PREFIX + role.toUpperCase())
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
        return new JwtAuthenticationToken(jwt, authorities);
    }

    private Stream<String> extractRoles(Jwt jwt) {
        return Optional
            .ofNullable(jwt.getClaimAsMap(RESOURCE_ACCESS_CLAIMS))
            .map(claim -> claim.get(resourceId))
            .filter(Map.class::isInstance)
            .map(Map.class::cast)
            .map(resource -> resource.get(ROLES_KEY))
            .filter(List.class::isInstance)
            .map(List.class::cast)
            .stream()
            .flatMap(List::stream);
    }
}

