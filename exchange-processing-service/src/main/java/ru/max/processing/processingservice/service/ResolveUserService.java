package ru.max.processing.processingservice.service;

/*import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;*/

//@Service
public class ResolveUserService {
/*
    private final UserInfoRestTemplateFactory userInfoRestTemplateFactory;

    private final ResourceServerProperties resource;

    public ResolveUserService(UserInfoRestTemplateFactory userInfoRestTemplateFactory, ResourceServerProperties resource) {
        this.userInfoRestTemplateFactory = userInfoRestTemplateFactory;
        this.resource = resource;
    }

    public Long resolveUserId() {
        OAuth2RestTemplate userInfoRestTemplate = userInfoRestTemplateFactory.getUserInfoRestTemplate();
        Map<String, Object> response = userInfoRestTemplate.getForEntity(resource.getUserInfoUri(), Map.class).getBody();
        return Optional.ofNullable(response)
                .map(r -> r.get("principal"))
                .map(Map.class::cast)
                .map(v -> v.get("userId"))
                .map(Integer.class::cast)
                .map(Long::valueOf)
                .orElse(null);
    }*/
}
