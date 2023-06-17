package ru.max.processing.processingservice.config;

import org.springframework.context.annotation.Bean;



//@Configuration
//@EnableResourceServer
public class ResourceServerConfiguration {

  /*  @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("processing");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().disable()
                .requestMatchers().antMatchers("/**").and().authorizeRequests()
                .anyRequest().access("#oauth2.hasScope('web')");
    }*/
}
