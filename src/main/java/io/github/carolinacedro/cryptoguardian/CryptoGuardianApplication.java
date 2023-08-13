package io.github.carolinacedro.cryptoguardian;

import io.github.carolinacedro.cryptoguardian.application.model.CryptoConvertion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CryptoGuardianApplication {

    @Bean
    public CryptoConvertion convertion() {
        return new CryptoConvertion();
    }


    public static void main(String[] args) {

        SpringApplication.run(CryptoGuardianApplication.class, args);
    }
}
