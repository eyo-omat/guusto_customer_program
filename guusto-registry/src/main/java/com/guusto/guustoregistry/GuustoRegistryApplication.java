package com.guusto.guustoregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GuustoRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuustoRegistryApplication.class, args);
    }

}
