package org.example.myspring;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest(httpPort = 8089) // WireMock слушает на 8089
public class MyServiceTestRest {

    private final RestClient restClient = RestClient.create("http://localhost:8089");

    @Test
    void testCallExternalApi() {
        // given: мок внешнего API
        stubFor(get("/hello")
                .willReturn(ok("Hello from WireMock!")));

        // when: вызываем сервис
        String response = restClient.get()
                .uri("/hello")
                .retrieve()
                .body(String.class);

        // then: проверяем результат
        assertThat(response).isEqualTo("Hello from WireMock!");
    }
}
