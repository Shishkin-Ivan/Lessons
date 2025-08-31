package org.movie.main.swaggertestbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/swagger")
public class Controller {

    private final RestClient restClient;

    public Controller(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping
    public String index() {
        return "I am a port 8082";
    }

    @GetMapping("/to81")
    public String fromRestToSwagger() {
        return restClient.get()
                .uri("/hello")
                .retrieve()
                .body(String.class);
    }
}
