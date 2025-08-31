package org.movie.main.swaggertestbootapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientTestServiceConfig {

    @Value("${test.service.url}")
    private String testServiceUrl;

    @Bean
    public RestClient  userClientFullName(RestClient.Builder restClient) {
        System.out.println("RestClient.Builder: " + restClient.getClass());
        return restClient.baseUrl(testServiceUrl).build();
    }
}
