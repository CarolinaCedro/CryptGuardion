package io.github.carolinacedro.cryptoguardian.application.model;

/*
*   id: Identificador único do cliente.
    userDocument: Um documento de identificação pessoal do cliente.
    creditCardToken: Um token que provavelmente representa um número de cartão de crédito.
    value:Um valor associado a esse cliente (talvez o saldo na conta bancária). //NÃO SE PODE USAR VALUE COMO NOME DE ATRIBUTO POIS É UMA PALAVRA RESERVADA
* */

import io.github.carolinacedro.cryptoguardian.application.service.CryptoServiceImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userDocument;
    private String creditCardtoken;
    private Long accountBalance;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserDocument() {
//        CryptoConvertion convertion = new CryptoConvertion();
//        return convertion.decrypt(this.userDocument);
//    }
//
//    public void setUserDocument(String userDocument) {
//        CryptoConvertion convertion = new CryptoConvertion();
//        this.userDocument = convertion.encrypt(userDocument);
//    }
//
//    public String getCreditCardtoken() {
//        CryptoConvertion convertion = new CryptoConvertion();
//        return convertion.decrypt(this.creditCardtoken);
//    }
//
//    public void setCreditCardtoken(String creditCardtoken) {
//        CryptoConvertion convertion = new CryptoConvertion();
//        this.creditCardtoken = convertion.encrypt(creditCardtoken);
//    }
//
//    public Long getAccountBalance() {
//        return accountBalance;
//    }
//
//    public void setAccountBalance(Long accountBalance) {
//        this.accountBalance = accountBalance;
//    }
}
