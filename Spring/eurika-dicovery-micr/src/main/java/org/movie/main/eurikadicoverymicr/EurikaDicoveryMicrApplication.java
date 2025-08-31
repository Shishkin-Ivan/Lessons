package org.movie.main.eurikadicoverymicr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurikaDicoveryMicrApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurikaDicoveryMicrApplication.class, args);
    }

}
