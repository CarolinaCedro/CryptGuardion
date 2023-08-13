package io.github.carolinacedro.cryptoguardian.application.model;

public interface CryptoService {
    String encrypt(String data);

    String decrypt(String encryptedData);
}
