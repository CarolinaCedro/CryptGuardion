package io.github.carolinacedro.cryptoguardian.application.controller;

import io.github.carolinacedro.cryptoguardian.application.model.Client;
import io.github.carolinacedro.cryptoguardian.application.model.CryptoConvertion;
import io.github.carolinacedro.cryptoguardian.application.service.AbstractModelService;
import io.github.carolinacedro.cryptoguardian.application.service.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController extends AbstractController<Client> {

    private final ClientServiceImpl service;
    private final CryptoConvertion convertion = new CryptoConvertion();

    public ClientController(CryptoConvertion convertion, ClientServiceImpl service) {
        super(convertion);
        this.service = service;
    }


    @Override
    protected AbstractModelService<Client> getService() {
        return this.service;
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client body) {

        body.setCreditCardtoken(convertion.encrypt(body.getCreditCardtoken()));
        body.setUserDocument(convertion.encrypt(body.getUserDocument()));
        return ResponseEntity.ok(service.save(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findById(@PathVariable Long id) {
        Optional<Client> dataResponse = getService().findById(id);
        if (dataResponse.isPresent()) {
            dataResponse.get().setUserDocument(convertion.decrypt(dataResponse.get().getUserDocument()));
            dataResponse.get().setCreditCardtoken(convertion.decrypt(dataResponse.get().getCreditCardtoken()));
            return ResponseEntity.ok(dataResponse);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


}
