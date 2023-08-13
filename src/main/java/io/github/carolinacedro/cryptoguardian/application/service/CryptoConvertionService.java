package io.github.carolinacedro.cryptoguardian.application.service;

import io.github.carolinacedro.cryptoguardian.application.model.CryptoConvertion;
import org.springframework.stereotype.Service;


@Service
public class CryptoConvertionService implements CryptoService {

    private final CryptoConvertion convertion = new CryptoConvertion();

    @Override
    public String encrypt(String data) {
        return convertion.encrypt(data);
    }

    @Override
    public String decrypt(String encryptedData) {
        return convertion.decrypt(encryptedData);
    }
}
