package io.github.carolinacedro.cryptoguardian.application.model;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class CryptoConvertion {
    private final SecretKey secretKey;

    public CryptoConvertion() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error initializing secret key", e);
        }
    }


    public String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES"); // Cria uma instância do algoritmo de criptografia AES
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // Inicializa o algoritmo para modo de criptografia usando a chave secreta
            byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8)); // Executa a criptografia dos bytes dos dados
            return Base64.getEncoder().encodeToString(encryptedBytes); // Converte os bytes criptografados em uma string base64
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES"); // Cria uma instância do algoritmo de criptografia AES
            cipher.init(Cipher.DECRYPT_MODE, secretKey); // Inicializa o algoritmo para modo de descriptografia usando a chave secreta
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData)); // Executa a descriptografia dos bytes criptografados
            return new String(decryptedBytes, StandardCharsets.UTF_8); // Converte os bytes descriptografados de volta para texto
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
