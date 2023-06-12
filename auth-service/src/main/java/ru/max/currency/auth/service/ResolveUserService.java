package ru.max.currency.auth.service;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

import java.util.Map;
import java.util.Optional;

public class ResolveUserService {

    private final UserInfoRestTemplateFactory restTemplateFactory;

    private final ResourceServerProperties resource;

    public ResolveUserService(UserInfoRestTemplateFactory restTemplateFactory, ResourceServerProperties resource) {
        this.restTemplateFactory = restTemplateFactory;
        this.resource = resource;
    }
    public Long resolveUserId() {
        OAuth2RestTemplate userInfoRestTemplate = restTemplateFactory.getUserInfoRestTemplate();
        Map<String, String> responce = userInfoRestTemplate.getForEntity(resource.getUserInfoUri(), Map.class).getBody();
        return Optional.ofNullable(responce)
                .map(r -> r.get("principal"))
                .map(Map.class::cast)
                .map(v -> (Integer) v.get("userId"))
                .map(Long::valueOf)
                .orElse(null);
    }
}
