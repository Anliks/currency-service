package ru.max.rate.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import ru.max.rate.currency.config.CurrencyClientCfg;

@SpringBootApplication
@EnableEurekaServer
@EnableConfigurationProperties(CurrencyClientCfg.class)
public class CurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
    }

}
