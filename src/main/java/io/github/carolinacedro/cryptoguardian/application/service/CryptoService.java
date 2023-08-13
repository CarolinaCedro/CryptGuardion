package io.github.carolinacedro.cryptoguardian.application.service;

public interface CryptoService {
    String encrypt(String data);

    String decrypt(String encryptedData);
}
