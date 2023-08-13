package io.github.carolinacedro.cryptoguardian.application.service;

import io.github.carolinacedro.cryptoguardian.application.model.CryptoConvertion;

public abstract class CryptoServiceImpl implements CryptoService {

    private final CryptoConvertion convertion;

    public CryptoServiceImpl(CryptoConvertion convertion) {
        this.convertion = convertion;
    }

    @Override
    public String encrypt(String data) {
        return convertion.encrypt(data);
    }
    @Override
    public String decrypt(String encryptedData) {
        return convertion.decrypt(encryptedData);
    }
}
