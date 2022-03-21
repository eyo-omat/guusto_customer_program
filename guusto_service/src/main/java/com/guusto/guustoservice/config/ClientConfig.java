package com.guusto.guustoservice.config;

import com.guusto.guustoservice.model.Client;
import com.guusto.guustoservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository) {
        return args -> {
            Client client1 = Client.builder()
                    .clientId(1L)
                    .balance(100.00)
                    .build();
            Client client2 = Client.builder()
                    .clientId(2L)
                    .balance(0.00)
                    .build();
            Client client3 = Client.builder()
                    .clientId(3L)
                    .balance(90.00)
                    .build();

            repository.saveAll(
                    Arrays.asList(client1, client2, client3)
            );

        };
    }
}
