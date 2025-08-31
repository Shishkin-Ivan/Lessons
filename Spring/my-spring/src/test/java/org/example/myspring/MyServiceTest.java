package org.example.myspring;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest(httpPort = 8089) // Поднимаем фейковый сервер на порту 8089
class MyServiceTest {

    private final WebClient webClient = WebClient.create("http://localhost:8089");

    @Test
    void testMockedApi() {
        // Настраиваем мок: если придёт GET /hello, вернуть "Hello World!"
        stubFor(get(urlEqualTo("/hello"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello World!")));

        // Делаем запрос в "фейковый" сервис
        String response = webClient.get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Проверяем
        assertThat(response).isEqualTo("Hello World!");
    }
}